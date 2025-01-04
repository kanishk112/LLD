
import java.time.LocalDateTime;

class Comment {
    private final int id;
    private final String content;
    private final User user;
    private final LocalDateTime createdAt;

    public Comment(User user, String content) {
        this.id = generateId();
        this.user = user;
        this.content = content;
        this.createdAt = LocalDateTime.now();
    }

    private int generateId() {
        // logic to generate unique id
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
