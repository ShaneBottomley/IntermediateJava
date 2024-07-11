// Shane Bottomley Honors Society Membership 06/06/2024
//
// The Student class creates an object for each student, it holds variables
// for name, credit hours earned, and quality points.
// It has methods that return a students gpa, one that returns whether the
// student is eligible for honors society based on the gpa threshold, and a
// method that sets the gpa threshold

import java.text.DecimalFormat;
import java.util.Scanner;

public class Student {
    //declare class variables
    Scanner input = new Scanner(System.in);
    private String name;
    private int creditHoursEarned;
    private double qualityPoints;
    protected static double minGpaThreshold;

    //-----Constructor-----
    // Accepts a Student's name, credit hours earned, and quality points to
    // constructs a Player object
    public Student(String name, int creditHoursEarned, double qualityPoints) {
        this.name = name;
        this.creditHoursEarned = creditHoursEarned;
        this.qualityPoints = qualityPoints;
    }

    //-----Getters-----
    // get gpa, quality points * credit hours
    public double getGPA() {
        double gpa = qualityPoints / creditHoursEarned;
        return gpa;
    }
    //get name
    public String getName() { return name; }
    //get gpa threshold
    public static double getMinGpaThreshold() {
        return minGpaThreshold;
    }

    // get honor society eligibility based on gpa threshold
    public boolean eligibleForHonorSociety() {
        if (getGPA() >= minGpaThreshold) {
            return true;
        }
        return false;
    }

    //to string method
    public String toString() {
        DecimalFormat df = new DecimalFormat("####0.00");
        return (
                "Name: " + getName()
                + "\nGPA: " + df.format(getGPA())
        );
    }

    //-----Setters-----
    // set the gpa threshold to the midpoint of the average gpa and the
    // highest possible gpa of 4.0
    public static void setGpaThreshold(double totalGPA, int totalStudents) {
        //get avg gpa
        double avgGPA = totalGPA / totalStudents;

        //find midpoint between avg gpa and 4.0
        minGpaThreshold = (4 + avgGPA) / 2;
    }
}
