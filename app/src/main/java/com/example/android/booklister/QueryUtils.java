package com.example.android.booklister;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
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
                    authors += authorsJson.getString(j) + " ";
                }

                // Add it all to the books array
                Book book = new Book(authors, title, rating, url);
                books.add(book);
            }
        }
        catch(JSONException e)
        {
            Log.e(LOG_TAG, "Problem parsing book JSON data", e);
        }
        return books;
    }

}
