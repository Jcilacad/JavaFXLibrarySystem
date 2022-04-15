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

public class StudentList {

    private static String filename = "studentInformation.txt";
    private static StudentList instance = new StudentList();
    private ObservableList<StudentInformation> studentList;

    public static StudentList getInstance() {
        return instance;
    }

    public StudentList() {
        studentList = FXCollections.observableArrayList();
    }

    public ObservableList<StudentInformation> getStudentList() {
        return this.studentList;
    }

    @FXML
    public void addStudentInformation(StudentInformation studentInformation) {
        studentList.add(studentInformation);
    }

    @FXML
    public void loadStudentInformation() throws IOException {

        Path path = Paths.get(filename);
        BufferedReader br = Files.newBufferedReader(path);

        String input;

        try {
            while ((input = br.readLine()) != null) {
                String[] words = input.split("\t");
                String idNumber = words[0];
                String name = words[1];
                String section = words[2];
                String phoneNumber = words[3];
                String title = words[4];
                String author = words[5];
                String reserveBooks = words[6];

                StudentInformation studentInformation = new StudentInformation(idNumber, name, section, phoneNumber, title, author, reserveBooks);
                studentList.add(studentInformation);
            }
        } finally {
            if (br != null) {
                br.close();
            }
        }

    }


    @FXML
    public void deleteStudentInformation (StudentInformation studentInformation) {
        studentList.remove(studentInformation);
    }

    @FXML
    public void storeStudentInformation() throws IOException {

        Path path = Paths.get(filename);
        BufferedWriter bw = Files.newBufferedWriter(path);

        try {
            Iterator<StudentInformation> iter = studentList.iterator();
            while (iter.hasNext()) {
                StudentInformation studentInformation = iter.next();
                bw.write(String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s", studentInformation.getIdNumber(), studentInformation.getName(), studentInformation.getSection(), studentInformation.getPhoneNumber(), studentInformation.getTitle(), studentInformation.getAuthor(), studentInformation.getReserveBooks()));
                bw.newLine();
            }
        } finally {
            if (bw != null) {
                bw.close();
            }
        }

    }
}
