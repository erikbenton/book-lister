package com.example.android.booklister;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.app.LoaderManager.LoaderCallbacks;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderCallbacks<List<Book>>
{
    // ListView for main activity
    private ListView mListView;

    // Empty view for the List
    private TextView mEmptyView;

    // Progress Bar view
    private ProgressBar mProgressBar;

    // Adapter for the books
    private BookAdapter mAdapter;

    // Query input
    private EditText mQueryInput;

    // Query Button
    private Button mQueryButton;

    // Url for getting book data
    private String mBooksUrl = "";// "https://www.googleapis.com/books/v1/volumes?q=programming";

    private Context mContext;

    // Book loader ID
    private static final int BOOK_LOADER_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set context
        mContext = this;

        // Checking the status of the internet connection
        // Set up a connectivity manager
        ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

        // Check if network active
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        // Boolean for if the internet connection is active
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();

        // Get the ListView, EmptyView, ProgressBar, and EditText
        mListView    = findViewById(R.id.list);
        mEmptyView   = findViewById(R.id.empty_view);
        mProgressBar = findViewById(R.id.loading_spinner);
        mQueryInput  = findViewById(R.id.query_field);
        mQueryButton = findViewById(R.id.query_button);

        // Set up the EmptyView
        mListView.setEmptyView(mEmptyView);
        mEmptyView.setText("Search for books");

        // Set up the adapter
        mAdapter = new BookAdapter(this, new ArrayList<Book>());

        mListView.setAdapter(mAdapter);

        // If we are connected we are good to go
        if(isConnected)
        {
            // Declare loaderManager
            final LoaderManager loaderManager = getLoaderManager();

            mQueryButton.setOnClickListener(new Button.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    String query = mQueryInput.getText().toString();
                    mBooksUrl = "https://www.googleapis.com/books/v1/volumes?q=" + query;
                    // Starting a loader manager


                    // Init the loader
                    loaderManager.initLoader(BOOK_LOADER_ID, null, MainActivity.this);
                }
            });

        }
        else // If not, tell the user
        {
            // Hide ProgressBar
            mProgressBar.setVisibility(View.GONE);

            // Tell the user there is no internet
            mEmptyView.setText(R.string.no_internet_text);
        }

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

        // Hide the Progress Bar
        mProgressBar.setVisibility(View.GONE);

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
