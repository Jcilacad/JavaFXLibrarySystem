package com.example.librarysystem.TodoData;

import javafx.scene.control.Alert;

public class StudentInformation {

    private String idNumber;
    private String name;
    private String section;
    private String phoneNumber;
    private String title;
    private String author;
    private String reserveBooks;

    public StudentInformation(String idNumber, String name, String section, String phoneNumber, String title, String author, String reserveBooks) {
        this.idNumber = idNumber;
        this.name = name;
        this.section = section;
        this.phoneNumber = phoneNumber;
        this.author = author;
        this.title = title;
        this.reserveBooks = reserveBooks;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReserveBooks() {
        return reserveBooks;
    }

    public void setReserveBooks(String reserveBooks) {
        this.reserveBooks = reserveBooks;
    }

    public int unreserveBook(String title, String author, int quantity) {

        if (quantity <= Integer.parseInt(getReserveBooks())) {

            BookInformation bookInformation = checkBook(title, author);
            if (bookInformation != null) {
                bookInformation.addBook(quantity);
                if (quantity == Integer.parseInt(getReserveBooks())) {
                    return 0;
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Message");
                alert.setHeaderText(null);
                alert.setContentText("Couldn't find the book");
                alert.showAndWait();
            }

            int newValue = (Integer.parseInt(getReserveBooks()) - quantity);
            setReserveBooks(String.valueOf(newValue));
            return 1;
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Message");
            alert.setHeaderText(null);
            alert.setContentText("Couldn't unreserve an item which exceed to the number of items you've been reserved.");
            alert.showAndWait();
            return 2;
        }
    }

    public void addReserveItem(int quantity) {
        int newValue = Integer.parseInt(getReserveBooks()) + quantity;
        setReserveBooks(String.valueOf(newValue));
    }

    @Override
    public String toString() {
        return "ID Number: " + this.idNumber + "  " + "Name: " + this.name + "  " + "Section: " + this.section + "  " + "Phone Number: " + this.phoneNumber + "  " + "Title: " + this.title + "  " + "Reserved Books: " + this.reserveBooks;
    }

    private BookInformation checkBook(String title, String author) {
        for (BookInformation bookInformation : BookList.getInstance().getBookList()) {
            if ((bookInformation.getTitle().equals(title) && (bookInformation.getAuthor().equals(author)))) {
                return bookInformation;
            }
        }
        return null;
    }
}
