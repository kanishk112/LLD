
import java.sql.Timestamp;

public class Notification{
    private final String id;
    private final User user;
    private final NotificationType type;
    private final String message;
    private final Timestamp timestamp;

    public Notification(String id, User user, NotificationType type, String message, Timestamp timestamp){
        this.id = id;
        this.user = user;
        this.type = type;
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getId(){
        return this.id;
    }

    public User getUser(){
        return this.user;
    }

    public NotificationType getType(){
        return this.type;
    }

    public String getMessage(){
        return this.message;
    }

    public Timestamp getTimestamp(){
        return this.timestamp;
    }

}