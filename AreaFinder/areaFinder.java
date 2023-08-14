//Making a program to find area of the Circle,Triangle,Square,Rectangle 
//and calling those function using Switch Case

//Import Scanner to get user input
import java.util.Scanner;

//Method to find the area of circle
class circleArea{
    public double aCircle(){
        Scanner scc = new Scanner(System.in);
        double PI = 3.14;
        System.out.println("Enter the radius");
        double radius = scc.nextDouble();
        double Area = radius * radius * PI ;
        scc.close();
        return Area;  
    }
}

//Method to find triangles area
class triangleArea{
    public double aTriangle(){
        Scanner sct = new Scanner(System.in);
        System.out.println("Enter Length of Base");
        double base = sct.nextDouble();
        System.out.println("Enter the length Height");
        double height = sct.nextDouble();
        double area = (base * height) /2;
        sct.close();
        return area;
    }
}

//Method to find the area of Square
class squareArea{
    public double aSquare(){
        Scanner scs = new Scanner(System.in);
        System.out.println("Enter lenght of a side");
        double edge = scs.nextDouble();
        double area = edge * edge;
        scs.close();
        return area;
    }
}
//Method to find the area of rectangle
class rectangleArea{
    public double aRectangle(){
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter lenght");
        double length = scr.nextDouble();
        System.out.println("Enter the width");
        double width =  scr.nextDouble();
        double area = length * width;
        scr.close();
        return area;
    }

}

//Creating main function

public class areaFinder {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        circleArea ca = new circleArea();
        triangleArea ta = new triangleArea();
        squareArea sa = new squareArea();
        rectangleArea ra = new rectangleArea();
        System.out.println("Select a Number\n1. Circle\n2. Triangle\n3. Square\n4. Rectangle\n");
        int choice = sc.nextInt();
        sc.close();
        switch (choice){
        case 1:
            double Areaoc = ca.aCircle();
            System.out.println(Areaoc);
            break;
        case 2:
            double Areaot = ta.aTriangle();
            System.out.println(Areaot);
            break;
        case 3:
            double Areaos = sa.aSquare();
            System.out.println(Areaos);
            break;
        case 4:
            double Areaor = ra.aRectangle();
            System.out.println(Areaor);
            break;
        default:
            System.out.println("Wrong input");
            break;
        } 
    }
}