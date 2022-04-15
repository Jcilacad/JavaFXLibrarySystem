package com.example.librarysystem;

import com.example.librarysystem.TodoData.BookInformation;
import com.example.librarysystem.TodoData.BookList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

import java.util.Comparator;

public class BookListController {

    @FXML
    private ListView<BookInformation> bookInformation;

    @FXML
    private BookList bookList;

    @FXML
    public void initialize() {



        bookList = new BookList();

        SortedList<BookInformation> sortedList = new SortedList<>(BookList.getInstance().getBookList(), new Comparator<BookInformation>() {
            @Override
            public int compare(BookInformation o1, BookInformation o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
        bookInformation.setItems(sortedList);
        bookInformation.getSelectionModel().selectFirst();
        bookInformation.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);


    }
}
