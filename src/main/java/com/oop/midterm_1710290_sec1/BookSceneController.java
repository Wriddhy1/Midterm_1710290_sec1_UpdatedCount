package com.oop.midterm_1710290_sec1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;



import java.util.ArrayList;



public class BookSceneController {
    @javafx.fxml.FXML
    private TableColumn titleCol;
    @javafx.fxml.FXML
    private TableColumn idCol;
    @FXML
    private TableColumn countCol;
    @javafx.fxml.FXML
    private TableColumn genreCol;
    @javafx.fxml.FXML
    private ComboBox<String> searchGenreComboBox;
    @javafx.fxml.FXML
    private TextField priceTextField;
    @javafx.fxml.FXML
    private TableView tableView;
    @javafx.fxml.FXML
    private TextField BookTitleTextField;
    @javafx.fxml.FXML
    private TextField minpriceTextField;
    @javafx.fxml.FXML
    private TextField bookIdTextField;
    @javafx.fxml.FXML
    private TextField maxPriceTextField;
    @javafx.fxml.FXML
    private TableColumn priceCol;
    @javafx.fxml.FXML
    private ComboBox<String> bookGenreComboBox;

    @javafx.fxml.FXML
    public void initialize() {

        idCol.setCellValueFactory(new PropertyValueFactory<Book, String>("bookId"));
        titleCol.setCellValueFactory(new PropertyValueFactory<Book, String>("bookTitle"));
        genreCol.setCellValueFactory(new PropertyValueFactory<Book, String>("bookGenre"));
        priceCol.setCellValueFactory(new PropertyValueFactory<Book, Float>("price"));
        countCol.setCellValueFactory(new PropertyValueFactory<Book, Integer>("count"));

        bookGenreComboBox.getItems().addAll("Horror", "Noble", "Drama");
        searchGenreComboBox.getItems().addAll("Horror", "Noble", "Drama");


    }

    static ArrayList<Book> bookArrayList = new ArrayList<>();



    @javafx.fxml.FXML
    public void addnewbookOnAction(ActionEvent actionEvent) {

        int id = Integer.parseInt(bookIdTextField.getText());
        String bookTitle = BookTitleTextField.getText();
        float price = Float.parseFloat(priceTextField.getText());
        String genre = bookGenreComboBox.getValue();
        int count=0;

        boolean duplicateid = false;

        for (Book B : bookArrayList) {
            if (B.getBookId() == id) {
                duplicateid = true;
                break;
            }
        }

        if (duplicateid) {
            showAlert("Error", "Duplicate ID error", "No duplicate IDs allowed.");
        } else if (price < 0) {
            showAlert("Error", "Negative price error", "No negative prices allowed.");
        } else {

            Book newbook = new Book(id, bookTitle, genre, price);
            bookArrayList.add(newbook);



            tableView.getItems().add(newbook);
            //updateBookCount();
        }

    }

    @javafx.fxml.FXML
    public void SearchandShowOnAction(ActionEvent actionEvent)
    {
        String selectedgenre = searchGenreComboBox.getValue();
        int minprice= Integer.parseInt(minpriceTextField.getText());
        int maxprice=Integer.parseInt(maxPriceTextField.getText());
        tableView.getItems().clear();
        int count=0;

        ArrayList<Book>filteredarraylist=new ArrayList<>();
        for (Book B : bookArrayList) {
            if (B.getBookGenre().equals(selectedgenre)) {
                if (B.getPrice() >= minprice&& B.getPrice() <= maxprice) {
                    tableView.getItems().clear();


                    filteredarraylist.add(B);
                    B.setCount(++count);

                    tableView.getItems().addAll(filteredarraylist);

                }
            }
        }
    }






    private void showAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }


}



