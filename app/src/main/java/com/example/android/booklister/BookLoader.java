package com.example.android.booklister;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class BookLoader extends AsyncTaskLoader<List<Book>>
{
    // Variable for holding url
    private String mUrl;

    /**
     * Constructor for the Book Loader
     * @param context - Context for the activity
     * @param url - url to fetch data from in the background
     */
    public BookLoader(Context context, String url)
    {
        // Call the super
        super(context);

        // Set the mUrl variable
        mUrl = url;
    }

    /**
     * Method when loader starts
     * this forces the loader to start
     */
    @Override
    protected void onStartLoading()
    {
        // Forces load to start
        forceLoad();
    }

    /**
     * This is what the loader does in the background
     * @return
     */
    @Override
    public List<Book> loadInBackground()
    {
        // Check to make sure url isn't empty
        if(mUrl == null)
        {
            return null;
        }

        // Get data from the url
        return QueryUtils.fetchQueryData(mUrl);
    }
}
