package view;

import database.DBConnection;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddBooksController {

    public TextField bookId;
    public TextField bookName;
    public TextField bookAuthor;
    public TextField publishedYear;
    public TextField numberOfCopies;

    public void addBookOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO books VALUES (?,?,?,?,?)";
        Connection connection=DBConnection.getInstance().getConnection();

        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setObject(1 ,Integer.parseInt(bookId.getText()));
        statement.setObject(2 , bookName.getText());
        statement.setObject(3 , bookAuthor.getText());
        statement.setInt(4 , Integer.parseInt(publishedYear.getText()));
        statement.setInt(5 , Integer.parseInt(numberOfCopies.getText()));

        if (statement.execute()){
            new Alert(Alert.AlertType.CONFIRMATION , "Successfully Saved");
        }else{
            new Alert(Alert.AlertType.ERROR , "Something Went Wrong");
        }
    }
}
