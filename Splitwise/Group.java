
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Group{
    private final String id;
    private final String name;
    private final List<User> users;
    private final List<Expenses> expenses;

    public Group(String id, String name){
        this.id = id;
        this.name = name;
        this.expenses = new CopyOnWriteArrayList<>();
        this.users = new CopyOnWriteArrayList<>();
    }

    public void addMember(User user){
        users.add(user);
    }

    public void addExpenses(Expenses expense){
        expenses.add(expense);
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public List<User> getMembers(){
        return users;
    }

    public List<Expenses> getExpenseses(){
        return expenses;
    }
}