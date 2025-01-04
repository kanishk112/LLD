import java.util.List;
public interface Post {
    void addComment(Comment comment);
    List<Comment> getComments();
}
