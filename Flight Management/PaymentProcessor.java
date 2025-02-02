public class PaymentProcessor {
    private static PaymentProcessor instance;

    private PaymentProcessor() {

    }

    public static PaymentProcessor getInstance() {
        if (instance == null) {
            instance = new PaymentProcessor();
        }
        return instance;
    }

    public void processPayment(Payment payment) {
        System.out.println("Processing payment of " + payment.getAmount() + " with payment id: " + payment.getPaymentId());
        payment.processPayment();
    }
}