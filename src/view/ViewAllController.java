package view;

import database.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViewAllController {
    public TableView<String> bookList;
    public TableColumn<String, String> tId;
    public TableColumn<String, String> tName;
    public TableColumn<String, String> tAuthor;
    public TableColumn<String, String> tYear;
    public TableColumn<String, String> tCopies;

    public void initialize() throws SQLException, ClassNotFoundException {
        tId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        tYear.setCellValueFactory(new PropertyValueFactory<>("year"));
        tCopies.setCellValueFactory(new PropertyValueFactory<>("copies"));

        show(); // Call the show method to populate the TableView
    }

    public void show() throws SQLException, ClassNotFoundException {
        ObservableList<String> list = FXCollections.observableArrayList();
        bookList.setItems(list);

        String sql = "SELECT * FROM books";
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String author = resultSet.getString("author");
            String year = String.valueOf(resultSet.getInt("year"));
            String copies = String.valueOf(resultSet.getInt("copies"));

            // Create a list of strings for each row and add it to the list
            List<String> rowData = new ArrayList<>();
            rowData.add(id);
            rowData.add(name);
            rowData.add(author);
            rowData.add(year);
            rowData.add(copies);

            list.add(String.join(" - ", rowData));
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
