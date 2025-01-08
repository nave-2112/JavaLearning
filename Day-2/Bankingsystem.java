class BankAccount {
     String accountHolderName;
     String accountNumber;
     double balance;

    public BankAccount(String accountHolderName, String accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be greater than 0");
        }
    }

    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdraw: " + amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }

 
    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }
}


class SavingsAccount extends BankAccount {
    double minimumBalance;

    
    public SavingsAccount(String accountHolderName, String accountNumber, double balance, double minimumBalance) {
        super(accountHolderName, accountNumber, balance);
        this.minimumBalance = minimumBalance;
    }

    
    public void withdraw(double amount) {
        if (balance - amount >= minimumBalance) {
            super.withdraw(amount);  
        } else {
            System.out.println("Cannot withdraw Minimum balance of " + minimumBalance + " must be maintained.");
        }
    }

    public void checkMinimumBalance() {
        System.out.println("Minimum balance required: " + minimumBalance);
    }
}


class CurrentAccount extends BankAccount {
 
    public CurrentAccount(String accountHolderName, String accountNumber, double balance) {
        super(accountHolderName, accountNumber, balance);
    }

    public void withdraw(double amount) {
        super.withdraw(amount);  
    }
}

public class Bankingsystem {
    public static void main(String[] args) {
       
        SavingsAccount savings = new SavingsAccount("Naveen sai", "1234", 1000.0, 52000);
        savings.checkBalance();
        savings.deposit(52000);
        savings.withdraw(25000);
        savings.withdraw(10000); 
        savings.checkBalance();
        
        System.out.println();

public class Bankingsystem {
    public static void main(String[] args) {
       
        SavingsAccount savings = new SavingsAccount("Guru charan ", "985632", 10000000.0, 520000000);
        savings.checkBalance();
        savings.deposit(52000);
        savings.withdraw(25000);
        savings.withdraw(10000); 
        savings.checkBalance();
        
        System.out.println();        
        
        CurrentAccount current = new CurrentAccount("mahendre", "55886699", 20000000.0);
        current.checkBalance();
        current.deposit(20000000.0);
        current.withdraw(2500000); 
        current.checkBalance();
    }
}