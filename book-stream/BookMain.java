package com.gtxc.practice.bookordering;

/*
    Created by gt at 3:18 AM on Monday, February 21, 2022.
    Project: practice, Package: com.gtxc.practice.bookordering.
*/

import java.util.*;
import java.util.stream.Collectors;

public class BookMain {

    public static void main(String[] args) {

        Set<Book> bookList = new ArrayList<>();
        bookList.add(new Book("The C Programming Language", 288, "Dennis M. Ritchie, Ken Thompson", 1972));
        bookList.add(new Book("Design Patterns", 395, "Erich Gamma, John Vlissides, Richard Helm, Ralph Johnson", 1994));
        bookList.add(new Book("Fight Club", 208, "Chuck Palahniuk", 1996));
        bookList.add(new Book("RTFM: Red Team Field Manual", 96, "Ben Clark", 2014));
        bookList.add(new Book("BTFM: Blue Team Field Manual", 134, "Alan White, Ben Clark", 2017));
        bookList.add(new Book("Java", 100, "dummy1", 2022));
        bookList.add(new Book("Javascript", 150, "dummy2", 2022));
        bookList.add(new Book("SQL", 200, "dummy3", 2022));
        bookList.add(new Book("Spring Boot", 250, "dummy4", 2022));
        bookList.add(new Book("GoLang", 300, "dummy5", 2022));

        Map<String, String> bookAuthor = new HashMap<>();
        bookList.forEach(book -> bookAuthor.put(book.getTitle(), book.getAuthor()));

        List<Book> bookPagesGreaterThan100 = bookList.stream().filter(book -> book.getNumberOfPages() > 100).collect(Collectors.toList());
    }
}
