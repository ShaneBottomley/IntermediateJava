// Shane Bottomley Honors Society Membership 06/06/2024
//
// The Undergraduate class is a subclass of the Student class. It adds a
// data field for year, and requires the student be at least a
// junior or senior to be eligible for honors society.

import java.text.DecimalFormat;

public class Undergraduate extends Student {
    //declare class variables
    private String year;

    //-----Constructor-----
    //construct the undergrad student with additional data field "year"
    public Undergraduate(String name, int creditHoursEarned,
                         double qualityPoints, String year) {
        super(name, creditHoursEarned, qualityPoints);
        this.year = year;
    }

    //-----Getters-----

    // get honor society eligibility based on gpa threshold.
    // Requirement that the student be either a junior or senior in addition
    // to the requirement that applies to all students to be eligible for
    // honor society membership
    @Override
    public boolean eligibleForHonorSociety() {
        if (getGPA() >= minGpaThreshold &&
                (year.equals("Junior") || year.equals("Senior"))) {
            return true;
        }
        return false;
    }

    //to string method
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("####0.00");
        //return as string
        return (
                "Name: " + getName() + "\nGPA: " + df.format(getGPA()) + "\nYear: " + year
        );
    }
}
