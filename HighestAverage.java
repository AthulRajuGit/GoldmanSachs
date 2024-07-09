## highest average

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// class Student {
//     String name;
//     String grade;
    
//     public Student(String n , String g) {
//         name = n;
//         grade = g;
//     }
// }

class Test { // Helper class to keep track of grades and average.
    double totalGrade;
    int count;
    public Test(double grade) {
        totalGrade = grade;
        count = 1;
    }

    public void addGrade(double newGrade) { //Add a grade and increment the counter
        totalGrade += newGrade;
        count++;
    }

    public int getAverage() {
        Double avg = (totalGrade/count);
        return avg.intValue(); //Will drop everything after the decimal.
    }
}

public class Solution {
   static int highestAverageScore(String[][] students) {
        HashMap<String, Test> averages = new HashMap<>(students.length); //Set capacity to longest possible
        String sName; //Declare outside of loop
        String sGrade;
        for(String[] s : students) {
            sName = s[0] != null ? s[0] : "NULL"; // Null check ternary
            sGrade = (s[1] == null || s[1].equals("")) ? "0" : s[1];
            if (averages.containsKey(sName)) { //If exist add grade otherwise create new entry
                averages.get(sName).addGrade(Double.parseDouble(sGrade)); //converts String to Double
            } else {
                averages.put(sName, new Test(Double.parseDouble(sGrade)));
            }
        }
        String maxName = "NONE";
        int max = 0;
        for (Map.Entry<String, Test> avg : averages.entrySet()) { // Find the highest average.
            if (avg.getValue().getAverage() > max) { // will only update on greater only aka in a tie it will choose the first person that appears.
                max = avg.getValue().getAverage();
                maxName = avg.getKey();
            }
        }
        //System.out.println(maxName + " has the highest average of: " + max); // Debug code
        return max;
   }

   public static void main(String[] args) {
    //    ArrayList<Student> students = new ArrayList<>();
    //    students.add(new Student("Bob", "87"));
    //    students.add(new Student("Mike", "35.3"));
    //    students.add(new Student("Bob", "52"));
    //    students.add(new Student("Jason", "35"));
    //    students.add(new Student("Mike", "55"));
    //    students.add(new Student("Jessica", "99"));
    //    students.add(new Student("Jessica", "99.3"));
        String students[][] = {
            {"Bob","87"}, 
            {"Mike", "35"},
            {"Bob", "52"},
            {"Jason","35"},
            {"Mike", "55"},
            {"Jessica", "99"},
            {"Alice", ""},
            {"Alice", null},
            {null, "100"},
            {null, null}
        };

       int expected = 99;
       int result = highestAverageScore(students);
       if (result == expected) {
            System.out.println("Pass");
        } else {
            System.out.println("Expected: " + expected + " got: " + result);
       }
    }
}
