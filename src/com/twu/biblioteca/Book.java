package com.twu.biblioteca;

import java.util.*;

public class Book {
    String index;
    String name;
    String author;
    String yearPublished;

    /* cannot omit this empty constructor if a parameterized one is defined */
    public Book(){}

    public Book(String index, String name, String author, String yearPublished){
        this.index = index;
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
    }


    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(String yearPublished) {
        this.yearPublished = yearPublished;
    }

}
