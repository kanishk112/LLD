public class Main{
    public static void main(String[] args){
        Logger logger = Logger.getInstance();
        logger.log(LogLevel.INFO, "This is an info message");
        logger.log(LogLevel.WARN, "This is a warning message");
        logger.log(LogLevel.ERROR, "This is an error message");
        logger.log(LogLevel.DEBUG, "This is a debug message");
        logger.log(LogLevel.FATAL, "This is a fatal message");

        LoggerConfig config = new LoggerConfig(LogLevel.DEBUG, new FileAppender("app.log"));
        logger.setLoggerConfig(config);

        logger.info("This is an information message");
        logger.debug("This is a debug message");
    }
}