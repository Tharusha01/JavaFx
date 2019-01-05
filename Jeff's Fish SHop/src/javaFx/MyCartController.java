package javaFx;

import connectivity.connectionClass;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.text.DateFormatter;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;

public class MyCartController implements Initializable {


    private ArrayList<String> cartDetails = new ArrayList<>();
    private ArrayList<Integer> cartTotPrice = new ArrayList<>();

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-DD");
    LocalDateTime now = LocalDateTime.now();

    LocalDate date = LocalDate.now();



    @FXML
    private Label lbError;

    @FXML
    private Label lbDisplayTOT;

    @FXML
    private Label lbCartDetails;

    private String cEmail, cartMailDetails;
    private int totPrice;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void getData(ArrayList arrayList1,ArrayList arrayList2, String email){

        cEmail = email;
        cartDetails = arrayList1;
        cartTotPrice = arrayList2;
        totPrice = 0;
        String newCartDesc = "";

        for (int i = 0; i<cartDetails.size(); i++) {
            newCartDesc = newCartDesc +"\n" + cartDetails.get(i);
            lbCartDetails.setText(newCartDesc);
            cartMailDetails = newCartDesc;
        }

        for(int i = 0; i<cartTotPrice.size(); i++){
            totPrice += cartTotPrice.get(i);
        }
        lbDisplayTOT.setText("Total Prise Is "+ totPrice+"$");
    }

    @FXML
    void btnBuyNow(MouseEvent mouseEvent) throws SQLException {

        connectionClass connectionClass = new connectionClass();
        Connection connection = connectionClass.getConnection();

        try {
            snedMail();

            Statement statement = connection.createStatement();

            int status = statement.executeUpdate("INSERT INTO transactions (date,customer_mail,product_details,total_price)" +
                    " values('" + date+ "','" + cEmail+ "','" + cartMailDetails+ "','" + totPrice+ "')");

            if (status > 0) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("cardDetails.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            }

        } catch (IOException error) {
            lbError.setText("Please, Check your connection");
        }
    }

    @FXML
    void btnBackToHome(MouseEvent mouseEvent) {
        try {
            FXMLLoader cLoader = new FXMLLoader(getClass().getResource("products.fxml"));

            Parent root = cLoader.load();

            ProductsController productsController = cLoader.getController();
            productsController.getUserEmail1(cEmail);

            Node node = (Node) mouseEvent.getSource();

            Stage stage = (Stage) node.getScene().getWindow();

            stage.setScene(new Scene(root));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
