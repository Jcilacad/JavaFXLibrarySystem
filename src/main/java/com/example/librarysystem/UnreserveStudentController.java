package com.example.librarysystem;

import com.example.librarysystem.TodoData.StudentInformation;
import com.example.librarysystem.TodoData.StudentList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class UnreserveStudentController {

    @FXML
    private TextField idNumberField;

    @FXML
    private TextField titleField;

    @FXML
    private TextField authorField;

    @FXML
    private TextField quantityField;

    @FXML
    public void processResult() {

        String idNumber = idNumberField.getText().trim();
        String title = titleField.getText().trim();
        String author = authorField.getText().trim();
        String quantity = quantityField.getText().trim();

        StudentInformation studentInformation = checkStudent(idNumber, title, author);
        if (studentInformation != null) {
            int convertedQuantity = Integer.parseInt(quantity);
            int flag = studentInformation.unreserveBook(title, author, convertedQuantity);
            if (flag == 1) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Unreserved Student");
                alert.showAndWait();
                return;
            } else if (flag == 0) {
                StudentList.getInstance().deleteStudentInformation(studentInformation);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Message");
                alert.setHeaderText(null);
                alert.setContentText("The Student Information Deleted, Since the quantity is equal to its stock quantity.");
                alert.showAndWait();
            }
        } else {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Message");
            alert.setHeaderText(null);
            alert.setContentText("Couldn't find the student");

            alert.showAndWait();
        }
    }

    private StudentInformation checkStudent(String idNumber, String title, String author) {

        for (StudentInformation studentInformation : StudentList.getInstance().getStudentList()) {
            if ((studentInformation.getIdNumber().equals(idNumber) && (studentInformation.getTitle().equals(title) && (studentInformation.getAuthor().equals(author))))) {
                return studentInformation;
            }
        }
        return null;
    }


}
