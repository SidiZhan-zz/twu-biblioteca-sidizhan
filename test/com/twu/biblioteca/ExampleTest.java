package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.*;

public class ExampleTest {

    @Test
    public void test() {
        assertEquals(1, 1);
    }

    @Test
    public void listBooks(){
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.listBooks();
        ArrayList<Book> actual = bibliotecaApp.getBookList();
        BookQuerier bookQuerier = new BookQuerier();
        ArrayList<Book> expected = bookQuerier.fetchBooksFromCSV();
        assertEquals(expected.size(), actual.size());
    }

    @Test
    public void bookDetails(){
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String actual = bibliotecaApp.listBooks();
        String expected = "1	Roots of yoga	James Mallinson	2017\n"
            + "2	From yoga to Kabbalah : religious exoticism and the logics of bricolage	Véronique Altglas	2014\n"
            + "3	Gurus of modern yoga	Mark Singleton	2014\n";
        assertEquals(expected, actual);

    }

    @Test
    public void interfaceValidation(){
        //how?
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.showInterface();
    }

    @Test
    public void checkOutABookSuccessful(){
        BibliotecaApp bibliotecaApp = new BibliotecaApp();

        ArrayList<Book> expectedList = bibliotecaApp.getBookList(); //copy or new?
        Book checkedBook = expectedList.get(0);
        expectedList.remove(0);
        String expected = "2	From yoga to Kabbalah : religious exoticism and the logics of bricolage	Véronique Altglas	2014\n"
                + "3	Gurus of modern yoga	Mark Singleton	2014\n";

        bibliotecaApp.checkOutABook(checkedBook.getIndex());
        String actual = bibliotecaApp.listBooks();
        assertEquals(expected, actual); // cmp two arraylist??
    }

    @Test
    public void checkOutABookUnsuccessful(){
        BibliotecaApp bibliotecaApp = new BibliotecaApp();

        String expected = "1	Roots of yoga	James Mallinson	2017\n"
                + "2	From yoga to Kabbalah : religious exoticism and the logics of bricolage	Véronique Altglas	2014\n"
                + "3	Gurus of modern yoga	Mark Singleton	2014\n";

        ArrayList<Book> expectedList = bibliotecaApp.getBookList();
        bibliotecaApp.checkOutABook("4");
        String actual = bibliotecaApp.listBooks();
        assertEquals(expected, actual);
    }

    @Test
    public void returnABookSuccessful(){
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Book book = bibliotecaApp.getBookList().get(0);
        bibliotecaApp.checkOutABook(book.getIndex());

        // return
        String expected = "2	From yoga to Kabbalah : religious exoticism and the logics of bricolage	Véronique Altglas	2014\n"
                + "3	Gurus of modern yoga	Mark Singleton	2014\n"
                + "1	Roots of yoga	James Mallinson	2017\n";
        bibliotecaApp.returnABook(book.getName());
        String actual = bibliotecaApp.listBooks();
        assertEquals(expected, actual);
    }

    @Test
    public void returnABookUnsuccessful(){
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Book book = bibliotecaApp.getBookList().get(0);
        bibliotecaApp.checkOutABook(book.getIndex());

        // return
        String expected = "2	From yoga to Kabbalah : religious exoticism and the logics of bricolage	Véronique Altglas	2014\n"
                + "3	Gurus of modern yoga	Mark Singleton	2014\n";
        bibliotecaApp.returnABook("Gurus of modern yoga");
        String actual = bibliotecaApp.listBooks();
        assertEquals(expected, actual);
    }

    @Test
    public void listMoviesWithDetails(){
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String actual = bibliotecaApp.listMovies();
        String expected = "Inside Out\t2015\tPete Docter\t9\n" +
                "ALADDIN\t1992\tJohn Musker\tunrated\n" +
                "FROZEN\t2013\tJennifer Lee\t8\n";
        assertEquals(expected, actual);
    }

    @Test
    public void checkOutAMovieSuccessful(){
        BibliotecaApp bibliotecaApp = new BibliotecaApp();

        ArrayList<Movie> expectedList = bibliotecaApp.getMovieList(); //copy or new?
        Movie checkedMovie = expectedList.get(0);
        expectedList.remove(0);
        String expected = "ALADDIN\t1992\tJohn Musker\tunrated\n" +
                "FROZEN\t2013\tJennifer Lee\t8\n";

        bibliotecaApp.checkOutAMovie(checkedMovie.getName());
        String actual = bibliotecaApp.listMovies();
        assertEquals(expected, actual);
    }

    @Test
    public void logIn(){
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.logIn("111-1111,123");
        String actual = bibliotecaApp.getUser().getName();
        String expected = "Jannie Schneider";
        assertEquals(expected, actual);
    }

    public static void main(String args[]){
        ExampleTest exampleTest = new ExampleTest();

        exampleTest.listBooks();
        exampleTest.bookDetails();
        exampleTest.interfaceValidation();
        exampleTest.checkOutABookSuccessful();
        exampleTest.checkOutABookUnsuccessful();
        exampleTest.returnABookSuccessful();
        exampleTest.returnABookUnsuccessful();
        exampleTest.listMoviesWithDetails();
        exampleTest.checkOutAMovieSuccessful();
        exampleTest.logIn();
    }
}
