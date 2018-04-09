package com.example.android.booklister;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

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
        mAdapter.addAll(QueryUtils.fetchQueryData(mBooksUrl));

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
}
