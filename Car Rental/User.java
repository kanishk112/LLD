public class User{
    private final String Id;
    private final String name;
    private final String email;

    public User(String Id, String name, String email){
        this.Id = Id;
        this.name = name;
        this.email = email;
    }

    public String getId(){
        return Id;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

}