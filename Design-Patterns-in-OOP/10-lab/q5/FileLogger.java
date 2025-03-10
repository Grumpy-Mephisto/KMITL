public class FileLogger implements Logger {
    @Override
    public void log(String message, LogLevel level) {
        System.out.println("File::Logger: " + message);
    }
}
