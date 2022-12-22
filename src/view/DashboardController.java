package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class DashboardController {
    public AnchorPane operationAnchorPane;

    public void addBooksOnAction(ActionEvent actionEvent) throws IOException {
        operationAnchorPane.getChildren().add(FXMLLoader.load(getClass().getResource("managementUi/addBooks.fxml")));
    }

    public void updateBooksOnAction(ActionEvent actionEvent) throws IOException {
        operationAnchorPane.getChildren().add(FXMLLoader.load(getClass().getResource("managementUi/updateBooks.fxml")));
    }

    public void deleteBooksOnAction(ActionEvent actionEvent) throws IOException {
        operationAnchorPane.getChildren().add(FXMLLoader.load(getClass().getResource("managementUi/deleteBooks.fxml")));
    }

    public void viewAllOnAction(ActionEvent actionEvent) throws IOException {
        operationAnchorPane.getChildren().add(FXMLLoader.load(getClass().getResource("managementUi/viewAll.fxml")));
    }
}
