// Shane Bottomley Tallest Player 05/19/2024
//
// The Height class contains int feet and int inches, it has
// a method to return height in only inches, and a toString method

//---Height class-----
public class Height {
    //declare two int variables for feet and inches
    private int feet;
    private int inches;

    //-----Constructor-------
    public Height(int feet, int inches) {
        this.feet = feet;
        this.inches = inches;
    }

    //-----Getters-------
    //returns height in total inches
    public int toInches() {
        int totalInches;
        totalInches = (this.feet * 12) + this.inches;
        return totalInches;
    }

    //returns the string representation of the height with a single
    public String toString() {
        //display the height normalized so the inches are less than 12.
        int totalInches = toInches();
        int feet = totalInches / 12;
        int inches = totalInches % 12;

        //create string in format height'inches"
        String heightString = (feet + "'" + inches + '\u0022');
        //return the string
        return heightString;
    }

}
