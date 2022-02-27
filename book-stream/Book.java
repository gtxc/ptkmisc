package com.gtxc.practice.bookordering;

/*
    Created by gt at 3:15 AM on Monday, February 21, 2022.
    Project: practice, Package: com.gtxc.practice.bookordering.
*/

public class Book implements Comparable<Book> {

    private String title;
    private int numberOfPages;
    private String author;
    private int publishedYear;

    public Book(String title, int numberOfPages, String author, int publishedYear) {
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.author = author;
        this.publishedYear = publishedYear;
    }

    @Override
    public int compareTo(Book book) {
        return this.title.compareTo(book.getTitle());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    @Override
    public String toString() {
        return title + ", " + numberOfPages + ", " + author + ", " + publishedYear;
    }
}
