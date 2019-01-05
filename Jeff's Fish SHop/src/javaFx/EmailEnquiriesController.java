package javaFx;

import connectivity.connectionClass;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class EmailEnquiriesController implements Initializable {

    @FXML
    private Label lbPError;

    private String cEmail;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

     public void getUserEmail1(String email){
        cEmail = email;
    }


    @FXML
    private TextArea taEnquiry;


    @FXML
    void btnSendEnquiry(MouseEvent event) throws SQLException {

        String mail,message;
        message = taEnquiry.getText();
        mail = cEmail;

        connectionClass connectionClass = new connectionClass();
        Connection connection = connectionClass.getConnection();


            Statement statement = connection.createStatement();

            int status = statement.executeUpdate("INSERT INTO email_enquirers(user_email,message)" +
                    " values('" + mail + "','"+ message +"')");

        if (status > 0) {
            lbPError.setText("Send Succesfull");
        }else{
            lbPError.setText("Sending Failed");
        }
        taEnquiry.clear();
    }

    @FXML
    private void btnBackToHome(MouseEvent mouseEvent) {
        try {

            FXMLLoader cLoader = new FXMLLoader(getClass().getResource("customer.fxml"));

            Parent root = cLoader.load();

            CustomerController customerController = cLoader.getController();
            customerController.getUserEmail(cEmail);

            Node node = (Node) mouseEvent.getSource();

            Stage stage = (Stage) node.getScene().getWindow();

            stage.setScene(new Scene(root));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
