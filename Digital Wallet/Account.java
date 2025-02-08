
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public class Account {
    private final String accountId;
    private final String accountNumber;
    private final User user;
    private final Currency currency;
    private BigDecimal balance;
    private final List<Transaction> transactions;

    public Account(String accountId, User user, String accountNumber, Currency currency){
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.user = user;
        this.currency = currency;
        this.balance = BigDecimal.ZERO;
        this.transactions = new ArrayList<>();
    }

    public synchronized void deposit(BigDecimal amount){
        balance = balance.add(amount);
    }

    public synchronized void withdraw(BigDecimal amount){
        if(balance.compareTo(amount) >= 0){
            balance = balance.subtract(amount);
        } else{
            throw new InsufficientFundsException("Insufficient funds in the account.");
        }
    }

    public synchronized void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }

    public String getAccountId(){
        return accountId;
    }

    public User getUser(){
        return user;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public Currency getCurrency(){
        return currency;
    }

    public BigDecimal getBalance(){
        return balance;
    }

    public List<Transaction> getTransactions(){
        return transactions;
    }

}
