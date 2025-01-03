import java.util.Scanner;
 public class vote{
    public static void main(String args[])
    {
        Scanner sc= new Scanner (System.in);
        System.out.println("enter age");
        int age = sc. nextInt();
        boolean citizen=sc.nextBoolean();
        if(age>=18 && citizen==true ){
            System.out.println( "you can vote" );
        
        }
        else if(age<18&& citizen==false){
            System.out.println("you cant voke ");
        }
        else 
        {
            System.out.println("new  Baby");
        }
    }}