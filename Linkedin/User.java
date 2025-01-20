
import java.util.List;

public class User{
    private final String id;
    private final String name;
    private final String email;
    private final String password;
    Profile profile;
    List<Connection> connections;
    List<Message> inbox;
    List<Message> sentMessages;
    private List<Post> posts;
    private List<Job> jobs;

    public User(String id, String name, String email, String password,Profile profile, List<Connection> connections, List<Message> inbox, List<Message> sentMessages){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.profile = profile;
        this.connections = connections;
        this.inbox = inbox;
        this.sentMessages = sentMessages;
    }

    public void setProfile(Profile profile){
        this.profile = profile;
    }   

    public Profile getProfile(){
        return this.profile;
    }

    public String getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }

    public List<Connection> getConnections(){
        return this.connections;
    }

    public List<Message> getInbox(){
        return this.inbox;
    }

    public List<Message> getSentMessages(){
        return this.sentMessages;
    }

    public List<Post> getPosts(){
        return this.posts;
    }

    public List<Job> getJobs(){
        return this.jobs;
    }
}