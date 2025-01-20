
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public class Post {
    private final String id;
    private final String content;
    private final User user;
    private final List<String> comments;
    private final List<User> likes;

    public Post(String id, String content, User user, List<String> comments, List<User> likes) {
        this.id = id;
        this.content = content;
        this.user = user;
        this.comments = comments;
        this.likes = likes;
    }

    public void like(User user){
        this.likes.add(user);
    }

    public void comment(String comment){
        this.comments.add(user.getProfile() + " : "+comment);
    }
}
