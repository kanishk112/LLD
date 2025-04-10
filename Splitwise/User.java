
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class User{
    private final String id;
    private final String userName;
    private final String email;
    private final Map<String, Double> balances;

    public User(String id, String userName, String email){
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.balances = new ConcurrentHashMap<>();
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return userName;
    }

    public String getEmail(){
        return email;
    }

    public Map<String, Double> getBalances(){
        return balances;
    }

}