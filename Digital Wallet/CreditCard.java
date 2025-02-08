
import java.math.BigDecimal;

public class CreditCard extends PaymentMethod{
    private final String cardNumber;
    private final String expirationDate;
    private final String cvv;

    public CreditCard(String cardNumber, String paymentId, User user, String expirationDate, String cvv){
        super(paymentId, user);
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }

    @Override
    public boolean processPayment(BigDecimal amount, Currency currency){
        return true;
    }
}