public class User{
    private final String userID;
    private final String userName;
    private final String email;

    public User(String userID, String userName, String email){
        this.userID = userID;
        this.userName = userName;
        this.email = email;
    }

    public String getUserID(){
        return userID;
    }

    public String getUserName(){
        return userName;
    }

    public String getEmail(){
        return email;
    }
}