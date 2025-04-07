

public class Movie{
    private final String movieId;
    private final String title;
    private final String description;
    private final int movieDuration;

    public Movie(String movieId, String title, String description, int movieDuration){
        this.movieId = movieId;
        this.title = title;
        this.description = description;
        this.movieDuration = movieDuration;
    }

    public int getMovieDuration(){
        return movieDuration;
    }
}