// Shane Bottomley Trip Cost Estimator 06/19/2024
//
// This JavaFX program calculates the cost of a trip from values input by the
// user.

package org.example.project3;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Project3 extends Application {

    //--Declare text fields and combo box for project
    //distance field & combo box
    private TextField distance = new TextField();
    private ComboBox<String> distanceDropdown = new ComboBox<>();
    //gasoline cost field & combo box
    private TextField gasolineCost = new TextField();
    private ComboBox<String> gasolineDropdown = new ComboBox<>();
    //gas mileage field & combo box
    private TextField gasMileage = new TextField();
    private ComboBox<String> mileageDropdown = new ComboBox<>();
    //number of days text field
    private TextField numOfDays = new TextField();
    //hotel cost text field
    private TextField hotelCost = new TextField();
    //food cost text field
    private TextField foodCost = new TextField();
    //attractions cost
    private TextField attractionsCost = new TextField();
    //calculate button
    private Button calculate = new Button("Calculate");
    //total cost display field
    private TextField totalCost = new TextField();

    @Override //Override start method in Application
    public void start(Stage primaryStage) {
        //--Create the GUI--
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        //add distance row
        gridPane.add(new Label("Distance"), 0, 0);
        gridPane.add(distance, 1, 0);
        gridPane.add(distanceDropdown, 2, 0);
        distanceDropdown.getItems().addAll("miles", "kilometers");
        distanceDropdown.setValue("miles");

        //add gas cost row
        gridPane.add(new Label("Gasoline Cost"), 0, 1);
        gridPane.add(gasolineCost, 1, 1);
        gridPane.add(gasolineDropdown, 2, 1);
        gasolineDropdown.getItems().addAll("dollars/gal", "dollars/liter");
        gasolineDropdown.setValue("dollars/gal");

        //add gas mileage row
        gridPane.add(new Label("Gasoline Mileage"), 0, 2);
        gridPane.add(gasMileage, 1, 2);
        gridPane.add(mileageDropdown, 2, 2);
        mileageDropdown.getItems().addAll(
                "miles/gallon",
                "kilometers/liter"
        );
        mileageDropdown.setValue("miles/gallon");

        //add number of days field
        gridPane.add(new Label("Number Of Days"), 0, 3);
        gridPane.add(numOfDays, 1, 3);

        //add Hotel Cost field
        gridPane.add(new Label("Hotel Cost"), 0, 4);
        gridPane.add(hotelCost, 1, 4);

        //add food cost field
        gridPane.add(new Label("Food Cost"), 0, 5);
        gridPane.add(foodCost, 1, 5);

        //add attractions cost field
        gridPane.add(new Label("Attractions"), 0, 6);
        gridPane.add(attractionsCost, 1, 6);

        //add calculate button
        gridPane.add(calculate, 1, 7);

        //add total trip cost field
        totalCost.setEditable(false);
        gridPane.add(new Label("Total Trip Cost"), 0, 8);
        gridPane.add(totalCost, 1, 8);

        //position properties for GUI
        gridPane.setAlignment(Pos.CENTER);

        //--call calculate method when calculate button clicked--
        calculate.setOnAction(e -> calculateTripCost());

        //--Create the scene and place in stage--
        //set size of scene
        Scene scene = new Scene(gridPane, 400, 350);
        //set the title
        primaryStage.setTitle("Trip Cost Estimator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //calculate trip cost method
    private void calculateTripCost() throws NumberFormatException {
        try {
            //construct a TripCost object with values from text
            TripCost trip = new TripCost(
                    Double.parseDouble(distance.getText()),
                    Double.parseDouble(gasolineCost.getText()),
                    Double.parseDouble(gasMileage.getText()),
                    Integer.parseInt(numOfDays.getText()),
                    Double.parseDouble(hotelCost.getText()),
                    Double.parseDouble(foodCost.getText()),
                    Double.parseDouble(attractionsCost.getText())
            );

            //call TripCost method to display total cost
            totalCost.setText(String.format("$%.2f", trip.computeTotalTripCost()));
            totalCost.setStyle("-fx-text-fill: black");
        }
        //catch number format exceptions
        catch (NumberFormatException ex) {
            //debug
            System.out.println(ex.getClass().getName());
            //debug

            //check for integer in numOfDays. isInt false if not an int
            Boolean isInt = true;
            for (int i = 0; i < numOfDays.getLength(); i++) {
                if(!Character.isDigit(numOfDays.getText().charAt(i)))
                    isInt = false;
            }

            //check for empty fields
            if (
                    distance.getText().isEmpty()
                    || gasolineCost.getText().isEmpty()
                    || gasMileage.getText().isEmpty()
                    || numOfDays.getText().isEmpty()
                    || hotelCost.getText().isEmpty()
                    || foodCost.getText().isEmpty()
                    || attractionsCost.getText().isEmpty()
            ){
                totalCost.setText("Please fill in all fields");
            }
            //if number of days is not an int
            else if (isInt == false) {
                totalCost.setText("Days must be integer");
            }
            else {
                totalCost.setText("Unknown Number Format");
            }
            totalCost.setStyle("-fx-text-fill: red");
        }
    }
    //Launch the program
    public static void main(String[] args) {
        launch();
    }
}
