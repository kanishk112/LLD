public interface Votable {
    void vote(User user, int vote);
    int getVoteCount();
}