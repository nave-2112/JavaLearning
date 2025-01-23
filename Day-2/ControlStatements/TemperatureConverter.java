import java.util.*;
public class TemperatureConverter{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Temperature Converter");
        System.out.println("1.Celsius to Fahrenheit");
        System.out.println("2.Fahrenheit to celsius");
        System.out.println("Enter choice for temperature converter");
        int choice=sc.nextInt();
        switch(choice){
            case 1:
                System.out.println("Enter the temparature in celsius:");
                double cel=sc.nextDouble();
                double cel_to_far=(cel*9/5)+32;
                System.out.println("celsius to fahrenheit "+cel_to_far);
                break;
            case 2:
                System.out.println("Enter the temparature in Fahrenheit:");
                double far=sc.nextDouble();
                double far_to_cel=(far-32)*5/9;
                System.out.println("fahrenheit to celsius "+ far_to_cel);
                break;
            default:
                System.out.println("Invalid choice");
        
                

        }
    }
}