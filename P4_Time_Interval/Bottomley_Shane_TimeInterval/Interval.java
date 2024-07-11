// Shane Bottomley Time Interval Checker 07/06/2024
//
// The generic Interval class constructs an object which has startTime and
// endTime. The methods within, subinterval, overlaps, and contains compare
// interval objects and return true or false.

package org.example.project4;

public class Interval <T extends Comparable<T>> {
    //declare class variables
    T startTime;
    T endTime;

    //-----Constructor-----
    // constructor that accepts the start and end of an interval and
    // constructs an Interval object
    public Interval(T startTime, T endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    //-----Methods-------
    // returns whether that object is inside the interval, including the
    // endpoints
    public boolean within (Interval<T> intervalToCheck) {
        if (getStartTime().compareTo(intervalToCheck.getStartTime()) >= 0
            && getEndTime().compareTo(intervalToCheck.getEndTime()) <= 0)
            return true;
        else
            return false;
    }

    // returns whether the interval parameter is a subinterval, completely
    // within, the interval on which the method is invoked
    //
    // NOTE: (Above is the provided instructions, although  I feel like calling
    // subinterval on an object should return whether the current object is a
    // subinterval of the parameter passed in.
    // I read "intervalOne.subinterval(intervalTwo)" as "is intervalOne a
    // subinterval of intervalTwo?")
    public boolean subinterval (Interval<T> intervalToCheck) {
        //if start time of current Interval object compared to start time of
        // passed in Interval object returns that current interval object's
        // start time is less
        if (getStartTime().compareTo(intervalToCheck.getStartTime()) < 0
                //and end time of current Interval object compared to passed
                // in interval object returns that current end time is more
                && getEndTime().compareTo(intervalToCheck.getEndTime()) > 0)
            //then return that passed in Interval is a subinterval of current
            // Interval object
            return true;
        //otherwise, return false
        else
            return false;
    }

    // passed an interval as a parameter and returns whether the interval
    // parameter overlaps the interval on which the method is invoked
    public boolean overlaps (Interval<T> intervalToCheck) {
        if (getStartTime().compareTo(intervalToCheck.getEndTime()) < 0
        && getEndTime().compareTo(intervalToCheck.getStartTime()) > 0)
            return true;
        else
            return false;
    }

    // passed a single time object and returns true if the interval contains
    // the time
    public boolean contains (T checkTime) {
        if (checkTime.compareTo(getStartTime()) >= 0
        && checkTime.compareTo(getEndTime()) <= 0)
            return true;
        else
            return false;
    }

    //---Getters----
    public T getStartTime() {
        return startTime;
    }

    public T getEndTime() {
        return endTime;
    }
}