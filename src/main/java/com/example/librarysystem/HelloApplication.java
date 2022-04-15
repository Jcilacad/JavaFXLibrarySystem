package com.example.librarysystem;

import com.example.librarysystem.TodoData.BookList;
import com.example.librarysystem.TodoData.StudentList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloApplication extends Application {

    @Override
    public void init() throws Exception {
        try {
            BookList.getInstance().loadBookInformation();
            StudentList.getInstance().loadStudentInformation();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // Ilacad

    @Override
    public void stop() throws Exception {
        try {
            BookList.getInstance().storeBookInformation();
            StudentList.getInstance().storeStudentInformation();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage.setTitle("Library System");
        stage.setScene(new Scene(root, 1000, 600));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}