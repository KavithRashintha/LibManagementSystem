package view;

import database.DBConnection;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteBooksController {
    public TextField bookId;
    public TextField bookName;
    public TextField bookAuthor;
    public TextField publishedYear;
    public TextField numberOfCopies;

    public void deleteBookOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String sql="DELETE FROM books WHERE id=?";
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setString(1 , bookId.getText());
        boolean execute = statement.execute();
        if(execute==true){
            new Alert(Alert.AlertType.CONFIRMATION , "Successfully Deleted!").show();
        }else{
            new Alert(Alert.AlertType.ERROR , "Something Went Wrong!").show();
        }
    }

    public void loadDataOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
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
