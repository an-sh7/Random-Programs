import java.util.Scanner;
//Genrate Random Numbers
public class Random{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = sc.nextInt();
        int min = sc.nextInt();
        int num = (int)(Math.random() * (max - min + 1) + min);
        System.out.println(num);
        sc.close();
        
    }
}