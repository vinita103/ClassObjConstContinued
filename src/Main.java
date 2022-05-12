import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<BankAccount> accounts = new ArrayList<>();

    public static void main(String[] args) {

        Scanner user = new Scanner(System.in);

        BankAccount account1 = new BankAccount("Larry", 10001, 5000);
        BankAccount account2 = new BankAccount("Mary", 10002, 300);

        accounts.add(account1);
        accounts.add(account2);

        // Bank Account user input - part 1

        while (true) {

            System.out.println("Hello world! Welcome to the Bank of Carolina");
            System.out.println("Are you an existing customer? ( -1 to exit ) \n 1. Yes \n 2. No ");
            int answer = Integer.valueOf(user.nextLine());

            if (answer == 1) {
                System.out.println("Great! what's your account number?");
                int accNum = Integer.valueOf(user.nextLine());

                // to check if the user is existing account holder
                // if yes then retrieving account info

                boolean isAccountHolder = false;
                int index = -1;

                for (int i = 0; i < accounts.size(); i++) {
                    BankAccount account = accounts.get(i);
                    if (accNum == account.getAccountNumber()) {
                        isAccountHolder = true;
                        index = i;

                    }

                }

                if (isAccountHolder) {

                    mainMenu(accounts.get(index));

                } else {

                    System.out.println("Account doesn't exist");

                }

            } else if (answer == 2) {

                BankAccount newAccount = new BankAccount();

                System.out.println("Let's make a new account!");
                System.out.println("What is the name for the account?");
                String name = user.nextLine();
                newAccount.setAccountHolderName(name);

                // to get account balance

                System.out.println(" What is the beginning balance for the account?");
                double amount = Double.valueOf(user.nextLine());
                newAccount.setAccountBalance(amount);

                accounts.add(newAccount);

                mainMenu(accounts.get(accounts.size() - 1));

                // enter -1 to exit

            } else if (answer == -1) {

                System.out.println("Good Bye!");

                break;

            }

        }

    }

    // Part 2- Bank Menu - creating a mainMenu method

    public static void mainMenu(BankAccount account) {
        Scanner user = new Scanner(System.in);

        System.out.println("Hello " + account.getAccountHolderName());

        while (true) {

            System.out.println("Welcome to the Main Menu, what would you like to do today?");

            System.out.println(
                    " 1. To check account balance \n 2. To make a withdraw \n 3.To make a deposit  \n 4.To make a transfer to an another account \n 0. To exit");
            int answer = Integer.valueOf(user.nextLine());

            // to get account balance

            if (answer == 1) {

                System.out.println(" Your account balance is: " + account.getAccountBalance());

                // to withdraw money

            } else if (answer == 2) {
                System.out.println("Please enter an amount to withdraw");
                double withdrawAmount = Double.valueOf(user.nextLine());
                account.withdraw(withdrawAmount);
                System.out.println("Amount withdrawn is: " + withdrawAmount);

                // to deposit money

            } else if (answer == 3) {
                System.out.println("Please enter an amount to deposit");
                double depositAmount = Double.valueOf(user.nextLine());
                account.withdraw(depositAmount);
                System.out.println("Amount deposited is:" + depositAmount);

                // to transfer money to another Account
                 // to check if the user is existing account holder
                // if yes then retrieving account info

            } else if (answer == 4) {
                System.out.println("Please enter the account number to transfer to ");
                int accNumToTransfer = Integer.valueOf(user.nextLine());

                BankAccount newAccount1 = new BankAccount();

                boolean isAccountHolder = false;

                for (int i = 0; i < accounts.size(); i++) {
                    BankAccount newAccount2 = accounts.get(i);
                    if (accNumToTransfer == newAccount2.getAccountNumber()) {
                        newAccount1 = newAccount2;
                        isAccountHolder = true;

                    }
                }

                if (isAccountHolder) {
                    System.out.println("Please enter the amount to transfer ");
                    double transferAmount = Double.valueOf(user.nextLine());

                    account.transfer(newAccount1, transferAmount);
                    System.out.println("The name on the account is: " + account.getAccountHolderName()
                            + " and they have a balance of  " + account.getAccountBalance());

        // if account info doesn't match

                } else {
                    System.out.println("Account doesn't exist ");
                }

                // enter 0 to exit

            } else if (answer == 0) {

                System.out.println("Good Bye!");

                break;

            }

        }

    }

}
