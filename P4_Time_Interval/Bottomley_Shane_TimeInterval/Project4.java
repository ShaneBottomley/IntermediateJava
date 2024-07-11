// Shane Bottomley Time Interval Checker 07/06/2024
//
// This JavaFX program takes in two time intervals (two starts and two ends)
// and outputs whether they are sub-intervals, overlapping, or disjoint. It
// then also takes an additional time and checks if that time is within both,
// one, or none of the intervals.

package org.example.project4;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Project4 extends Application {

    //--Declare text fields for project
    private TextField timeIntOneStart = new TextField();
    private TextField timeIntOneEnd = new TextField();
    private TextField timeIntTwoStart = new TextField();
    private TextField timeIntTwoEnd = new TextField();
    private Button compareIntervals = new Button("Compare Intervals");
    private TextField timeToCheck = new TextField();
    private Button checkTime = new Button("Check Time");
    public static TextField result = new TextField();

    @Override //Override start method in Application
    public void start(Stage primaryStage) {
        //make grid pane for time interval one and two labels and input
        GridPane timeIntPane = new GridPane();
        timeIntPane.setHgap(5);
        timeIntPane.add(new Label("Start time"), 1, 0);;
        timeIntPane.add(new Label("End time"), 2, 0);;
        timeIntPane.add(new Label("Time Interval 1"), 0, 1);
        timeIntPane.add(new Label("Time Interval 2"), 0, 2);
        timeIntPane.add(timeIntOneStart, 1, 1);
        timeIntPane.add(timeIntOneEnd, 2, 1);
        timeIntPane.add(timeIntTwoStart, 1, 2);
        timeIntPane.add(timeIntTwoEnd, 2, 2);

        //set compare intervals button length
        compareIntervals.setMinWidth(410);

        //add time to check label and field
        GridPane timeToCheckPane = new GridPane();
        timeToCheckPane.setHgap(5);
        timeToCheckPane.add(new Label("Time to Check"), 0, 0);
        timeToCheck.setMinWidth(325);
        timeToCheckPane.add(timeToCheck, 1, 0);

        //set Check Time button length
        checkTime.setMinWidth(410);

        //set results length and make not editable
        result.setMinWidth(405);
        result.setEditable(false);

        //--Create the main FlowPane--
        FlowPane mainPane = new FlowPane();
        mainPane.setHgap(5);
        mainPane.setVgap(5);
        mainPane.setOrientation(Orientation.VERTICAL);

        //position properties in main FlowPane
        mainPane.getChildren().addAll(timeIntPane,
                compareIntervals, timeToCheckPane, checkTime, result);
        mainPane.setAlignment(Pos.CENTER);
        mainPane.setHgap(5);
        mainPane.setVgap(5);

        //call appropriate methods on button clicks
        compareIntervals.setOnAction(e -> compareIntervals());

        checkTime.setOnAction(e -> checkTime());

        //--Create the scene and place in stage--
        //set size of scene
        Scene scene = new Scene(mainPane, 550, 350);
        //set the title
        primaryStage.setTitle("Time Interval Checker");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //----Compare Intervals method---
    //CompareIntervals should compare the two intervals and output one of the following
    //messages depending upon how the intervals compare:
    // Interval 1 is a sub-interval of interval 2
    // Interval 2 is a sub-interval of interval 1
    // The intervals overlap
    // The intervals are disjoint
    private void compareIntervals() {
        try {
            //construct four time Objects from text field input
            Time timeOneStart = new Time(String.valueOf(timeIntOneStart.getText()));
            Time timeOneEnd = new Time(String.valueOf(timeIntOneEnd.getText()));
            Time timeTwoStart = new Time(String.valueOf(timeIntTwoStart.getText()));
            Time timeTwoEnd = new Time(String.valueOf(timeIntTwoEnd.getText()));

            //construct two Interval objects from time objects
            Interval<Time> timeOneInterval = new Interval<Time>(timeOneStart,
                    timeOneEnd);
            Interval<Time> timeTwoInterval = new Interval<Time>(timeTwoStart,
                    timeTwoEnd);

            //output results of time intervals
            if (timeOneInterval.subinterval(timeTwoInterval)
                    || timeOneInterval.within(timeTwoInterval))
                result.setText("Interval 2 is a sub-interval of interval 1");
            else if (timeTwoInterval.subinterval(timeOneInterval)
                    || timeTwoInterval.within(timeOneInterval))
                result.setText("Interval 1 is a sub-interval of interval " +
                        "2");
            else if (timeOneInterval.overlaps(timeTwoInterval)
                    || timeTwoInterval.overlaps(timeOneInterval))
                result.setText("The intervals overlap");
            else
                result.setText("The intervals are disjoint");
        }
        catch (InvalidTimeException ex) {
            result.setText(ex.message);
        }
    }

    private void checkTime() {
        try {
            //construct four time Objects from text field input
            Time timeOneStart = new Time(String.valueOf(timeIntOneStart.getText()));
            Time timeOneEnd = new Time(String.valueOf(timeIntOneEnd.getText()));
            Time timeTwoStart = new Time(String.valueOf(timeIntTwoStart.getText()));
            Time timeTwoEnd = new Time(String.valueOf(timeIntTwoEnd.getText()));

            //construct two Interval objects from time objects
            Interval<Time> timeOneInterval = new Interval<Time>(timeOneStart,
                    timeOneEnd);
            Interval<Time> timeTwoInterval = new Interval<Time>(timeTwoStart,
                    timeTwoEnd);


            System.out.println();

            //output results of time intervals
            Time checkTime = new Time(String.valueOf(timeToCheck.getText()));

            if (timeOneInterval.contains(checkTime)
                    && timeTwoInterval.contains(checkTime))
                result.setText("Both intervals contain the time" + checkTime.toString());
            else if (timeOneInterval.contains(checkTime))
                result.setText("Only interval 1 contains the time " + checkTime.toString());
            else if (timeTwoInterval.contains(checkTime))
                result.setText("Only interval 2 contains the time " + checkTime.toString());
            else
                result.setText("Neither interval contains the time " + checkTime.toString());
        }
        catch (InvalidTimeException ex) {
            result.setText(ex.message);
        }
    }

    //Launch the program
    public static void main(String[] args) {
        launch();
    }
}