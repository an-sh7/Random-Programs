import java.util.*;
public class Switch_Case_Calculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("This is a random calculator made by AJ ");
        System.out.println("I created this because i am brored");
        //Lets Start
        //This is going to be a switch case calculator
        //Take first input
        System.out.println("Enter first digit");
        long num1  = sc.nextLong();
        //Take Second input
        System.out.println("Enter Second digit");
        long num2 = sc.nextLong();
        System.out.println("Choose the options respectively");
        //Remeber to add options to choose next time
        //Writing System.out.println is frustating
        //Found something. Just type syso then enter // In vscode
        System.out.println("1. Add");
        System.out.println("2. Sub");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Reminder/Modules");
        System.out.println("6. Everything");
        //Get value for calculation
        int choice = sc.nextInt();
        
        switch (choice) {
            case 1:
                System.out.print(num1 + " + " + num2 + " is equal to " + (num1 + num2));
                break;
            case 2:
                System.out.print(num1 +  " - " + num2 + " is equal to " + (num1 - num2));
                break;
            case 3:
                System.out.print(num1 + " x " + num2 + " is equal to " + (num1 * num2));
                break;
            case 4:
                System.out.print(num1 + " / " + num2 + " is equal to " + (num1 / num2));
                break;
            case 5:
                System.out.print(num1 + " % " + num2 + " is equal to " + (num1 % num2));
                break;
            case 6:
                //In this option we are going to print every solution
                System.out.print(num1 + " + " + num2 + " is equal to " + (num1 + num2));
                System.out.print(num1 +  " - " + num2 + " is equal to " + (num1 - num2));
                System.out.print(num1 + " x " + num2 + " is equal to " + (num1 * num2));
                System.out.print(num1 + " / " + num2 + " is equal to " + (num1 / num2));
                System.out.print(num1 + " % " + num2 + " is equal to " + (num1 % num2));
                break;

            default:
                System.out.println("Wrong input you stupid");
                break;
        }
        //closing the input function to stop memory leak
        sc.close();    
    }
}
