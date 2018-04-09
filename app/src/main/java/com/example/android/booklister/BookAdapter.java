package com.example.android.booklister;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends ArrayAdapter<Book>
{
    private Context mContext;
    private List<Book> bookList;

    public BookAdapter(@NonNull Activity context, ArrayList<Book> list)
    {
        super(context, 0, list);
        mContext = context;
        bookList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        // Gets the current view
        View listItem = convertView;

        // Get the current book
        final Book currentBook = bookList.get(position);

        // Setup variables for display
        String author = currentBook.getAuthor();
        String title  = currentBook.getTitle();

        String rating;

        if(currentBook.getRating() < 0.0)
        {
            rating = "N/A";
        }
        else
        {
            rating = Double.toString(currentBook.getRating());
        }

        // Inflate the list item if it is null
        if(listItem == null)
        {
            listItem = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);
        }

        // Get all the views
        TextView authorView = listItem.findViewById(R.id.author_view);
        TextView titleView = listItem.findViewById(R.id.title_view);
        TextView ratingView = listItem.findViewById(R.id.rating_view);

        // Setting appropriate text values for views
        authorView.setText(author);
        titleView.setText(title);
        ratingView.setText(rating);

        return listItem;
    }
}
