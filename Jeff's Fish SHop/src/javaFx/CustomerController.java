package javaFx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomerController implements Initializable{

    private String Cemail;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void getUserEmail(String email){
        Cemail = email;
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

    @FXML
    private void btnBuyProducts(javafx.scene.input.MouseEvent mouseEvent) {
        try {

            FXMLLoader pLoader = new FXMLLoader(getClass().getResource("products.fxml"));

            Parent root = pLoader.load();

            ProductsController productsController = pLoader.getController();
            productsController.getUserEmail1(Cemail);

            Node node = (Node) mouseEvent.getSource();

            Stage stage = (Stage) node.getScene().getWindow();

            stage.setScene(new Scene(root));

        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    @FXML
    private void btnEmailEnquiries(javafx.scene.input.MouseEvent mouseEvent) {
        try {

            FXMLLoader eLoader = new FXMLLoader(getClass().getResource("emailEnquiries.fxml"));

            Parent root = eLoader.load();

            EmailEnquiriesController emailEnquiriesController = eLoader.getController();
            emailEnquiriesController.getUserEmail1(Cemail);

            Node node = (Node) mouseEvent.getSource();

            Stage stage = (Stage) node.getScene().getWindow();

            stage.setScene(new Scene(root));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void btnUpdateProfile(javafx.scene.input.MouseEvent mouseEvent) {
        try {

            FXMLLoader pLoader = new FXMLLoader(getClass().getResource("updateProfile.fxml"));

            Parent root = pLoader.load();

            UpdateProfileController updateProfileController = pLoader.getController();
            updateProfileController.getUserEmail1(Cemail);


            Node node = (Node) mouseEvent.getSource();

            Stage stage = (Stage) node.getScene().getWindow();

            stage.setScene(new Scene(root));

        } catch (IOException error) {
            error.printStackTrace();
        }
    }

}
