
import java.util.ArrayList;
import java.util.List;

public class User{
    private final String userId;
    private final String userName;
    private final String email;
    private final String password;
    private final List<Account> accounts;

    public User(String userId, String userName, String email, String password){
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account){
        accounts.add(account);
    }

    public void removeAccount(Account account){
        accounts.remove(account);
    }

    public String getUserId(){
        return userId;
    }

}