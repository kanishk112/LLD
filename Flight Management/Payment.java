public class Payment{
    private final String paymentId;
    private final String bookingId;
    private final double amount;
    private PaymentStatus status;

    public Payment(String paymentId, String bookingId, double amount){
        this.paymentId = paymentId;
        this.bookingId = bookingId;
        this.amount = amount;
        this.status = PaymentStatus.PENDING;
    }

    public void processPayment(){
        System.out.println("Processing payment of " + amount + " with payment id: " + paymentId + " and the status is " + status);
        status = PaymentStatus.SUCCESS;
    }

    public String getPaymentId(){
        return paymentId;
    }


    public double getAmount(){
        return amount;
    }
}