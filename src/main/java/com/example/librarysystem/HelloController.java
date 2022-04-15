package com.example.librarysystem;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Optional;

public class HelloController {

    @FXML
    private BorderPane mainPane;

    @FXML
    public void initialize() {
    }

    @FXML
    public void exitHandleAction() {
        Platform.exit();
    }

    @FXML
    public void addBook() throws IOException {

        Dialog dialog = new Dialog();
        dialog.initOwner(mainPane.getScene().getWindow());
        dialog.setTitle("Add Book");
        dialog.setHeaderText("Create Book Information");

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

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            BookController bookController = fxmlLoader.getController();
            bookController.addBook();
        }
    }

    @FXML
    public void updateBook() throws IOException {

        Dialog dialog = new Dialog();
        dialog.initOwner(mainPane.getScene().getWindow());
        dialog.setTitle("Edit Book");
        dialog.setHeaderText("Type Book Information");

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("checkBook.fxml"));

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);


        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            CheckBookController controller = fxmlLoader.getController();
            controller.updateBook();
        }
    }

    @FXML
    public void deleteBook() throws IOException {

        Dialog dialog = new Dialog();
        dialog.initOwner(mainPane.getScene().getWindow());
        dialog.setTitle("Delete Book");
        dialog.setHeaderText("Type Book Information");

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("checkBook.fxml"));

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
            CheckBookController controller = fxmlLoader.getController();
            controller.deleteBook();
        }

    }

    @FXML
    public void findBook() throws IOException {

        Dialog dialog = new Dialog();
        dialog.initOwner(mainPane.getScene().getWindow());
        dialog.setTitle("Find Book");
        dialog.setHeaderText("Type Book Information");

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("checkBook.fxml"));

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());

        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
            CheckBookController controller = fxmlLoader.getController();
            controller.findBook();
        }


    }

    @FXML
    public void listOfBooks() throws IOException {


        Dialog dialog = new Dialog();
        dialog.initOwner(mainPane.getScene().getWindow());
        dialog.setTitle("List Of Books");
        dialog.setHeaderText(null);

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("listOfBooks.fxml"));


        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }


        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);


        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.CANCEL) {
            dialog.close();
        }
    }

    @FXML
    public void reserveStudent() throws IOException {

        Dialog dialog = new Dialog();
        dialog.initOwner(mainPane.getScene().getWindow());
        dialog.setTitle("Reserve Student");
        dialog.setHeaderText("Fill The Information below for The Student Reservation of Book/s");

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("reserveStudent.fxml"));

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();

        if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
            ReserveStudentController controller = fxmlLoader.getController();
            if (controller.checkRecord()) {
                boolean flag = controller.processResult();

                if (flag) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Reserved a Book!");
                    alert.showAndWait();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Message");
                alert.setHeaderText(null);
                alert.setContentText("Couldn't find the book!");
                alert.showAndWait();
            }
        }
    }

    @FXML
    public void unreserveStudent() throws IOException {

        Dialog dialog = new Dialog();
        dialog.initOwner(mainPane.getScene().getWindow());
        dialog.setTitle("Unreserve Student");
        dialog.setHeaderText("Fill The Information below for The Student Unreservation of Book/s");

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("unreserveStudent.fxml"));

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();

        if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
            UnreserveStudentController controller = fxmlLoader.getController();
            controller.processResult();
        }

    }

    @FXML
    public void listOfBorrowers() throws IOException {

        Dialog dialog = new Dialog();
        dialog.initOwner(mainPane.getScene().getWindow());
        dialog.setTitle("List of Borrowers");
        dialog.setHeaderText(null);

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("listOfBorrowers.fxml"));

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.showAndWait();
    }

    @FXML
    public void aboutSystem() throws IOException {
        Dialog dialog = new Dialog();
        dialog.initOwner(mainPane.getScene().getWindow());
        dialog.setTitle("About The System");
        dialog.setHeaderText("ABOUT THE SYSTEM");

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("aboutSystem.fxml"));

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);

        dialog.showAndWait();

    }
}