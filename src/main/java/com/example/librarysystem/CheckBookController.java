package com.example.librarysystem;

import com.example.librarysystem.TodoData.BookInformation;
import com.example.librarysystem.TodoData.BookList;
import com.example.librarysystem.TodoData.StudentInformation;
import com.example.librarysystem.TodoData.StudentList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.Optional;

public class CheckBookController {

    @FXML
    private TextField titleField;

    @FXML
    private TextField authorField;

    @FXML
    private TextField themeField;


    @FXML
    public void updateBook() throws IOException {

        String title = titleField.getText().trim();
        String author = authorField.getText().trim();
        String theme = themeField.getText().trim();

        BookInformation selectedBook = BookList.getInstance().checkBook(title, author, theme);

        if (selectedBook != null) {
            Dialog dialog = new Dialog();
            dialog.setTitle("Edit: " + selectedBook.getTitle() + " of " + selectedBook.getAuthor());

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("bookInformation.fxml"));

            try {
                dialog.getDialogPane().setContent(fxmlLoader.load());
            } catch (IOException e) {
                System.out.println("Couldn't load the dialog");
                e.printStackTrace();
                return;
            }

            dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
            dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

            BookController controller = fxmlLoader.getController();
            controller.printInField(selectedBook);


            Optional<ButtonType> result = dialog.showAndWait();
            if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
                controller.updateBook(selectedBook);
            }


        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Couldn't find the book");

            alert.showAndWait();
        }
    }

    @FXML
    public void deleteBook() {

        String title = titleField.getText().trim();
        String author = authorField.getText().trim();
        String theme = themeField.getText().trim();
        BookInformation selectedBook = BookList.getInstance().checkBook(title, author, theme);

        if (selectedBook != null) {
            BookList.getInstance().deleteBook(selectedBook);

            for (StudentInformation studentInformation : StudentList.getInstance().getStudentList()) {
                if (studentInformation.getTitle().equals(title)) {
                    StudentList.getInstance().deleteStudentInformation(studentInformation);
                }
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText(selectedBook.getTitle() + " Successfully Deleted!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Couldn't find the book");

            alert.showAndWait();
        }
    }

    @FXML
    public void findBook() {

        String title = titleField.getText().trim();
        String author = authorField.getText().trim();
        String theme = themeField.getText().trim();
        BookInformation selectedBook = BookList.getInstance().checkBook(title, author, theme);

        if (selectedBook != null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Find Book");
            alert.setHeaderText("Successfully Found the Book");
            alert.setContentText("\t\tBook Information\n\n" +
                    "\t\tTitle: " + selectedBook.getTitle() + "\n" +
                    "\t\tAuthor: " + selectedBook.getAuthor() + "\n" +
                    "\t\tTheme: " + selectedBook.getTheme() + "\n" +
                    "\t\tAvailable Stock: " + selectedBook.getQuantity());
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Couldn't find the book");
            alert.showAndWait();
        }
    }
}
