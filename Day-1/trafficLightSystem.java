import java.util.Scanner;

public class trafficLightSystem {
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Traffic Light System: ");
        String color = in.next().toUpperCase();
        System.out.print("Is there is an obstacle: ");
        // boolean obstacle = in.nextBoolean();
        String obstacle = in.next().toLowerCase();
        if(obstacle=="yes"){
            System.out.println("There's an obstacle... Please Stop..!!!!");
        }
        else{jaa
            switch(color){
                case "GREEN":
                    System.out.println("Go Fast as Fast...!");
                    break;
                case "YELLOW":
                    System.out.println("Slow Down...!");
                    break;
                case "RED":
                    System.out.println("Stop....!");
                    break;
                
                default:
                    System.out.println("Wrong Signal....!!!!");
                    break;
            }
        }
        in.close();
    }
}
