
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Answer implements Post, Votable {

    private final int id;
    private final String content;
    private final User user;
    private final Question question;
    private final List<Comment> comments;
    private final List<Votes> votes;
    private boolean isAccepted;
    private final Date createdAt;

    public Answer(User user, Question question, String content) {
        this.id = generateId();
        this.user = user;
        this.question = question;
        this.content = content;
        this.comments = new ArrayList<>();
        this.votes = new ArrayList<>();
        this.isAccepted = false;
        this.createdAt = new Date();
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    @Override
    public void vote(User user, int vote) {
        if (vote != 1 && vote != -1) {
            throw new IllegalArgumentException("Vote can only be 1 or -1");
        }
        votes.removeIf(v -> v.getUser().getId() == user.getId());
        votes.add(new Votes(user, vote));
        user.updateReputation(vote * 10); // 10 reputation points for each vote
    }

    @Override
    public int getVoteCount() {
        return votes.stream().mapToInt(Votes::getVote).sum();
    }

    public void accept() {
        if (isAccepted) {
            throw new IllegalStateException("Answer is already accepted");
        }
        isAccepted = true;
        user.updateReputation(15); // 15 reputation points for accepted answer
    }

    private int generateId() {
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

    public Question getQuestion() {
        return question;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
