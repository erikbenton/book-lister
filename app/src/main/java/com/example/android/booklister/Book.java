package com.example.android.booklister;

public class Book
{
    private String mAuthor;
    private String mTitle;
    private double mRating;
    private String mUrl;

    /**
     * Simple constructor for a Book
     * @param author - Author of the book
     * @param title - Title of the book
     * @param rating - Rating of the book
     * @param url - Google URL for the book
     */
    public Book(String author, String title, double rating, String url)
    {
        mAuthor = author;
        mTitle  = title;
        mRating = rating;
        mUrl    = url;
    }

    /**
     * Gets the author of the book
     * @return author
     */
    public String getAuthor()
    {
        return mAuthor;
    }

    /**
     * Gets the title of the book
     * @return title
     */
    public String getTitle()
    {
        return mTitle;
    }

    /**
     * Gets the rating of the book
     * @return rating
     */
    public double getRating()
    {
        return mRating;
    }

    /**
     * Gets the Google URL for the book
     * @return url
     */
    public String getUrl()
    {
        return mUrl;
    }

}
