package javaFx;

import connectivity.connectionClass;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginController {

    //private String cName;

    @FXML
        private TextField tfUserEmail;

    @FXML
        private PasswordField tfUserPassword;

    @FXML
        private Label lbLoginStatus;
        @FXML
        void btnLogin(MouseEvent event) throws SQLException, IOException {
            String userEmail,userPassword;
            userEmail = tfUserEmail.getText();
            userPassword = tfUserPassword.getText();

            connectionClass connectionClass = new connectionClass();
            Connection connection = connectionClass.getConnection();

            if (blankValidate()) {

                Statement statement = connection.createStatement();

                ResultSet resultSet_Customer = statement.executeQuery("select * from user_registration where user_email" +
                        " = '" + userEmail + "' and user_password = '" + userPassword + "'");

                if (resultSet_Customer.next()) {

                    FXMLLoader cLoader = new FXMLLoader(getClass().getResource("customer.fxml"));
                    Parent root = cLoader.load();
                    CustomerController customerController = (CustomerController)cLoader.getController();
                    customerController.getUserEmail(tfUserEmail.getText());

                    //Parent root = FXMLLoader.load(getClass().getResource("customer.fxml"));

                    Node node = (Node) event.getSource();

                    Stage stage = (Stage) node.getScene().getWindow();

                    stage.setScene(new Scene(root));

                }else{
                    lbLoginStatus.setText("Login Failed, Please enter your registerd Email and Password");
                }

                ResultSet resultSet_Staff = statement.executeQuery("select * from staff_registration where staff_email" +
                        " = '" + userEmail + "' and staff_password = '" + userPassword + "'");
                if(resultSet_Staff.next()){

                    FXMLLoader sLoader = new FXMLLoader(getClass().getResource("staff.fxml"));
                    Parent root = sLoader.load();

                    StaffController staffController = (StaffController)sLoader.getController();
                    staffController.getStaffDetails(tfUserPassword.getText(),tfUserEmail.getText());
                    //Parent root = FXMLLoader.load(getClass().getResource("staff.fxml"));

                    Node node = (Node) event.getSource();

                    Stage stage = (Stage) node.getScene().getWindow();

                    stage.setScene(new Scene(root));

                }else{
                    lbLoginStatus.setText("Login Failed, Please enter your registerd Email and Password");
                }

                ResultSet resultSet_admin = statement.executeQuery("select * from admin where admin_email" +
                        " = '" + userEmail + "' and admin_password = '" + userPassword + "'");
                if(resultSet_admin.next()) {

                    Parent root = FXMLLoader.load(getClass().getResource("admin.fxml"));

                    Node node = (Node) event.getSource();

                    Stage stage = (Stage) node.getScene().getWindow();

                    stage.setScene(new Scene(root));

                }else{
                    lbLoginStatus.setText("Login Failed, Please enter your registerd Email and Password");
                }

                tfUserEmail.clear();
                tfUserPassword.clear();
            }
        }


    @FXML
    private void btnOpenRegistration(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("registration.fxml"));

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setScene(new Scene(root));
    }

    private Boolean blankValidate() {
        Boolean result = false;
        String uEmail,uPassword;
        uPassword = tfUserEmail.getText();
        uEmail = tfUserPassword.getText();;

        if (uEmail.isEmpty() || uPassword.isEmpty()) {
            lbLoginStatus.setText("Login Failed, Please enter all the details");
        } else {
            result = true;
        }
        return result;
    }
}
