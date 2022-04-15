package com.example.librarysystem.TodoData;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class BookList {

    private static String filename = "bookInformation.txt";
    private static BookList instance = new BookList();
    private ObservableList<BookInformation> bookList;

    public static BookList getInstance() {
        return instance;
    }


    public BookList() {
        bookList = FXCollections.observableArrayList();
    }

    public ObservableList<BookInformation> getBookList () {
        return bookList;
    }

    @FXML
    public void addBook(BookInformation bookInformation) {
        bookList.add(bookInformation);
    }

    @FXML
    public void removeBook(BookInformation bookInformation) {
        bookList.remove(bookInformation);
    }

    public void loadBookInformation() throws IOException {

        Path path = Paths.get(filename);
        BufferedReader br = Files.newBufferedReader(path);

        String input;

        try {
            while ((input = br.readLine()) != null) {
                String[] words = input.split("\t");
                String title = words[0];
                String author = words[1];
                String theme = words[2];
                String quantity = words[3];

                BookInformation bookInformation = new BookInformation(title, author, theme, quantity);
                bookList.add(bookInformation);
            }


        } finally {
            if (br != null) {
                br.close();
            }
        }


    }

    public void storeBookInformation() throws IOException {
        Path path = Paths.get(filename);
        BufferedWriter bw = Files.newBufferedWriter(path);

        try {
            Iterator<BookInformation> iterator = bookList.iterator();
            while (iterator.hasNext()) {
                BookInformation bookInformation = iterator.next();
                bw.write(String.format("%s\t%s\t%s\t%s", bookInformation.getTitle(), bookInformation.getAuthor(), bookInformation.getTheme(), bookInformation.getQuantity()));
                bw.newLine();
            }
        } finally {
            if (bw != null) {
                bw.close();
            }
        }
    }


    @FXML
    public void updateBook(String title, String author, String theme, String quantity) {

    }

    @FXML
    public BookInformation checkBook(String title, String author) {

        for (BookInformation bookInformation : bookList) {
            if (bookInformation.getTitle().equals(title) && bookInformation.getAuthor().equals(author)) {
                return bookInformation;
            }
        }
        return null;
    }

    @FXML
    public BookInformation checkBook(String title, String author, String theme) {

        for (BookInformation bookInformation : bookList) {
            if (bookInformation.getTitle().equals(title) && bookInformation.getAuthor().equals(author) && bookInformation.getTheme().equals(theme)) {
                return bookInformation;
            }
        }
        return null;
    }

    @FXML
    public void deleteBook(BookInformation bookInformation) {
        bookList.remove(bookInformation);
    }

}
