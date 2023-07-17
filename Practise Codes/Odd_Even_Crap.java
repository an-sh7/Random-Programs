import java.util.*;
public class Odd_Even_Crap {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a random digit");
        long num1 = sc.nextLong();
        if (num1 % 2 == 0){
            System.out.println(num1 + " is a Even no.");
        }else{
            System.out.println(num1 + " is a Odd no.");
        }
        sc.close();
    }
}