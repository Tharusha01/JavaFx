package javaFx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminController {

    @FXML
    void btnAddStaff(javafx.scene.input.MouseEvent mouseEvent) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("addStaff.fxml"));

            Node node = (Node) mouseEvent.getSource();

            Stage stage = (Stage) node.getScene().getWindow();

            stage.setScene(new Scene(root));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void btnViewLogFile(javafx.scene.input.MouseEvent mouseEvent) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("transactions.fxml"));

            Node node = (Node) mouseEvent.getSource();

            Stage stage = (Stage) node.getScene().getWindow();

            stage.setScene(new Scene(root));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnVeiwUsers(MouseEvent mouseEvent) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("users.fxml"));

            Node node = (Node) mouseEvent.getSource();

            Stage stage = (Stage) node.getScene().getWindow();

            stage.setScene(new Scene(root));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void btnALogout(javafx.scene.input.MouseEvent mouseEvent) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));

             Node node = (Node) mouseEvent.getSource();

            Stage stage = (Stage) node.getScene().getWindow();

            stage.setScene(new Scene(root));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnCEnquires(MouseEvent mouseEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("customerEnquiries.fxml"));

            Node node = (Node) mouseEvent.getSource();

            Stage stage = (Stage) node.getScene().getWindow();

            stage.setScene(new Scene(root));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
