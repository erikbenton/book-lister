package com.example.android.booklister;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.app.LoaderManager.LoaderCallbacks;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderCallbacks<List<Book>>
{
    // ListView for main activity
    private ListView mListView;

    // Empty view for the List
    private TextView mEmptyView;

    // Adapter for the books
    private BookAdapter mAdapter;

    // Url for getting book data
    private String mBooksUrl = "https://www.googleapis.com/books/v1/volumes?q=programming";

    // Book loader ID
    private static final int BOOK_LOADER_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the ListView and its Empty View
        mListView = findViewById(R.id.list);
        mEmptyView = findViewById(R.id.empty_view);

        mListView.setEmptyView(mEmptyView);

        // Set up the adapter
        mAdapter = new BookAdapter(this, new ArrayList<Book>());

        mListView.setAdapter(mAdapter);

        // Set Click Listener on each item so that when clicked
        // It goes to the "Info URL" of the book
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                // Get the book at the current position
                Book book = mAdapter.getItem(position);

                // Get the url from the Book
                String url = book.getUrl();

                //Create Intent to open browser to URL
                Intent openWebpage = new Intent(Intent.ACTION_VIEW);
                openWebpage.setData(Uri.parse(url));
                startActivity(openWebpage);
            }
        });

        // Starting a loader manager
        LoaderManager loaderManager = getLoaderManager();

        // Init the loader
        loaderManager.initLoader(BOOK_LOADER_ID, null, this);
    }

    /**
     * Creating a new Loader
     * @param id - Id for the loader
     * @param args
     * @return Loader
     */
    @Override
    public Loader<List<Book>> onCreateLoader(int id, Bundle args)
    {
        // Create a new Book Loader with URL for books
        return new BookLoader(this, mBooksUrl);
    }

    /**
     * Method for adding all the books to the adapter after
     * all the loader has finished
     * @param loader - Loader responsible for getting data
     * @param books - List of books loader returns
     */
    @Override
    public void onLoadFinished(Loader<List<Book>> loader, List<Book> books)
    {
        // Clear the adapter before filling it up
        mAdapter.clear();

        if(books != null && !books.isEmpty())
        {
            mAdapter.addAll(books);
        }
        else // Tell the user there are no books found
        {
            mEmptyView.setText(R.string.empty_view_text);
        }
    }

    /**
     * Method responsible for when the loader is reset
     * Clears all the adapter data
     * @param loader - Loader that has been reset
     */
    @Override
    public void onLoaderReset(Loader<List<Book>> loader)
    {
        // Clear the adapter
        mAdapter.clear();
    }
}
