import java.util.*;
class TrafficLightSimulation{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Light colour:");
        String choice=sc.nextLine();
        switch(choice){
            case "Red":
                System.out.println("Stop");
                break;
            case "Yellow":
                System.out.println("Get Ready");
                break;
            case "Green":
                System.out.println("Go");
                break;
            default:
                System.out.println("Invalid Choice");            

        }

    }
}