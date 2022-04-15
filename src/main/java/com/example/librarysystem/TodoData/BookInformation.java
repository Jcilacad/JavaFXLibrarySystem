package com.example.librarysystem.TodoData;

import javafx.beans.property.SimpleStringProperty;

public class BookInformation {

    private SimpleStringProperty title = new SimpleStringProperty("");
    private SimpleStringProperty author = new SimpleStringProperty("");
    private SimpleStringProperty theme = new SimpleStringProperty("");
    private SimpleStringProperty quantity = new SimpleStringProperty("");


    public BookInformation(String title, String author, String theme, String quantity) {
        this.title.set(title);
        this.author.set(author);
        this.theme.set(theme);
        this.quantity.set(quantity);
    }


    public String getQuantity() {
        return quantity.get();
    }

    public SimpleStringProperty quantityProperty() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity.set(quantity);
    }

    public String getTitle() {
        return title.get();
    }

    public SimpleStringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getAuthor() {
        return author.get();
    }

    public SimpleStringProperty authorProperty() {
        return author;
    }

    public void setAuthor(String author) {
        this.author.set(author);
    }

    public String getTheme() {
        return theme.get();
    }

    public SimpleStringProperty themeProperty() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme.set(theme);
    }

    public void reserveBook(int deductedQuantity) {
        int val = Integer.parseInt(getQuantity()) - deductedQuantity;
        setQuantity(String.valueOf(val));
    }

    public void addBook (int quantity) {
        int newValue = (Integer.parseInt(getQuantity()) + quantity);
        setQuantity(String.valueOf(newValue));
    }

    @Override
    public String toString() {
        return "Title: " + getTitle() + "\t\t" + "Author: " + getAuthor() + "\t\t" + "Theme: " + getTheme() + "\t\t" + "Quantity: " + getQuantity();
    }

}
