package javaFx;

import connectivity.connectionClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerEnquiriesController {

    @FXML
    private Label lbPError;

    @FXML
    private TableView<EnquiryDetails> tableEnquiries;

    @FXML
    private TableColumn<EnquiryDetails, String> tbCusEEmail;

    @FXML
    private TableColumn<EnquiryDetails, String> tbCusMessage;

    private ObservableList<EnquiryDetails> data;

    @FXML
    void btnLoadEnquiryDetails(MouseEvent mouseEvent) {

        connectivity.connectionClass connectionClass = new connectionClass();
        Connection connection = connectionClass.getConnection();
        data= FXCollections.observableArrayList();

        try {
            Statement statement = connection.createStatement();

            ResultSet enquiryDetails = statement.executeQuery("select * from email_enquirers");
            while (enquiryDetails.next()) {
                //get string from db,whichever way
                data.add(new EnquiryDetails(enquiryDetails.getString(1), enquiryDetails.getString(2)));
            }

        } catch (SQLException e) {
            lbPError.setText("Error");
        }

        tbCusEEmail.setCellValueFactory(new PropertyValueFactory<>("cuEEmail"));
        tbCusMessage.setCellValueFactory(new PropertyValueFactory<>("cuEMessage"));

        tableEnquiries.setItems(null);
        tableEnquiries.setItems(data);


    }

    @FXML
    void btnBackToHome(MouseEvent mouseEvent) {
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
