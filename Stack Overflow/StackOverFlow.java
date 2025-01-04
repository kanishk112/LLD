
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StackOverFlow {
    private final Map<Integer, User> users;
    private final Map<Integer, Question> questions;
    private final Map<Integer, Answer> answers;
    private final Map<String, Tags> tags;

    public StackOverFlow() {
        users = new HashMap<>();
        questions = new HashMap<>();
        answers = new HashMap<>();
        tags = new HashMap<>();
    }

    public User createUser(String name, String email) {
        int id = users.size() + 1;
        User user = new User(id, name, email);
        users.put(id, user);
        return user;
    }

    public Question createQuestion(User user, String title, String content, List<String> tags) {
        Question question = user.addQuestion(title, content, tags);
        questions.put(question.getId(), question);
        for(Tags tag : question.getTag()) {
            this.tags.putIfAbsent(tag.getName(), tag);
        }
        return question;
    }

    public Answer createAnswer(User user, Question question, String content) {
        Answer answer = user.addAnswer(question, content);
        answers.put(answer.getId(), answer);
        return answer;
    }

    public Comment createComment(User user, Post post, String content) {
        Comment comment = user.addComment(post, content);
        return comment;
    }

    public void voteQuestion(User user, Question question, int isUpvote) {
        question.vote(user, isUpvote);
    }

    public void voteAnswer(User user, Answer answer, int isUpvote) {
        answer.vote(user, isUpvote);
    }

    public void acceptAnswer(Answer answer) {
        answer.accept();
    }

    public List<Question> searchQuestionByTitle(String title) {
        return questions.values().stream().filter(q -> q.getTitle().toLowerCase().contains(title.toLowerCase()) ||
                        q.getContent().toLowerCase().contains(title.toLowerCase()) ||
                        q.getTag().stream().anyMatch(t -> t.getName().equalsIgnoreCase(title)))
                .collect(Collectors.toList());
    }

    public List<Question> getQuestionByUser(User user) {
        return user.getQuestions();
    }

    public User getUser(int id) {
        return users.get(id);
    }

    public Question getQuestion(int id) {
        return questions.get(id);
    }

    public Answer getAnswer(int id) {
        return answers.get(id);
    }

    public Tags getTag(String name) {
        return tags.get(name);
    }
}