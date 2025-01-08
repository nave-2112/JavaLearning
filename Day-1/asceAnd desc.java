import java.util.Scanner;
public class Sort{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
       int[] num=new int[10];
        for(int i=0;i<n;i++){
            num[i]=sc.nextInt();
        }
       int temp=0;
       System.out.println("Decending:");
       for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
            if(num[i]<num[j]){
                temp=num[i];
                num[i]=num[j];
                num[j]=temp;

            }

        }
        System.out.print(num[i]+" ");


       }
       System.out.println("ascending:");

       for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
            if(num[i]>num[j]){
                temp=num[i];
                num[i]=num[j];
                num[j]=temp;

            }

        }
        System.out.print(num[i]+" ");


       }


    }
}