import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class Question implements Post, Votable {
    private final int id;
    private final String title;
    private final String content;
    private final User user;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private final List<Answer> answers;
    private final List<Comment> comments;
    private final List<Tags> tags;
    private final List<Votes> votes;
    private boolean isClosed;
    private boolean isDeleted;

    public Question(User user, String title, String content, List<String> tagNames) {
        this.id = generateId();
        this.user = user;
        this.title = title;
        this.content = content;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.tags = new ArrayList<>();
        this.votes = new ArrayList<>();
        this.isClosed = false;
        this.isDeleted = false;

        for(String t : tagNames) {
            this.tags.add(new Tags(t));
        }
    }

    public void addAnswer(Answer answer) {
        if(!answers.contains(answer)) {
            answers.add(answer);
        }
    }
    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }
    @Override
    public void vote(User user, int vote) {
        if(vote != 1 && vote != -1) {
            throw new IllegalArgumentException("Vote can only be 1 or -1");
        }
        votes.removeIf(v -> v.getUser().getId() == user.getId());
        votes.add(new Votes(user, vote));
        user.updateReputation(vote * 5); // 5 reputation points for each vote
    }
    @Override
    public int getVoteCount() {
        return votes.stream().mapToInt(Votes::getVote).sum();
    }

    @Override
    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public List<Tags> getTag() {
        return new ArrayList<>(tags);
    }

    public User getUser() {
        return user;
    }

    public List<Answer> getAnswers() {
        return new ArrayList<>(answers);
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public boolean isIsClosed() {
        return isClosed;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }
}
