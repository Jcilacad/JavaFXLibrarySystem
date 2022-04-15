package com.example.librarysystem;

import com.example.librarysystem.TodoData.BookInformation;
import com.example.librarysystem.TodoData.BookList;
import com.example.librarysystem.TodoData.StudentInformation;
import com.example.librarysystem.TodoData.StudentList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;


public class ReserveStudentController {

    @FXML
    private TextField idNumber;

    @FXML
    private TextField name;

    @FXML
    private TextField section;

    @FXML
    private TextField contactNumber;

    @FXML
    private TextField titleOfBook;

    @FXML
    private TextField authorOfBook;

    @FXML
    private TextField quantity;


    @FXML
    public boolean processResult() {

        String id = idNumber.getText().trim();
        String n = name.getText().trim();
        String s = section.getText().trim();
        String cn = contactNumber.getText().trim();
        String tb = titleOfBook.getText().trim();
        String ab = authorOfBook.getText().trim();
        String q = quantity.getText().trim();

        StudentInformation studentInformation = checkStudent(id, n, s, cn, tb, ab);
        if (studentInformation != null) {

            BookInformation bookInformation = getBookInformation(tb, ab);

            if (Integer.parseInt(q) <= Integer.parseInt(bookInformation.getQuantity())) {
                bookInformation.reserveBook(Integer.parseInt(q));
                studentInformation.addReserveItem(Integer.parseInt(q));
                return true;
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Message");
                alert.setHeaderText(null);
                alert.setContentText("You Cannot Reserve an Item which exceed to the stock quantity");
                alert.showAndWait();
            }
            return false;
        } else {

            BookInformation bookInformation = getBookInformation(tb, ab);

            if (Integer.parseInt(q) <= Integer.parseInt(bookInformation.getQuantity())) {
                StudentList.getInstance().addStudentInformation(new StudentInformation(id, n, s, cn, tb, ab, q));
                bookInformation.reserveBook(Integer.parseInt(q));
                return true;
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Message");
                alert.setHeaderText(null);
                alert.setContentText("You Cannot Reserve an Item which exceed to the stock quantity");
                alert.showAndWait();

            }
            return false;
        }
    }

    @FXML
    public boolean checkRecord() {

        String title = titleOfBook.getText().trim();
        String author = authorOfBook.getText().trim();

        for (BookInformation bookInformation : BookList.getInstance().getBookList()) {
            if (bookInformation.getTitle().equals(title) && bookInformation.getAuthor().equals(author)) {
                return true;
            }
        }
        return false;
    }


    private BookInformation getBookInformation(String title, String author) {
        for (BookInformation bookInformation : BookList.getInstance().getBookList()) {
            if (bookInformation.getTitle().equals(title) && bookInformation.getAuthor().equals(author)) {
                return bookInformation;
            }
        }
        return null;
    }

    private StudentInformation checkStudent(String idNumber, String name, String section, String phoneNumber, String titleOfBook, String authorOfBook) {

        for (StudentInformation studentInformation : StudentList.getInstance().getStudentList()) {
            if ((studentInformation.getIdNumber().equals(idNumber)) && (studentInformation.getName().equals(name)) && (studentInformation.getSection().equals(section)) && (studentInformation.getPhoneNumber().equals(phoneNumber)) && (studentInformation.getTitle().equals(titleOfBook)) && (studentInformation.getAuthor().equals(authorOfBook))) {
                return studentInformation;
            }
        }
        return null;
    }
}


