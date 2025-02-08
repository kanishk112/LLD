
import java.math.BigDecimal;
import java.time.LocalDateTime;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public class Transaction {
    private final String transactionId;
    private final Account sourceAccount;
    private final Account destinationAccount;
    private final BigDecimal amount;
    private final LocalDateTime timeStamp;
    private final Currency currency;

    public Transaction(String transactionId, Account sourceAccount, Account destinationAccount, Currency currency, BigDecimal amount){
        this.transactionId = transactionId;
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
        this.currency = currency;
        this.timeStamp = LocalDateTime.now();
    }

    public String getTransactionId(){
        return transactionId;
    }

    public Account getSourceAccount(){
        return sourceAccount;
    }

    public Account getDestinationAccount(){
        return destinationAccount;
    }

    public BigDecimal getAmount(){
        return amount;
    }

    public Currency getCurrency(){
        return currency;
    }

    public LocalDateTime getTimeStamp(){
        return timeStamp;
    }
}
