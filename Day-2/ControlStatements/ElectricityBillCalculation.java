import java.util.*;
public class ElectricityBillCalculation{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no.of Units:");
        int units=sc.nextInt();
        int cost;
        if(units<=100){
            cost=units*1;
            }
        else if(101<=units && units<=200)    {
            cost=100*1+(units-100)*2;
        }
        else{
            cost=100*1+100*2+(units-200)*3;
        }
        System.out.println("Electricity bill:"+cost);
    }
}