
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class SplitwiseService{
    private static SplitwiseService splitwiseService;
    private final Map<String, User> users;
    private final Map<String, Group> groups;

    private final static String TRANSACTION_ID_PREFIX = "TXN";
    private static final AtomicInteger transactionCounter = new AtomicInteger(0);

    private SplitwiseService(){
        users = new ConcurrentHashMap<>();
        groups = new ConcurrentHashMap<>();
    }

    public static synchronized SplitwiseService getInstance(){
        if(splitwiseService == null){
            splitwiseService = new SplitwiseService();
        }
        return splitwiseService;
    }

    public void addUser(User user){
        users.put(user.getId(), user);
    }

    public void addGroup(Group group){
        groups.put(group.getId(), group);
    }

    public void addExpense(String groupId, Expenses expenses){
        Group group = groups.get(groupId);
        if(group != null){
            group.addExpenses(expenses);
            splitExpense(expenses);
            updateBalances(expenses);
        }
    }

    private void updateBalances(Expenses expenses) {
        for(Split split: expenses.getSplits()){
            User paidBy = expenses.getPaidBy();
            User user = split.getUser();
            double amount = split.getAmount();

            if(!paidBy.equals(user)){
                updateBalance(paidBy, user, amount);
                updateBalance(user, paidBy, -amount);
            }
        }
    }

    private void splitExpense(Expenses expenses) {
        double totalAmount = expenses.getAmount();
        List<Split> splits = expenses.getSplits();
        int totalSplits = splits.size();

        double splitAmount = totalAmount / totalSplits;
        for(Split split : splits){
            if(split instanceof EqualSplit){
                split.setAmount(splitAmount);
            } else if(split instanceof PercentSplit percentSplit){
                split.setAmount(totalAmount * percentSplit.getPercent() / 100.00);
            }
        }
    }

    private void updateBalance(User paidBy, User user, double amount) {
        String key = getBalanceKey(paidBy, user);
        paidBy.getBalances().put(key, paidBy.getBalances().getOrDefault(key, 0.0) + amount);
    }

    private String getBalanceKey(User paidBy, User user) {
        return paidBy.getId() + ":" + user.getId();
    }

    public void settleBalance(String userId1, String userId2){
        User user1 = users.get(userId1);
        User user2 = users.get(userId2);

        if(user1 != null && user2 != null){
            String key = getBalanceKey(user1, user2);
            double balance = user1.getBalances().getOrDefault(key, 0.0);

            if(balance > 0){
                createTransaction(user1, user2, balance);
                user1.getBalances().put(key, 0.0);
                user2.getBalances().put(getBalanceKey(user2, user1), 0.0);
            } else if(balance < 0){
                createTransaction(user2, user1, Math.abs(balance));
                user1.getBalances().put(key, 0.0);
                user2.getBalances().put(getBalanceKey(user2, user1), 0.0);
            }
        }
    }

    private void createTransaction(User user1, User user2, double balance) {
        String transactionId = generateTransactionId();
        Transaction transaction = new Transaction(transactionId, user2, user2, balance);

    }

    private String generateTransactionId() {
        int transactionNumber = transactionCounter.incrementAndGet();
        return TRANSACTION_ID_PREFIX + String.format("%06d", transactionNumber);
    }
}