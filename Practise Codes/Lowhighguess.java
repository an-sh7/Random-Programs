import java.util.Scanner;
public class Lowhighguess {
    public static void main(String[] args) {
        int randomnum = (int) (Math.random() * 100);
        //For testing 
        System.out.println(randomnum);
        //For Testing
        int Points = 0;
        int Attempts = 0;
        Scanner sc = new Scanner(System.in);
        while (true) {
            if (sc.hasNextInt()) { // Check if input is an integer
                int gnum = sc.nextInt();
                Attempts++;
                if (gnum > randomnum) {
                    System.out.println("It's Greater");
                } else if (gnum < randomnum) {
                    System.out.println("It's Smaller");
                } else if (gnum == randomnum) {
                    System.out.println("Correct Guess");
                    Points++;
                    System.out.println("In " + Attempts + " attempts you have won " + Points + " Points ");
                    System.out.println("Do you want to continue (y/n)?");
                    sc.nextLine(); // Removes the newline character
                    String choice = sc.nextLine();
                    if (choice.equalsIgnoreCase("y")) {
                        // Reseting the game
                        randomnum = (int) (Math.random() * 100); // Generating a new random number
                        System.out.println("New game started. Guess again.");
                    } else {
                        break; 
                    }
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                sc.next(); // Ignores the invalid input
            }
        }
        sc.close();
    }
}
