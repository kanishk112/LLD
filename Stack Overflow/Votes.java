public class Votes {

    private final User user;
    private final int vote;

    Votes(User user, int vote) {
        this.user = user;
        this.vote = vote;
    }

    public User getUser() {
        return user;
    }

    public int getVote() {
        return vote;
    }

}
