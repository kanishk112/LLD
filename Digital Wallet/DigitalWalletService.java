
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class DigitalWalletService{
    private static DigitalWalletService instance;
    private final Map<String, User> users;
    private final Map<String, Account> accounts;
    private final Map<String, PaymentMethod> paymentMethods;

    private DigitalWalletService(){
        users = new ConcurrentHashMap<>();
        accounts = new ConcurrentHashMap<>();
        paymentMethods = new ConcurrentHashMap<>();
    }

    public static synchronized DigitalWalletService getInstance(){
        if(instance == null){
            instance = new DigitalWalletService();
        }
        return instance;
    }

    public void createUser(User user){
        users.put(user.getUserId(), user);
    }

    public User getUser(String userId){
        return users.get(userId);
    }

    public void createAccount(Account account){
        accounts.put(account.getAccountId(), account);
        account.getUser().addAccount(account);
    }

    public Account geAccount(String accountId){
        return accounts.get(accountId);
    }

    public void addPaymentMethod(PaymentMethod paymentMethod){
        paymentMethods.put(paymentMethod.getPaymentId(), paymentMethod);
    }

    public PaymentMethod getPaymentMethod(String paymentMethodId){
        return paymentMethods.get(paymentMethodId);
    }

    public synchronized void transferFunds(Account sourceAccount, Account destinationAccount, BigDecimal amount, Currency currency) {
        if (sourceAccount.getCurrency() != currency) {
            amount = CurrencyConverter.convert(amount, currency, sourceAccount.getCurrency());
        }
        sourceAccount.withdraw(amount);

        if (destinationAccount.getCurrency() != currency) {
            amount = CurrencyConverter.convert(amount, currency, destinationAccount.getCurrency());
        }
        destinationAccount.deposit(amount);

        String transactionId = generateTransactionId();
        Transaction transaction = new Transaction(transactionId, sourceAccount, destinationAccount, currency, amount);
        sourceAccount.addTransaction(transaction);
        destinationAccount.addTransaction(transaction);
    }

    public List<Transaction> getTransactionHistory(Account account) {
        return account.getTransactions();
    }

    private String generateTransactionId() {
        return "TXN" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}