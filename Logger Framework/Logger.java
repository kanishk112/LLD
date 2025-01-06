public class Logger{
    private static final Logger loggerInstance = new Logger();
    private LoggerConfig loggerConfig;

    private Logger(){
        loggerConfig = new LoggerConfig(LogLevel.INFO, new ConsoleAppender());
    }

    public static Logger getInstance(){
        return loggerInstance;
    }

    public void setLoggerConfig(LoggerConfig loggerConfig){
        this.loggerConfig = loggerConfig;
    }

    public void log(LogLevel level, String message){
        if(level.ordinal() >= loggerConfig.getLogLevel().ordinal()){
            LogMessage logMessage = new LogMessage(level, message, System.currentTimeMillis());
            loggerConfig.getLogAppender().append(logMessage);
        }
    }

    public void debug(String message){
        log(LogLevel.DEBUG, message);
    }

    public void info(String message){
        log(LogLevel.INFO, message);
    }

    public void warn(String message){
        log(LogLevel.WARN, message);
    }

    public void error(String message){
        log(LogLevel.ERROR, message);
    }

    public void fatal(String message){
        log(LogLevel.FATAL, message);
    }
}