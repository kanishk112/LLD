
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class LinkedInService {

    private static LinkedInService instance;
    private final Map<String, User> users;
    private final Map<String, Job> jobs;
    private final Map<String, List<Notification>> notifications;

    private LinkedInService() {
        this.users = new ConcurrentHashMap<>();
        this.jobs = new ConcurrentHashMap<>();
        this.notifications = new ConcurrentHashMap<>();
    }

    public static synchronized LinkedInService getInstance() {
        if (instance == null) {
            instance = new LinkedInService();
        }
        return instance;
    }

    public void registerUser(User user) {
        this.users.put(user.getId(), user);
    }

    public User loginUser(String email, String password) {
        for (User user : this.users.values()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public void updateProfile(User user) {
        users.put(user.getId(), user);
    }

    public void sendConnectionRequest(User sender, User receiver) {
        Connection connection = new Connection(sender, new Timestamp(System.currentTimeMillis()));
        sender.getConnections().add(connection);
        receiver.getConnections().add(connection);
        Notification notification = new Notification(generateNotificationId(), receiver,
                NotificationType.CONNECTION_REQUEST, "New connection request from " + sender.getName(),
                new Timestamp(System.currentTimeMillis()));
        addNotification(receiver.getId(), notification);
    }

    public void acceptConnectionRequest(User receiver, User sender) {
        for (Connection connection : receiver.getConnections()) {
            if (connection.getUser().equals(sender)) {
                receiver.getConnections().add(new Connection(sender, new Timestamp(System.currentTimeMillis())));
                break;
            }
        }
    }

    public List<User> searchUsers(String name) {
        List<User> searchResults = new ArrayList<>();
        for (User user : this.users.values()) {
            if (user.getName().contains(name)) {
                searchResults.add(user);
            }
        }
        return searchResults;
    }

    public void postJob(Job job) {
        this.jobs.put(job.getId(), job);
        for (User user : this.users.values()) {
            Notification notification = new Notification(generateNotificationId(), user,
            NotificationType.JOB_POST, "New job posted: " + job.getTitle(),new Timestamp(System.currentTimeMillis()));
            addNotification(user.getId(), notification);
        }
    }

    public List<Job> searchJobs(String title) {
        List<Job> searchResults = new ArrayList<>();
        for (Job job : this.jobs.values()) {
            if (job.getTitle().contains(title)) {
                searchResults.add(job);
            }
        }
        return searchResults;
    }

    public void sendMessage(User sender, User reciever, String message) {
        Message newMessage = new Message(generateMessageId(), sender, reciever, message, new Timestamp(System.currentTimeMillis()));
        reciever.getInbox().add(newMessage);
        sender.getSentMessages().add(newMessage);
        Notification notification = new Notification(generateNotificationId(), reciever,
                NotificationType.MESSAGE, "New message from " + sender.getName(), new Timestamp(System.currentTimeMillis()));
        addNotification(reciever.getId(), notification);
    }

    public void addNotification(String userId, Notification notification) {
        if (!notifications.containsKey(userId)) {
            notifications.put(userId, new ArrayList<>());
        }
        notifications.get(userId).add(notification);
    }

    public List<Notification> getNotifications(String userId) {
        return notifications.get(userId);
    }

    private String generateNotificationId() {
        return UUID.randomUUID().toString();
    }

    private String generateMessageId() {
        return UUID.randomUUID().toString();
    }
}
