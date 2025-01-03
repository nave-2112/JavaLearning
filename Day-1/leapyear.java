import java.util.Scanner;
public class leapyear {

 public static void main(String[]args){
    Scanner sc = new Scanner(System.in);
    System.out.print("leapyear:");
    int year =sc. nextInt();
    if (year% 4 == 0 && year % 100 != 0 || year % 400 == 0){
        System.out.println("this is leap year");

    }
    else{
        System.out.println("this is notleap year");
    
    
    }

 }

}