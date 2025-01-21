
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class FacebookService{
    private static FacebookService instance;
    private final Map<String, User> users;
    private final Map<String, List<Notification>> notifications;
    private final Map<String, Post> posts;

    private FacebookService() {
        users = new ConcurrentHashMap<>();
        notifications = new ConcurrentHashMap<>();
        posts = new ConcurrentHashMap<>();
    }

    public static synchronized FacebookService getInstance() {
        if (instance == null) {
            instance = new FacebookService();
        }
        return instance;
    }

    public void registerUser(User user){
        users.put(user.getId(), user);
    }

    public User loginUser(String email, String password){
        for(User user : users.values()){
            if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    public void updateProfile(User user){
        users.put(user.getId(), user);
    }

    public void sendFriendRequest(String senderId, String receiverID){
        User receiver = users.get(receiverID);
        if(receiver != null){
            Notification notification = new Notification(generateNotificationId(), receiverID, Notificationtype.FRIEND_REQUEST, "Friend request from " + users.get(senderId).getName(), new Timestamp(System.currentTimeMillis()));
            addNotification(receiverID, notification);
        }
    }

    public void acceptFriendRequest(String userId, String friendId){
        User user = users.get(userId);
        User friend = users.get(friendId);
        if(user != null && friend != null){
            user.getFriends().add(friendId);
            friend.getFriends().add(userId);
            Notification notification = new Notification(generateNotificationId(), friendId, Notificationtype.FRIEND_REQUEST_ACCEPTED, "Friend request accepted by " + user.getName(), new Timestamp(System.currentTimeMillis()));
            addNotification(friendId, notification);
        }
    }

    public void createPost(Post post){
        posts.put(post.getId(), post);
        User user = users.get(post.getUserId());
        if(user != null){
            user.getPosts().add(post);
        }
        for(String friendId : users.get(post.getUserId()).getFriends()){
            Notification notification = new Notification(generateNotificationId(), friendId, Notificationtype.POST_LIKE, post.getUserId() + " posted a new post", new Timestamp(System.currentTimeMillis()));
            addNotification(friendId, notification);
        }
    }

    public void addComment(Comment comment){
        Post post = posts.get(comment.getPostId());
        if(post != null){
            post.getComments().add(comment);
            User user = users.get(post.getUserId());
            if(user != null){
                Notification notification = new Notification(generateNotificationId(), post.getUserId(), Notificationtype.POST_COMMENT, comment.getUserId() + " commented on your post", new Timestamp(System.currentTimeMillis()));
                addNotification(post.getUserId(), notification);
            }
        }
    }

    public void likePost(String userId, String postId){
        Post post = posts.get(postId);
        if(post != null){
            post.getLikes().add(userId);
            User user = users.get(post.getUserId());
            if(user != null){
                Notification notification = new Notification(generateNotificationId(), post.getUserId(), Notificationtype.POST_LIKE, userId + " liked your post", new Timestamp(System.currentTimeMillis()));
                addNotification(post.getUserId(), notification);
            }
        }
    }

    public List<Post> getFeed(String userId){
        List<Post> feed = new ArrayList<>();
        User user = users.get(userId);
        if(user != null){
            List<String> friendIds = user.getFriends();
            for(String friendId : friendIds){
                User friend = users.get(friendId);
                if(friend != null){
                    feed.addAll(friend.getPosts());
                }
            }
            feed.addAll(user.getPosts());
            feed.sort((p1, p2) -> p2.getTimestamp().compareTo(p1.getTimestamp()));
        }
        return feed;
    }

    private void addNotification(String userId, Notification notification){
        notifications.computeIfAbsent(userId, k-> new CopyOnWriteArrayList<>()).add(notification);
    }

    public List<Notification> getNotifications(String userId){
        return notifications.getOrDefault(userId, new ArrayList<>());
    }

    private String generateNotificationId(){
        return UUID.randomUUID().toString();
    }
}