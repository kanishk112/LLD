
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DatabaseAppender implements LogAppender {

    private final String jdbcURL;
    private final String username;
    private final String password;

    public DatabaseAppender(String jdbcURL, String username, String password) {
        this.jdbcURL = jdbcURL;
        this.username = username;
        this.password = password;
    }

    @Override
    public void append(LogMessage message) {
        // write the message to the database
        try{
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            PreparedStatement statement = connection.prepareStatement("INSERT INTO logs (timestamp, level, message) VALUES (?,?,?)");
            statement.setString(1, message.getLevel().toString());
            statement.setString(2, message.getMessage());
            statement.setLong(3, message.getTimestamp());
            statement.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}