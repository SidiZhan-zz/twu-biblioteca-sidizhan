package com.twu.biblioteca;

import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BookQuerier {
    public ArrayList<Book> fetchBooksFromCSV(){
        // data stored on current directory, as csv
        String fileName = "./data/"+"books.csv";
        BufferedReader br = null;
        String line = "";
        ArrayList<Book> bookList = new ArrayList<Book>();
        try{
            br = new BufferedReader(new FileReader(fileName));
            while((line = br.readLine())!= null){
                String[] bookAttributes = line.split(",");
                Book book = new Book(bookAttributes[0],bookAttributes[1],bookAttributes[2],bookAttributes[3]);
                bookList.add(book);
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(br!=null){
                try{
                    br.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        return bookList;
    }

    public ArrayList<Movie> fetchMoviesFromCSV(){
        // data stored on current directory, as csv
        String fileName = "./data/"+"movies.csv";
        BufferedReader br = null;
        String line = "";
        ArrayList<Movie> movieList = new ArrayList<Movie>();
        try{
            br = new BufferedReader(new FileReader(fileName));
            while((line = br.readLine())!= null){
                String[] movieAttributes = line.split(",");
                Movie movie = new Movie(movieAttributes[0],movieAttributes[1],movieAttributes[2],movieAttributes[3]);
                movieList.add(movie);
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(br!=null){
                try{
                    br.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        return movieList;
    }
}
