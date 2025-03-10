public class ErrorConsoleLogger implements Logger {
    @Override
    public void log(String message, LogLevel level) {
        System.out.println("Error Console::Logger: " + message);
    }
}
