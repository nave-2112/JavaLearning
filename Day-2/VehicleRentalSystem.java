class Vehicle{
    String vehicletype;
    String numberplate;
    double rentalpriceperday;
    int days;
    public Vehicle(String vehicletype,String numberplate,Double rentalpriceperday,int days){
        this.vehicletype=vehicletype;
        this.numberplate=numberplate;
        this.rentalpriceperday=rentalpriceperday;
        this.days=days;
    }
    public double Totalrent(){
        return rentalpriceperday*days;
    }
    
}
class Car extends Vehicle{
    double driversalary;
    double diselcost;
    public Car(String vehicletype,String numberplate,double rentalpriceperday,int days,double driversalary,double diselcost){
        super(vehicletype,numberplate,rentalpriceperday,days);
        this.driversalary=driversalary;
        this.diselcost=diselcost;
    }
    public double Totalrent(){
        return rentalpriceperday*days+driversalary+diselcost;
    }
}
class Bike extends Vehicle{
    double petrolcost;
    public Bike(String vehicletype,String numberplate,int days,double petrolcost){
        super(vehicletype,numberplate,0.0,days);
        this.petrolcost=petrolcost;
    }
    public double Totalrent(){
        return days*petrolcost;
    }

    
}
class Truck extends Vehicle{
    int rent;
    public Truck(String vehicletype,String numberplate,int rent){
        super(vehicletype,numberplate,0.0,0);
        this.rent=rent;
    }
    public double Totalrent(){
        return rent;
    }
}
public class VehicleRentalSystem{
    public static void main(String args[]){
        Car car=new Car("car","12345",200,2,50000,100);
        Bike bike=new Bike("bike","123",3,3000);
        Truck truck=new Truck("truck","123456",20000);
        System.out.println("total rent of car "+car.Totalrent());
        System.out.println("total rent of bike "+bike.Totalrent());
        System.out.println("total rent of truck "+truck.Totalrent());

    }
}