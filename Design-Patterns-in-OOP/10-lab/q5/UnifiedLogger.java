public class UnifiedLogger {
    private Logger standardLogger = new StandardConsoleLogger();
    private Logger fileLogger = new FileLogger();
    private Logger errorLogger = new ErrorConsoleLogger();

    public void log(String message, LogLevel level) {
        switch (level) {
            case INFO:
                // INFO: Only show on standard console
                standardLogger.log(message, level);
                break;
            case DEBUG:
                // DEBUG: Show on file and standard console
                fileLogger.log(message, level);
                standardLogger.log(message, level);
                break;
            case ERROR:
                // ERROR: Show on error console, file and standard console
                errorLogger.log(message, level);
                fileLogger.log(message, level);
                standardLogger.log(message, level);
                break;
        }
    }
}
