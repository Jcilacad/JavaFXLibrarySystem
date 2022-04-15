package com.example.librarysystem;

import com.example.librarysystem.TodoData.StudentInformation;
import com.example.librarysystem.TodoData.StudentList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

import java.util.Comparator;

public class BorrowerListController {

    @FXML
    ListView<StudentInformation> studentList;

    public void initialize() {

        SortedList<StudentInformation> sortedList = new SortedList<>(StudentList.getInstance().getStudentList(), new Comparator<StudentInformation>() {
            @Override
            public int compare(StudentInformation o1, StudentInformation o2) {
                return o1.getIdNumber().compareTo(o2.getIdNumber());
            }
        });
        studentList.setItems(sortedList);
        studentList.getSelectionModel().selectFirst();
        studentList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }
}
