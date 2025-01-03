import java.util.Scanner;
 public class Temp{
    public static void main(String args[])
    {
        Scanner sc= new Scanner (System.in);
        System.out.println("enter temp in celsius");
        int c = sc. nextInt();
        int cel_to_far = (c* 9/5 ) +32 ;
        System. out. println("after converting into fahrenheit the temperature is "+cel_to_far);
         System.out.println( "enter temp in fahrenheit");
         double f = sc.nextDouble();
         double far_to_cel = (f-32)*5/9;
         System. out. println("after converting into celsius the temperature is "+far_to_cel);

        
    }
 }
