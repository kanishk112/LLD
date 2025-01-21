/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Timestamp;
import java.util.List;

public class Post {
    private final String id;
    private final String userId;
    private final String content;
    private final List<String> image;
    private final List<String> video;
    private final Timestamp timestamp;
    private final List<String> likes;
    private final List<Comment> comments;
    
    public Post(String id, String userId, String content, List<String> image, List<String> video, Timestamp timestamp, List<String> likes, List<Comment> comments){
        this.id = id;
        this.userId = userId;
        this.content = content;
        this.image = image;
        this.video = video;
        this.timestamp = timestamp;
        this.likes = likes;
        this.comments = comments;
    }
    
    public String getId(){
        return id;
    }
    
    public String getUserId(){
        return userId;
    }
    
    public String getContent(){
        return content;
    }
    
    public List<String> getImage(){
        return image;
    }
    
    public List<String> getVideo(){
        return video;
    }
    
    public Timestamp getTimestamp(){
        return timestamp;
    }
    
    public List<String> getLikes(){
        return likes;
    }
    
    public List<Comment> getComments(){
        return comments;
    }
}
