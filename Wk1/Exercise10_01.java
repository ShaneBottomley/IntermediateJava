//Shane Bottomley CMSC215 05/18/2024
//
//The Time class has three constructors;
// 1. Time() no arg/sets time object to current time
// 2. Time(long Milliseconds) takes time in Milliseconds with a specified
// elapsed time since midnight, January 1, 1970
// 3. takes specified hour, minute, and second
// It has three getter methods, getMinute(), getSecond(), getTime()
// One setter method SetTime(long elapsedTime) which sets a new time for
// the object
public class Exercise10_01 {
    //main uses all three constructors and prints out time for each
    public static void main(String[] args) {
        Time time1 = new Time();
        System.out.println(time1.getHour() + ":" +
                time1.getMinute() + ":" + time1.getSecond());

        Time time2 = new Time(555550000);
        System.out.println(time2.getHour() + ":" +
                time2.getMinute() + ":" + time2.getSecond());

        Time time3 = new Time(5, 23, 55);
        System.out.println(time3.getHour() + ":" +
                time3.getMinute() + ":" + time3.getSecond());
    }
}

class Time {
    //---initialize data fields---
    private long second;
    private long minute;
    private long hour;

    //---Constructors---
    //-no arg constructor/sets object to the current time-
    public Time() {
        //passes current time in milliseconds to getSMHFromMillis()
        setTime(System.currentTimeMillis());
    }

    //-constructor that takes time in total milliseconds-
    public Time(long totalMilliseconds) {
        //passes specified time in milliseconds to getSMHFromMillis
        setTime(totalMilliseconds);
    }

    //-constructor that takes specific hour, minute, second
    public Time(long hour, long minute, long second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    //---Getter Methods---
    //-get hour--
    public long getHour() {
        return hour;
    }
    //-get minute=
    public long getMinute() {
        return minute;
    }
    //-get second
    public long getSecond() {
        return second;
    }

    //---Setter Methods---
    public void setTime(long elapseTime) {
        long totalSeconds = elapseTime / 1000;
        this.second = (totalSeconds % 60);
        //compute and obtain current minute
        long totalMinutes = totalSeconds / 60;
        this.minute = totalMinutes % 60;
        //compute and obtain current hour
        long totalHours = totalMinutes / 60;
        this.hour = totalHours % 24;
    }
}