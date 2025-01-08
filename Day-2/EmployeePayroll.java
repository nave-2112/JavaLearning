class Employee {
    String name;
    String id;
    String designation;
    double basicSalary;

    public Employee(String name, String id, String designation, double basicSalary) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        this.basicSalary = basicSalary;
    }

    public double calculateSalary() {
        return basicSalary;  
    }
}

class FullTimeEmployee extends Employee {
    double hra;
    double da;

    public FullTimeEmployee(String name, String id, String designation, double basicSalary, double hra, double da) {
        super(name, id, designation, basicSalary);
        this.hra = hra;
        this.da = da;
    }

    
    public double calculateSalary() {
        return basicSalary + hra + da;  
    }
}

class PartTimeEmployee extends Employee {
    double hourlyWage;
    int hoursWorked;

    public PartTimeEmployee(String name, String id, String designation, double hourlyWage, int hoursWorked) {
        super(name, id, designation, 0);  
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
    }

    public double calculateSalary() {
        return hourlyWage * hoursWorked;  
    }
}

public class EmployeePayroll {
    public static void main(String[] args) {
        
        FullTimeEmployee ftEmployee = new FullTimeEmployee("Naveen sai singamsetti", "001", "SoftwareEngineer", 5000000000,100000,85200);
        FullTimeEmployee ftEmployee = new FullTimeEmploye("Mahendra", "001", "CEO OF Zenko", 50000, 10000, 5000);
       
        PartTimeEmployee ptEmployee = new PartTimeEmployee("Mahendra", "001", "CEO OF Zenko", 50000, 10000, 5000);

        
        System.out.println("FullTime Employee Salary: " + ftEmployee.calculateSalary());
        System.out.println("PartTime Employee Salary: " + ptEmployee.calculateSalary());
    }
}