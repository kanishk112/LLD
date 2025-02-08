
import java.math.BigDecimal;

public class BankAccount extends PaymentMethod{
    private final String accountNumber;
    private final String routingNumber;

    public BankAccount(String accountId, User user, String accountNumber, String routingNumber){
        super(accountId, user);
        this.accountNumber = accountNumber;
        this.routingNumber = routingNumber;
    }

    @Override
    public boolean processPayment(BigDecimal amount, Currency currency){
        return true;
    }
}