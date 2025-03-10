public class StandardConsoleLogger implements Logger {
    @Override
    public void log(String message, LogLevel level) {
        System.out.println("Standard Console::Logger: " + message);
    }
}
