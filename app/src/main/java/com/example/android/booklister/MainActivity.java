package com.example.android.booklister;

import android.content.AsyncTaskLoader;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    // ListView for main activity
    private ListView mListView;
    private BookAdapter mAdapter;

    private String mBooksUrl = "https://www.googleapis.com/books/v1/volumes?q=programming";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the ListView
        mListView = findViewById(R.id.list);

        // Set up the adapter
        mAdapter = new BookAdapter(this, new ArrayList<Book>());

        mListView.setAdapter(mAdapter);

        BookAsyncTask bookAsyncTask = new BookAsyncTask();
        bookAsyncTask.execute(mBooksUrl);

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
     * Creating an Async Task since network can't be accessed on Main Thread
     */
    private class BookAsyncTask extends AsyncTask<String, Void, List<Book>>
    {
        /**
         * Background request for data
         * @param urls - URL to fetch data from
         * @return
         */
        @Override
        protected List<Book> doInBackground(String... urls)
        {
            // Check to make sure urls isn't empty
            if(urls.length < 1 || urls[0] == null)
            {
                return null;
            }

            return QueryUtils.fetchQueryData(urls[0]);

        }

        /**
         * After the background task is done, add books to adapter
         * @param books
         */
        @Override
        protected void onPostExecute(List<Book> books)
        {
            if(books == null)
            {
                return;
            }

            mAdapter.addAll(books);
        }
    }

}
