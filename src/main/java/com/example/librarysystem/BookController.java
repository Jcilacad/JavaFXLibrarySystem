package com.example.librarysystem;

import com.example.librarysystem.TodoData.BookInformation;
import com.example.librarysystem.TodoData.BookList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class BookController {

    @FXML
    private TextField titleField;

    @FXML
    private TextField authorField;

    @FXML
    private TextField themeField;

    @FXML
    private TextField quantityField;


    @FXML
    public void addBook () {
        String title = titleField.getText().trim();
        String author = authorField.getText().trim();
        String theme = themeField.getText().trim();
        String quantity = quantityField.getText().trim();

        BookInformation addedBook = BookList.getInstance().checkBook(title, author, theme);
        if (addedBook != null) {
            addedBook.addBook(Integer.parseInt(quantity));
            return;
        }

        BookInformation bookInformation = new BookInformation(title, author, theme, quantity);
        BookList.getInstance().addBook(bookInformation);
    }

    @FXML
    public void printInField(BookInformation bookInformation) {
        titleField.setText(bookInformation.getTitle());
        authorField.setText(bookInformation.getAuthor());
        themeField.setText(bookInformation.getTheme());
        quantityField.setText(bookInformation.getQuantity());
    }

    @FXML
    public void updateBook (BookInformation bookInformation) {
        bookInformation.setTitle(titleField.getText().trim());
        bookInformation.setAuthor(authorField.getText().trim());
        bookInformation.setTheme(themeField.getText().trim());
        bookInformation.setQuantity(quantityField.getText().trim());
    }


}
