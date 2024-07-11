// Shane Bottomley Tallest Player 05/19/2024
//
// This program takes input for players and then finds the tallest player
// whose age is less than or equal to the average of all the players

import java.util.ArrayList;
import java.util.Scanner;

public class Project1 {
    //-----Main Program-----
    public static void main(String[] args) {
        //declare variables
        Scanner input = new Scanner(System.in);
        ArrayList<Player> players = new ArrayList<>();
        int totalAge = 0;

        //welcome user
        System.out.println("This program finds the tallest basketball player " +
                "who's age is less than or equal to the average of all " +
                "players");
        //get num of players
        System.out.print("How many players are on your team?: ");
        int numOfPlayers = input.nextInt();

        //get info for each player and add to ArrayList players
        //declare loop variables
        String name;
        int age;
        Height height;
        int feet;
        int inches;
        //loop through number of players
        for (int i = 0; i < numOfPlayers; i++) {
            //get player name
            System.out.print("Enter the name of player " + i + ": ");
            name = input.next();

            //get player height
            System.out.print("Enter the height of player " + i +
                    " (feet inches): ");
            feet = input.nextInt();
            inches = input.nextInt();
            //assign height to height object
            height = new Height(feet, inches);

            //get player age
            System.out.print("Enter the age of player " + i + ": ");
            age = input.nextInt();
            //add age to totalAge
            totalAge += age;

            //construct the player object
            Player player = new Player(name, height, age);

            //add player to ArrayList
            players.add(player);
        }
        //output average age of all players
        int avgAge = totalAge / numOfPlayers;
        System.out.println("The average age is " + avgAge);

        //find the tallest player whose age is less than or equal to the avg
        //age of all the players
        //initialize "indexOfTallest" to the first player whose age is less than
        // the avg
        int indexOfTallest = 0;
        for (Player i : players) {
            if (i.getAge() < avgAge) {
                indexOfTallest = players.indexOf(i);
                break;
            }
        }
        //loop through each player to find the tallest
        for (Player i : players) {
            //test if player i is taller than previous tallest player
            if (i.getHeight().toInches() > players.get(indexOfTallest).getHeight().toInches()) {
                //test if age is less than half the avg
                if (i.getAge() < avgAge) {
                    //get index of tallest player
                    indexOfTallest = players.indexOf(i);
                }
            }
        }
        System.out.println("The tallest player whose age is less than or " +
                "equal to the average of all players is " +
                players.get(indexOfTallest).toString());
    }
}
