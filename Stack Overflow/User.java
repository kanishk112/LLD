
import java.util.ArrayList;
import java.util.List;

public class User{
    private final int id;
    private final String name;
    private final String email;
    private int reputation;
    private final List<Question> questions;
    private final List<Answer> answers;
    private final List<Comment> comments;

    private static final int COMMENT_REP = 2;
    private static final int QUESTION_REP = 5;
    private static final int ANSWER_REP = 10;

    public User(int id, String name, String email){
        this.name = name;
        this.email = email;
        this.id = id;
        this.reputation = 0;
        this.questions = new ArrayList<>();
        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public Question addQuestion(String title, String content, List<String> tag){
        Question question = new Question(this, title, content, tag);
        questions.add(question);
        updateReputation(QUESTION_REP);
        return question;
    }

    public Answer addAnswer(Question question, String content){
        Answer answer = new Answer(this, question, content);
        answers.add(answer);
        question.addAnswer(answer);
        updateReputation(ANSWER_REP);
        return answer;
    }

    public Comment addComment(Post post, String content){
        Comment comment = new Comment(this, content);
        comments.add(comment);
        post.addComment(comment);
        updateReputation(COMMENT_REP);
        return comment;
    }

    public synchronized void updateReputation(int rep){
        this.reputation += rep;
        if(this.reputation < 0){
            this.reputation = 0;
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getReputation() {
        return reputation;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public List<Comment> getComments() {
        return comments;
    }
}