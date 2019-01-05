package javaFx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StaffController implements Initializable {

    @FXML
    private Label lbsName;

    private String sMail;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void getStaffDetails(String sName,String sEmail){
        lbsName.setText(sName);
        sMail = sEmail;
    }

    @FXML
    void btnVeiwLogFile(MouseEvent mouseEvent) {
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

    @FXML
    private void btnLogout(javafx.scene.input.MouseEvent mouseEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));

            Node node = (Node) mouseEvent.getSource();

            Stage stage = (Stage) node.getScene().getWindow();

            stage.setScene(new Scene(root));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
