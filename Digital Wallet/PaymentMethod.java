
import java.math.BigDecimal;

public abstract class PaymentMethod{
    protected final String paymentId;
    protected final User user;

    public PaymentMethod(String paymentId, User user){
        this.paymentId = paymentId;
        this.user = user;
    }

    public abstract boolean processPayment(BigDecimal amount, Currency currency);

    public String getPaymentId(){
        return paymentId;
    }

    public User getUser(){
        return user;
    }
}