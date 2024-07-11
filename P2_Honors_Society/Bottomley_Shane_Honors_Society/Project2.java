// Shane Bottomley Honors Society Membership 06/06/2024
//
// This project takes data from a file "students.txt", located in the root
// directory, which has a students name, credit hours earned, and quality
// points. It then calculates the gpa of each student and makes an honors
// society threshold gpa which is the midpoint between the average gpa and a
// 4.0. It will then display the gpa threshold for honors society, and
// display a list of the students eligible for honors society.

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Project2 {
    public static void main (String[] args) throws FileNotFoundException {
        //Declare class variables
        //create file instance
        java.io.File file = new java.io.File("students.txt");
        if (!file.exists()) {
            throw new FileNotFoundException("students.txt file not found");
        }
        //create scanner for file
        Scanner input = new Scanner(file);

        //create array list for reading in students
        ArrayList<Student> students = new ArrayList<>();

        //total gpa for avg
        double totalGpa = 0;

        //--Read data from file and add to array list--
        while (input.hasNext()) {
            //declare variables from text file to construct student object
            String name = input.next();
            int hoursEarned = input.nextInt();
            double qualityPoints = input.nextDouble();
            String yearOrDegree = input.next();
            
            // test to see which student object
            //test for undergraduate student
            if (yearOrDegree.equals("Freshman") ||
                    yearOrDegree.equals("Sophomore") || 
                    yearOrDegree.equals("Junior") ||
                    yearOrDegree.equals("Senior"))
            {
                //create undergraduate student object
                Undergraduate student = new Undergraduate(
                        name, hoursEarned, qualityPoints, yearOrDegree);

                //add undergraduate student to students array list
                students.add(student);

                //add gpa to total gpa score
                totalGpa += student.getGPA();

            }
            //check for Graduate student
            else if (yearOrDegree.equals("Masters") ||
                    yearOrDegree.equals("Doctorate"))
            {
                //create graduate student object
                Graduate student = new Graduate(
                        name, hoursEarned, qualityPoints, yearOrDegree);

                //add graduate student to array list students
                students.add(student);

                //add gpa to total gpa
                totalGpa += student.getGPA();
            }

            //make all other input just student objects
            else {
                //create student object
                Student student = new Student(name, hoursEarned, qualityPoints);

                //add student to students array list
                students.add(student);

                //add total gpa
                totalGpa += student.getGPA();
            }
        }

        //set the gpa threshold
        Student.setGpaThreshold(totalGpa, students.size());

        //print gpa threshold
        System.out.print("The minimum GPA threshold for Honors Society is ");
        System.out.printf("%.2f" , Student.getMinGpaThreshold());

        //report students eligible for honors society to console
        System.out.println("\n\nThe students eligible for honors society are " +
                "listed below:");
        for (Student i : students ) {
            if (i.eligibleForHonorSociety())
                System.out.println("\n" + i.toString());
        }
    }
}
