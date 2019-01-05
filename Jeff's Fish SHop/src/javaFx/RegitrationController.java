package javaFx;

import connectivity.connectionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class RegitrationController {
    @FXML
    private TextField tfUserName;

    @FXML
    private TextField tfUserEmail;

    @FXML
    private TextField tfUserAddress;

    @FXML
    private PasswordField tfUserPassword;

    @FXML
    private Label lbRegistrationStatus;

    @FXML
    private CheckBox cbNewsletters;


    private String userName,userEmail,userPassword,userAddress;

    @FXML
    private void btnRegister(ActionEvent actionEvent) throws SQLException, IOException {
        connectionClass connectionClass = new connectionClass();
        Connection connection = connectionClass.getConnection();


            if(blankValidate()) {
                if (passwordValidate()) {

                    userName = tfUserName.getText();
                    userEmail = tfUserEmail.getText();
                    userPassword = tfUserPassword.getText();
                    userAddress = tfUserAddress.getText();

                    Statement statement = connection.createStatement();


                    int status = statement.executeUpdate("INSERT INTO user_registration (user_name,user_email,user_password,user_address)" +
                            " values('" + userName + "','" + userEmail + "','" + userPassword + "','" + userAddress + "')");

                    if (status > 0) {
                        lbRegistrationStatus.setText("Successfuly Registered");

                        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));

                        Node node = (Node) actionEvent.getSource();

                        Stage stage = (Stage) node.getScene().getWindow();

                        stage.setScene(new Scene(root));
                    }
                }
            }
    }

    @FXML
    public void btnOpenLogin(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setScene(new Scene(root));

    }
    private Boolean blankValidate() {
        Boolean result = false;

        //String email, name, password,address;

        userName = tfUserName.getText();
        userPassword = tfUserEmail.getText();
        userEmail = tfUserPassword.getText();
        userAddress = tfUserAddress.getText();

        if (userName.isEmpty() || userPassword.isEmpty() || userEmail.isEmpty() || userAddress.isEmpty()) {
            lbRegistrationStatus.setText("   Registration Failed,Please enter all the details");
        } else {
            result = true;
        }
        return result;
    }

    private Boolean passwordValidate() {
        Boolean result = false;
        int uPassword;
        uPassword = tfUserPassword.getText().length();
        if (uPassword<8) {
            lbRegistrationStatus.setText("Registration Failed,password must be eight characters or more");
        } else {
            result = true;
        }
        return result;
    }
}