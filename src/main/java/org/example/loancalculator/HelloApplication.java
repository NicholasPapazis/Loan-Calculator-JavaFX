package org.example.loancalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //create new font for labels
        Font labelFont = new Font("Arial", 13);

        //create new TextFields for user inputs
        TextField annualInterestRate = new TextField();
        TextField numYears = new TextField();
        TextField loanAmount = new TextField();
        //create new TextFields for outputs
        TextField monthlyPayment = new TextField();
        TextField totalPayment = new TextField();
        //create calculate button
        Button calculate = new Button("Calculator");
        //create labels for TextFields
        Label annualInterestRateLbl = new Label();
        Label numYearsLbl = new Label();
        Label loanAmountLbl = new Label();
        Label monthlyPaymentLbl = new Label();
        Label totalPaymentLbl = new Label();

        //set coordinates for TextFields
        annualInterestRate.setLayoutX(140);
        annualInterestRate.setLayoutY(15);
        numYears.setLayoutX(140);
        numYears.setLayoutY(45);
        loanAmount.setLayoutX(140);
        loanAmount.setLayoutY(75);
        monthlyPayment.setLayoutX(140);
        monthlyPayment.setLayoutY(105);
        totalPayment.setLayoutX(140);
        totalPayment.setLayoutY(135);
        //set coordinates for calculate button
        calculate.setLayoutX(220);
        calculate.setLayoutY(165);
        //set coordinates for labels
        annualInterestRateLbl.setLayoutX(10);
        annualInterestRateLbl.setLayoutY(17);
        numYearsLbl.setLayoutX(10);
        numYearsLbl.setLayoutY(48);
        loanAmountLbl.setLayoutX(10);
        loanAmountLbl.setLayoutY(79);
        monthlyPaymentLbl.setLayoutX(10);
        monthlyPaymentLbl.setLayoutY(110);
        totalPaymentLbl.setLayoutX(10);
        totalPaymentLbl.setLayoutY(140);

        //set text for labels
        annualInterestRateLbl.setText("Annual Interest Rate:");
        numYearsLbl.setText("Number of Years:");
        loanAmountLbl.setText("Loan Amount:");
        monthlyPaymentLbl.setText("Monthly Payment:");
        totalPaymentLbl.setText("Total Payment:");

        //sent font for labels
        annualInterestRateLbl.setFont(labelFont);
        numYearsLbl.setFont(labelFont);
        loanAmountLbl.setFont(labelFont);
        monthlyPaymentLbl.setFont(labelFont);
        totalPaymentLbl.setFont(labelFont);


        //program the calculate button
        calculate.setOnAction(event -> {
            //get info from user and store in appropriate variables
            Double r = Double.parseDouble(annualInterestRate.getText())/100;
            Double t = Double.parseDouble(numYears.getText());
            Double P = Double.parseDouble(loanAmount.getText());
            Double n = 12.0;

            //calculate the monthly payment
            Double monthlyPaymentDouble = (P * (r / n)) / (1 - Math.pow(1 + (r / n), -n * t));
            //calculate the total payment
            Double totalPaymentDouble = monthlyPaymentDouble*n*t;

            //format the monthly payment
            String monthlyPaymentFinalized = "$" + Double.toString(Math.round(monthlyPaymentDouble*100.0)/100.0);
            //display the monthly payment for user to see
            monthlyPayment.setText(monthlyPaymentFinalized);
            //format the total payment
            String totalPaymentFinalized = "$" + Double.toString(Math.round(totalPaymentDouble*100.0)/100.0);
            //display the total payment for user to see
            totalPayment.setText(totalPaymentFinalized);
        });

        //organize left side of application
        Group leftSide = new Group(annualInterestRateLbl, numYearsLbl, loanAmountLbl, monthlyPaymentLbl, totalPaymentLbl);
        //organize right side of application
        Group rightSide = new Group(annualInterestRate,numYears,loanAmount,monthlyPayment,totalPayment, calculate);
        //combine left and right sides of application
        Group root = new Group(rightSide, leftSide);
        //create the scene with the root group and its dimensions
        Scene scene = new Scene(root,300, 200);
        stage.setTitle("LoanCalculator"); //set title of application
        stage.setScene(scene); //set the scene on the stage
        stage.show(); //show the stage



    }

    public static void main(String[] args) {
        launch();
    }
}