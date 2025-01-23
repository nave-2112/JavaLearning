import java.util.*;
public class OnlineshoppingDiscountCalculation{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of items in the cart: ");
        int numberofitems = sc.nextInt();
        double finalprice;
        double[] prices = new double[numberofitems];
        double totalprice = 0;
        for (int i = 0; i < numberofitems; i++) {
            System.out.print("Enter the price of item " + (i + 1) + ": ");
            prices[i] = sc.nextDouble();
            totalprice += prices[i];  
        }
        if(totalprice>500){
            finalprice=totalprice-(10*totalprice)/100;
        }
        else if(totalprice>=200 && totalprice<=500){
            finalprice=totalprice-(5*totalprice)/100;
        }
        else{
            finalprice=totalprice;
        }
        System.out.println("The Final price after discount is: "+finalprice);



    }
}