package javaFx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ProductsController implements Initializable {

    @FXML
    private Label lbEror;

    @FXML
    private Label lbDisplayUnitTotPrice;

    @FXML
    private Label lbFHCost;

    @FXML
    private Label lbFLCost;

    @FXML
    private Label lbFRCost;

    @FXML
    private Label lbROCost;

    @FXML
    private Label lbSICost;

    @FXML
    private Label lbSWCost;

    private ObservableList<String> selectFHList = FXCollections.observableArrayList("#1","#2","#3");
    private ObservableList<String> selectFLList = FXCollections.observableArrayList("100m","200m","300m");
    private ObservableList<String> selectFRList = FXCollections.observableArrayList("1m","2m","3m");
    private ObservableList<String> selectROList = FXCollections.observableArrayList("1m","2m","3m");
    private ObservableList<String> selectSIList = FXCollections.observableArrayList("100g","200g","300g");
    private ObservableList<String> selectSWList = FXCollections.observableArrayList("small","medium","large");



    @FXML
    private TextField tfFH;

    @FXML
    private TextField tfFL;

    @FXML
    private TextField tfFR;

    @FXML
    private TextField tfRO;

    @FXML
    private TextField tfSI;

    @FXML
    private TextField tfSW;

    @FXML
    private ChoiceBox<String> selectFH;

    @FXML
    private ChoiceBox<String> selectFR;

    @FXML
    private ChoiceBox<String> selectFL;

    @FXML
    private ChoiceBox<String> selectRO;

    @FXML
    private ChoiceBox<String> selectSI;

    @FXML
    private ChoiceBox<String> selectSW;

    private ArrayList<String> cartDetails = new ArrayList<>();
    private ArrayList<Integer> cartTotPrice = new ArrayList<>();

    private String[] products = {"Fish Hooks","Fishing Line","Fishing Reel","Fishing Rod","Sinkers","Swivels"};

    private int fhPrice, flPrice, frPrice, roPrice, siPrice, swPrice;
    private String cEmail;

    @FXML
    private void calculatePrice(){

        String fhPRice1 = selectFH.getValue();

        switch (fhPRice1) {
            case "#1":
                fhPrice = 5;
                lbFHCost.setText("5$");
                break;
            case "#2":
                fhPrice = 10;
                lbFHCost.setText("10$");
                break;
            default:
                fhPrice = 15;
                lbFHCost.setText("15$");
                break;
        }

        String flPrice1 = selectFL.getValue();

        switch (flPrice1) {
            case "100m":
                flPrice = 100;
                lbFLCost.setText("100$");
                break;
            case "200m":
                flPrice = 200;
                lbFLCost.setText("200$");
                break;
            default:
                flPrice = 300;
                lbFLCost.setText("300$");
                break;
        }

        String frPrice1 = selectFR.getValue();

        switch (frPrice1) {
            case "1m":
                frPrice = 50;
                lbFRCost.setText("50$");
                break;
            case "2m":
                frPrice = 100;
                lbFRCost.setText("100$");
                break;
            default:
                frPrice = 150;
                lbFRCost.setText("150$");
                break;
        }

        String roPrice1 = selectRO.getValue();

        switch (roPrice1) {
            case "1m":
                roPrice = 40;
                lbROCost.setText("40$");
                break;
            case "2m":
                roPrice = 80;
                lbROCost.setText("80$");
                break;
            default:
                roPrice = 100;
                lbROCost.setText("100$");
                break;
        }

        String siPrice1 = selectSI.getValue();

        switch (siPrice1) {
            case "100g":
                siPrice = 50;
                lbSICost.setText("50$");
                break;
            case "200g":
                siPrice = 100;
                lbSICost.setText("100$");
                break;
            default:
                siPrice = 150;
                lbSICost.setText("150$");
                break;
        }

        String swPrice1 = selectSW.getValue();

        switch (swPrice1) {
            case "small":
                swPrice = 100;
                lbSWCost.setText("100$");
                break;
            case "medium":
                swPrice = 200;
                lbSWCost.setText("200$");
                break;
            default:
                swPrice = 300;
                lbSWCost.setText("300$");
                break;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        selectFH.setValue("#1");
        selectFH.setItems(selectFHList);

        selectFL.setValue("100m");
        selectFL.setItems(selectFLList);

        selectFR.setValue("1m");
        selectFR.setItems(selectFRList);

        selectRO.setValue("1m");
        selectRO.setItems(selectROList);

        selectSI.setValue("100g");
        selectSI.setItems(selectSIList);

        selectSW.setValue("small");
        selectSW.setItems(selectSWList);
    }

    public void getUserEmail1(String email){
        cEmail = email;
    }

    @FXML
    void btnCartFH(MouseEvent mouseEvent) {
        try{
            String fhh = selectFH.getValue();
            int fh = Integer.parseInt(tfFH.getText());

            calculatePrice();
            int totFHPrice = fhPrice*fh;

            String fhDetails = "\tFH\t\t\t  "+products[0]+"\t\t\t  "+fhh+"\t\t\t"+fhPrice+"\t\t "+fh+"\t\t\t "+totFHPrice+"$";
            cartDetails.add(fhDetails);
            cartTotPrice.add(totFHPrice);

            lbEror.setText(products[0]+" "+fhh+" × "+fh+" items added to the cart");
            lbDisplayUnitTotPrice.setText("Total price is "+totFHPrice+"$");
            tfFH.clear();;
        }catch (Exception notANumber){
            lbEror.setText("enter valid quantity");
            tfFH.clear();
        }

    }

    @FXML
    void btnCartFL(javafx.scene.input.MouseEvent mouseEvent) {
        try{
            String fll = selectFL.getValue();
            int fl = Integer.parseInt(tfFL.getText());

            calculatePrice();
            int totFLPrice = flPrice*fl;

            String flDetails = "\tFL\t\t\t  "+products[1]+"\t\t\t  "+fll+"\t\t"+flPrice+"\t\t "+fl+"\t\t\t "+totFLPrice+"$";
            cartDetails.add(flDetails);
            cartTotPrice.add(totFLPrice);

            lbEror.setText(products[1]+" "+fll+" × "+fl+" items added to the cart");
            lbDisplayUnitTotPrice.setText("Total price is "+totFLPrice+"$");
            tfFL.clear();
        }catch (Exception notANumber){
            lbEror.setText("enter valid quantity");
            tfFL.clear();
        }
    }

    @FXML
    void btnCartFR(javafx.scene.input.MouseEvent mouseEvent) {
        try{
            String frr = selectFR.getValue();
            int fr = Integer.parseInt(tfFR.getText());

            calculatePrice();
            int totFRPrice = frPrice*fr;

            String frDetails = "\tFR\t\t\t  "+products[2]+"\t\t\t  "+frr+"\t\t\t"+flPrice+"\t\t "+fr+"\t\t\t "+totFRPrice+"$";
            cartDetails.add(frDetails);
            cartTotPrice.add(totFRPrice);

            lbEror.setText(products[2]+" "+frr+" × "+fr+" items added to the cart");
            lbDisplayUnitTotPrice.setText("Total price is "+totFRPrice+"$");
            tfFR.clear();
        }catch (Exception notANumber){
            lbEror.setText("enter valid quantity");
            tfFR.clear();
        }

    }

    @FXML
    void btnCartRO(javafx.scene.input.MouseEvent mouseEvent) {
        try{
            String roo = selectRO.getValue();
            int ro = Integer.parseInt(tfRO.getText());

            calculatePrice();
            int totROPrice = roPrice*ro;

            String roDetails = "\tRO\t\t\t  "+products[3]+"\t\t\t  "+roo+"\t\t\t"+roPrice+"\t\t "+ro+"\t\t\t "+totROPrice+"$";
            cartDetails.add(roDetails);
            cartTotPrice.add(totROPrice);

            lbEror.setText(products[3]+" "+roo+" × "+ro+" items added to the cart");
            lbDisplayUnitTotPrice.setText("Total price is "+totROPrice+"$");
            tfRO.clear();
        }catch (Exception notANumber){
            lbEror.setText("enter valid quantity");
            tfRO.clear();
        }
    }

    @FXML
    void btnCartSI(javafx.scene.input.MouseEvent mouseEvent) {
        try {
            String sii = selectSI.getValue();
            int si = Integer.parseInt(tfSI.getText());

            calculatePrice();
            int totSIPrice = siPrice*si;

            String siDetails = "\tSI\t\t\t  "+products[4]+"\t\t\t\t  "+sii+"\t\t"+siPrice+"\t\t "+si+"\t\t\t "+totSIPrice+"$";
            cartDetails.add(siDetails);
            cartTotPrice.add(totSIPrice);

            lbEror.setText(products[4]+" "+sii+" × "+si+" items added to the cart");
            lbDisplayUnitTotPrice.setText("Total price is "+totSIPrice+"$");
            tfSI.clear();
        } catch (Exception notANumber) {
            lbEror.setText("enter valid quantity");
            tfSI.clear();
        }
    }

    @FXML
    void btnCartSW(javafx.scene.input.MouseEvent mouseEvent) {
        try {
            String sww = selectSW.getValue();
            int sw = Integer.parseInt(tfSW.getText());

            calculatePrice();
            int totSWPrice = swPrice*sw;

            String swDetails = "\tSW\t\t\t  "+products[5]+"\t\t\t\t  "+sww+"\t\t"+swPrice+"\t\t "+sw+"\t\t\t "+totSWPrice+"$";
            cartDetails.add(swDetails);
            cartTotPrice.add(totSWPrice);

            lbEror.setText(products[5]+" "+sww+" × "+sw+" items added to the cart");
            lbDisplayUnitTotPrice.setText("Total price is "+totSWPrice+"$");
            tfSW.clear();
        }catch (Exception notANumber){
            lbEror.setText("enter valid quantity");
            tfSW.clear();
        }
    }

    @FXML
    void btnGoTOCart(javafx.scene.input.MouseEvent mouseEvent) {

        try {

            FXMLLoader mLoader = new FXMLLoader(getClass().getResource("myCart.fxml"));

            Parent root = mLoader.load();

            MyCartController myCartController = mLoader.getController();
            myCartController.getData(cartDetails,cartTotPrice, cEmail);

            Node node = (Node) mouseEvent.getSource();

            Stage stage = (Stage) node.getScene().getWindow();

            stage.setScene(new Scene(root));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void btnBackToHome(javafx.scene.input.MouseEvent mouseEvent) {
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
