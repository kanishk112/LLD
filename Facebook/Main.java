
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FacebookService facebookService = FacebookService.getInstance();

        // User registration
        User user1 = new User("1", "John Doe", "john@example.com", "password", "profile1.jpg", "I love coding!", new ArrayList<>(), new ArrayList<>());
        User user2 = new User("2", "Jane Smith", "jane@example.com", "password", "profile2.jpg", "Exploring the world!", new ArrayList<>(), new ArrayList<>());
        facebookService.registerUser(user1);
        facebookService.registerUser(user2);

        // User login
        User loggedInUser = facebookService.loginUser("john@example.com", "password");
        if (loggedInUser != null) {
            System.out.println("User logged in: " + loggedInUser.getName());
        } else {
            System.out.println("Invalid email or password.");
        }

        // Send friend request
        facebookService.sendFriendRequest(user1.getId(), user2.getId());

        // Accept friend request
        facebookService.acceptFriendRequest(user2.getId(), user1.getId());

        // Create posts
        Post post1 = new Post("post1", user1.getId(), "My first post!", new ArrayList<>(), new ArrayList<>(), new Timestamp(System.currentTimeMillis()), new ArrayList<>(), new ArrayList<>());
        Post post2 = new Post("post2", user2.getId(), "Having a great day!", new ArrayList<>(), new ArrayList<>(), new Timestamp(System.currentTimeMillis()), new ArrayList<>(), new ArrayList<>());
        facebookService.createPost(post1);
        facebookService.createPost(post2);

        // Like a post
        facebookService.likePost(user2.getId(), post1.getId());

        // Comment on a post
        Comment comment = new Comment("comment1", user2.getId(), post1.getId(), "Great post!", new Timestamp(System.currentTimeMillis()));
        facebookService.addComment(comment);

        // Get newsfeed
        List<Post> newsfeed = facebookService.getFeed(user1.getId());
        System.out.println("Newsfeed:");
        for (Post post : newsfeed) {
            System.out.println("Post: " + post.getContent());
            System.out.println("Likes: " + post.getLikes().size());
            System.out.println("Comments: " + post.getComments().size());
            System.out.println();
        }

        // Get notifications
        List<Notification> notifications = facebookService.getNotifications(user1.getId());
        System.out.println("Notifications:");
        for (Notification notification : notifications) {
            System.out.println("Type: " + notification.getType());
            System.out.println("Content: " + notification.getContent());
            System.out.println();
        }
    }
}