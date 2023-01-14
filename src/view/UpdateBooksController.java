package view;

import database.DBConnection;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateBooksController {
    public TextField bookId;
    public TextField bookName;
    public TextField bookAuthor;
    public TextField publishedYear;
    public TextField numberOfCopies;

    public void updateBookOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String sql="UPDATE books SET id=?, name=?, author=?, year=?, copies=? WHERE id=?";
        Connection connection=DBConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1 , bookId.getText());
        statement.setString(2 , bookName.getText());
        statement.setString(3 , bookAuthor.getText());
        statement.setInt(4 , Integer.parseInt(publishedYear.getText()));
        statement.setInt(5 , Integer.parseInt(numberOfCopies.getText()));
        statement.setString(6 , bookId.getText());
        boolean execute = statement.execute();
        if(execute==true){
            new Alert(Alert.AlertType.CONFIRMATION , "Successfully Updated").show();
        }else{
            new Alert(Alert.AlertType.ERROR , "Something went wrong").show();
        }
    }

    public void loadBookOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM books WHERE id=?";
        Connection connection= DBConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1 , bookId.getText());
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            bookName.setText(resultSet.getString(2));
            bookAuthor.setText(resultSet.getString(3));
            publishedYear.setText(String.valueOf(resultSet.getInt(4)));
            numberOfCopies.setText(String.valueOf(resultSet.getInt(5)));
        }
    }
}
