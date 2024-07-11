// Shane Bottomley Time Interval Checker 07/06/2024
//
// The Time class contains hours, minutes, and the meridian (AM or PM). It
// has two constructors, the first one accepts hours and minutes as
// integers and the meridian as a String. The second constructor takes a
// string in the format "HH:MM AM" (or PM), it splits the string to get the
// correct information to declare the Time object.

package org.example.project4;

public class Time implements Comparable<Time>{
    //declare Time variables
    int hours;
    int minutes;
    String meridian;

    //-----Constructor-----
    //constructor that accepts the hours and minutes as integers and the
    // meridian as a string and constructs a Time object
    public Time(int hours, int minutes, String meridian) throws InvalidTimeException {
        try {
            //test hours are within range
            if (hours > 0 && hours < 13)
                this.hours = hours;
            else
                throw new InvalidTimeException("Hours not within 1-12");

            //test minutes are within range
            if (minutes >= 0 && minutes < 60)
                this.minutes = minutes;
            else
                throw new InvalidTimeException("Minutes not within 1-59");

            //test meridian for AM or PM
            if (meridian.equals("AM") || meridian.equals("PM"))
                this.meridian = meridian;
            else
                throw new InvalidTimeException("Meridian must be AM or PM");
        }
        catch (InvalidTimeException ex) {
            System.out.println(ex.message);;
        }
    }

    //constructor that accepts a string representation of a time in the format
    // HH:MM AM and constructs a Time object
    public Time(String time) throws InvalidTimeException {
        //split time String into hours, minutes, and meridian
        String[] timeArray = time.split("[ :]+");

        int formattedHours;
        int formattedMinutes;
        //test for number format exceptions when parsing integers
        try {
            formattedHours = Integer.parseInt(timeArray[0]);
            formattedMinutes = Integer.parseInt(timeArray[1]);
        }
        catch (NumberFormatException ex2) {
            throw new InvalidTimeException("Hours or Minutes not integers");
        }

        //test hours are within range
        if (formattedHours > 0 && formattedHours < 13)
            this.hours = formattedHours;
        else
            throw new InvalidTimeException("Hours not within 1-12");

        //test minutes are within range
        if (formattedMinutes >= 0 && formattedMinutes < 60)
            this.minutes = formattedMinutes;
        else
            throw new InvalidTimeException("Minutes not within 1-59");

        //test meridian for AM or PM
        if (timeArray[2].equals("AM") || timeArray[2].equals("PM"))
            this.meridian = timeArray[2];
        else
            throw new InvalidTimeException("Meridian must be AM or PM");

    }


    //-----Methods-------

    //method convertToMilitaryTime converts am and pm times to 24 hour
    // time for ease of comparing times
    public String convertToMilitaryTime() throws InvalidTimeException {
        String formattedMilitaryTime;
        int hours = getHours();
        int minutes = getMinutes();
        String stringMinutes = Integer.toString(minutes);
        String meridian = getMeridian();

        //---prevent errors if meridian null
        if (meridian == null) {
            throw new InvalidTimeException("Fix meridian exception");
        }
        //---ensure minutes is always two numbers
        while (stringMinutes.length() < 2) {
            stringMinutes = stringMinutes + "0";
        }
        //--Convert AM's to military time--
        //if the time is 12am, only use minutes as the time value
        if (meridian.equals("AM") && hours == 12) {
            formattedMilitaryTime = stringMinutes;
        }
        else if (meridian.equals("AM")) {
            formattedMilitaryTime = hours + stringMinutes;
        }
        //convert PM's to military time
        else if (meridian.equals("PM") && hours == 12) {
            formattedMilitaryTime = hours + stringMinutes;
        }
        else if (meridian.equals("PM")) {
            formattedMilitaryTime = (hours + 12) + stringMinutes;
        }
        else {
            formattedMilitaryTime = "Unknown";
        }
        //return formatted military time as string
        System.out.println(formattedMilitaryTime);
        return formattedMilitaryTime;
    }

    //method compareTo that compares two times and returns -1 if current time
    // is less than compared time, 0 if times are equal, and 1 if current
    // time is greater than compared time
    @Override
    public int compareTo(Time comparableTime) {
        //convert times to military time
        try {
            String currentMilTime = this.convertToMilitaryTime();
            String comparableMilTime = comparableTime.convertToMilitaryTime();

            //format Strings as integers
            int formattedCurrentMilTime = Integer.parseInt(currentMilTime);
            int formattedComparableMilTime = Integer.parseInt(comparableMilTime);

            if (formattedCurrentMilTime < formattedComparableMilTime)
                return -1;
            else if (formattedCurrentMilTime > formattedComparableMilTime)
                return 1;
            else
                return 0;
        }
        catch (InvalidTimeException ex) {
        }
        return 0;
    }

    //---Getters----
    @Override
    public String toString() {
        return String.valueOf(getHours()) + ":"
                + String.valueOf(getMinutes()) + " " + getMeridian();
    }
    public int getHours() {
        return hours;
    }
    public int getMinutes() {
        return minutes;
    }
    public String getMeridian() {
        return meridian;
    }
}