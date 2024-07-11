// Shane Bottomley Tallest Player 05/19/2024
//
// The Player class creates a player object with the name as a string, height
// as a Height object, and age as an int

//-----Player class-----
public class Player {
    //declare variables name, height (type Height), and age
    private String name;
    private Height height;
    private int age;

    //-----Constructor-----
    //accepts a player’s name, height and age constructs a Player object
    public Player(String name, Height height, int age) {
        this.name = name;
        this.height = height;
        this.age = age;
    }

    //-----Getters-----
    //-name getter-
    public String getName() {
        return name;
    }
    //-height getter-
    public Height getHeight() {
        return height;
    }
    //-age getter-
    public int getAge() {
        return age;
    }
    //-returns the string representation of a player with each field
    //appropriately labeled
    public String toString() {
        String player = (
                "Name: " + getName() +
                " Age: " + getAge() +
                " Height: " + this.height.toString()
        );
        return player;
    }
}