// Shane Bottomley Honors Society Membership 06/06/2024
//
// The Graduate class is a subclass of the Student class. It adds a
// data field for degree sought, and requires the student be pursuing a
// master’s degree.

import java.text.DecimalFormat;
public class Graduate extends Student {
    //declare class variables
    private String degreeSought;

    //-----Constructor-----
    //construct the Graduate student with additional data field "degreeSought"
    public Graduate(String name, int creditHoursEarned,
                         double qualityPoints, String degreeSought) {
        super(name, creditHoursEarned, qualityPoints);
        this.degreeSought = degreeSought;
    }

    //-----Getters-----

    // get honor society eligibility based on gpa threshold.
    // that applies the requirement that the student be seeking a master’s
    // degree in addition to the requirement that applies to all students to
    // be eligible for honor society membership
    @Override
    public boolean eligibleForHonorSociety() {
        if (getGPA() >= minGpaThreshold &&
                degreeSought.equals("Masters")) {
            return true;
        }
        return false;
    }

    //to string method
    @Override
    public String toString() {
        //return as string
        DecimalFormat df = new DecimalFormat("####0.00");
        return (
                "Name: " + getName() + "\nGPA: " + df.format(getGPA()) + "\nDegree: " +
                        degreeSought
        );
    }
}
