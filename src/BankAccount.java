// Creating a class BankAccount
// assigned two attributes accountbalance and AccountHolder

public class BankAccount {

    
    private String accountHolderName;
    private int accountNumber;
    private double accountBalance;

 //    creating constructor adding third attribute account number/banl Account exercise
     
  
 public BankAccount( String accountHolderName, int accountNumber, double accountBalance) {
    
     this.accountHolderName = accountHolderName;
     this.accountNumber = accountNumber;
     this.accountBalance = accountBalance;

 }

//  Creating a constructor with no parameter

 public BankAccount(){

 }

 // creating deposit method

 
 public void deposit(double depositAmount) {
   
    accountBalance += depositAmount;
}

// creating withdraw method

public void withdraw(double withdrawAmount) {

    accountBalance -= withdrawAmount;
    
}

// creating get and set method for accountHolderName

public String getAccountHolderName(){

    return this.accountHolderName;
 }

 public String setAccountHolderName(String name) {

    return this.accountHolderName = name;
 }
 
// creating get and set method for accountnumber
 
    
 public int getAccountNumber() {
    return accountNumber;
}

public void setAccountNumber(int accountNumber) {
    this.accountNumber = accountNumber;
}

// creating get and set method for accountbalance

public double getAccountBalance() {
    return accountBalance;
}

public void setAccountBalance(double accountBalance) {
    this.accountBalance = accountBalance;
}


// creating a method for bank transfer

public void transfer(BankAccount account, double amount){

    this.withdraw(amount);
    account.deposit(amount);
      
    
      }



//   creating method to print account details

 public void printAccountDetails() {

 
     System.out.println(accountHolderName + "'s  account balance : " + accountBalance);
     
 }

 
}
