// Shane Bottomley Time Interval Checker 07/06/2024
//
// The InvalidTimeException class is an Exception class that can be thrown
// when an invalid time is entered into a text field. The constructor takes a
// message as a String.

package org.example.project4;

public class InvalidTimeException extends Exception {

    String message;

    //Construct an InvalidTime exception
    public InvalidTimeException(String message) {
        this.message = message;
    }


}
