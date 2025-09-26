// Requirements:
// Account Class

// Properties: accountNumber, balance, accountHolderName

// Methods: deposit(amount), withdraw(amount), getBalance()

// Bank Class

// Properties: list of accounts

// Methods: createAccount(), findAccount(), transfer()

// Special Rule:
// Overdraft protection: Withdrawals can't go below -100

// Use @Override for toString() method in Account class

import java.util.ArrayList;

class Account {
    int accountNumber;
    double balance;
    String accountHolderName;

    Account(int accountNumber, double balance, String name) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountHolderName = name;
    }

    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("Successfull deposited %d :✅" + amount);
    }

    public void withdraw(double amount) {
        if ((balance - amount) >= -100) {
            this.balance -= amount;
            System.out.println("Successfull withdrew %d :✅" + amount);
        } else {
            System.out.println("withdraw failed");
        }
    }

    public String getBalance() {
        return "Your balance is:" + balance;
    }

    @Override
    public String toString() {
        return accountHolderName + "has the balance:" + balance;
    }
}

class Bank {
    ArrayList<Account> listOfAccounts;

    Bank() {
        this.listOfAccounts = new ArrayList<>();
    }

    public void createAccount(Account Account) {
        listOfAccounts.add(Account);
    }

    public Account findAccount(String name) {
        for (Account account : listOfAccounts) {
            if (account.accountHolderName.equals(name)) {
                return account;
            }
        }
        return null;
    }

    public void transfer(Account sender, Account receriver, int amount) {
        Account accountSender = findAccount(sender.accountHolderName);
        Account accountReceiver = findAccount(receriver.accountHolderName);
        if (((accountSender.balance - amount) >= -100) && (accountReceiver != null)) {
            accountSender.balance -= amount;
            accountReceiver.balance += amount;
            System.out.println("successfully transferred to the account");
        } else {
            System.out.println("transfer failed");
        }
    }

}

public class OopSmallBankSystem {

    public static void main(String[] args) {
        Bank myBank = new Bank();
        Account myAccount = new Account(123, 50000, "jon doe");
        System.out.println(myAccount.toString());
        System.out.println("==========check===========");
    }
}