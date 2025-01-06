public class LogMessage{
    private final LogLevel level;
    private final String message;
    private final long timestamp;
    
    public LogMessage(LogLevel level, String message, long timestamp){
        this.level = level;
        this.message = message;
        this.timestamp = timestamp;
    }
    
    public LogLevel getLevel(){
        return level;
    }
    
    public String getMessage(){
        return message;
    }
    
    public long getTimestamp(){
        return timestamp;
    }
    
    @Override
    public String toString(){
        return "[ "+timestamp + " : " + level + " : " + message+" ]";
    }
}