package com.example.android.booklister;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public final class QueryUtils
{

    public static final String LOG_TAG = QueryUtils.class.getSimpleName();

    /**
     * Constructor - Private because no one should have to make a QueryUtils object
     */
    private QueryUtils()
    {
    }

    /**
     * Function for extracting the necessary JSON data
     * @param booksJson - JSON Strin data
     * @return The extracted books list
     */
    public static List<Book> extractBooks(String booksJson)
    {
        // If there is nothing in the JSON data
        // then return null
        if(TextUtils.isEmpty(booksJson))
        {
            return null;
        }

        // Create List for books
        List<Book> books = new ArrayList<>();

        // Try to parse the JSON string
        try
        {
            // First, turn it into JSON object
            JSONObject booksJsonObject = new JSONObject(booksJson);

            // Then turn into JSON Array
            JSONArray booksArray = booksJsonObject.getJSONArray("items");

            // For each entry in the array, extract the desired properties
            // Stop at first 25 results
            int numberOfEntries = booksArray.length();
            if(numberOfEntries > 25)
            {
                numberOfEntries = 25;
            }
            for(int i = 0; i < numberOfEntries; i++)
            {
                // Get the current book
                JSONObject currentBook = booksArray.getJSONObject(i);

                // Look in the volumeInfo for the data
                JSONObject volumeInfo = currentBook.getJSONObject("volumeInfo");

                // Get the data
                String title = volumeInfo.getString("title");
                String url = volumeInfo.getString("infoLink");

                // Some might not be rated
                // So set rating to -1 and if that is case
                // show "N/A" on listing
                double rating;
                try
                {
                    rating = volumeInfo.getDouble("averageRating");
                }
                catch(JSONException err)
                {
                    rating = -1.0;
                }

                // There could be more than one author
                // so join them all together
                JSONArray authorsJson = volumeInfo.getJSONArray("authors");
                String authors = "";
                for(int j = 0; j < authorsJson.length(); j++)
                {
                    // Adding coma after name if more than 1 author
                    if(j > 0)
                    {
                        authors += ", ";
                    }
                    authors += authorsJson.getString(j);
                }

                // Add it all to the books array
                books.add(new Book(authors, title, rating, url));
            }
        }
        catch(JSONException e)
        {
            Log.e(LOG_TAG, "Problem parsing book JSON data", e);
        }
        return books;
    }

    /**
     * Gets the necessary data from the requested URL
     * @param requestUrl - URL for the data
     * @return List of Books
     */
    public static List<Book> fetchQueryData(String requestUrl)
    {
        // Convert the requestUrl to actual URL
        URL url = createUrl(requestUrl);

        // Init the JSON Response String
        String jsonResponse = null;

        // Try to make an HTTP request for the JSON Response
        try
        {
            jsonResponse = makeHttpRequest(url);
        }
        catch(IOException err) // Catch error thrown by makeHttpRequest
        {
            Log.e(LOG_TAG, "Unable to make HTTP request", err);
        }

        // Extract the info for the books from the response
        List<Book> books = extractBooks(jsonResponse);

        return books;
    }

    /**
     * Creates the proper URL for the given url string
     * @param urlString - String of the url to be converted
     * @return url from given String
     */
    private static URL createUrl(String urlString)
    {
        // First, establish a URL object
        URL url = null;

        //Try to convert urlString to URL
        try
        {
            url = new URL(urlString);
        }
        catch(MalformedURLException err)
        {
            Log.e(LOG_TAG, "Could not convert url String to URL", err);
        }

        return url;

    }

    /**
     * makes the proper HTTP request based on the given url
     * @param url - URL for the HTTP request
     * @return JSON response from the HTTP request
     * @throws IOException
     */
    private static String makeHttpRequest(URL url) throws IOException
    {
        // First, init string for response
        String jsonResponse = "";

        // If given url is null, return null
        if(url == null)
        {
            return jsonResponse;
        }

        // Init an HttpUrlConnection and InputStream
        HttpURLConnection urlConnection = null;
        InputStream       inputStream   = null;

        // Try to create URL connection
        try
        {
            // Make connection
            urlConnection = (HttpURLConnection) url.openConnection();

            // Set a Read Timeout and Connect Timeout
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);

            // Set a GET request method
            urlConnection.setRequestMethod("GET");

            // Connect
            urlConnection.connect();

            // Check response code to verify it worked
            int responseCode = urlConnection.getResponseCode();

            // If the response code is good...
            if(responseCode == 200)
            {
                // Get an input stream from the connection
                inputStream = urlConnection.getInputStream();

                // Read the data from the stream into jsonResponse
                jsonResponse = readFromStream(inputStream);
            }
            else // The connection is bad...
            {
                // Log the response as an error
                Log.e(LOG_TAG, "Bad response code: " + responseCode);
            }
        }
        catch(IOException err) // Problem retrieving the data, log it
        {
            Log.e(LOG_TAG, "Problem retrieving book query results", err);
        }
        finally // After all that we close up shop
        {
            // If we were unable to connect, then connection is still null
            if(urlConnection == null)
            {
                urlConnection.disconnect();
            }

            // If we were able to connect, inputStream is open
            if(inputStream != null)
            {
                // So we close it
                // this could cause IOException to be thrown, hence the "throws IOException"
                inputStream.close();
            }
        }

        return jsonResponse;
    }

    /**
     * Converts the stream of data from HTTP request into a String
     * This String contains the whole JSON response
     * @param inputStream - Stream of data to be read
     * @return JSON data String
     * @throws IOException
     */
    private static String readFromStream(InputStream inputStream) throws IOException
    {
        // Create StringBuilder for creating string of data
        StringBuilder output = new StringBuilder();

        // Check if the inputStream is null
        if(inputStream != null)
        {
            // Create an InputStreamReader for reading input stream, duh...
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));

            // Create a buffered reader for reading in the inputStream
            BufferedReader reader = new BufferedReader(inputStreamReader);

            //Create a String for reading each line of BufferedReader
            String line = reader.readLine();

            // As long as the line isn't null, keep reading
            while(line != null)
            {
                // Add the output to the StringBuilder
                output.append(line);

                // Read another line
                line = reader.readLine();
            }
        }

        // Convert StringBuilder -> String and return it
        return output.toString();
    }

}
