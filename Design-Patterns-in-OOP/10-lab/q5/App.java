public class App {
    public static void main(String[] args) {
        UnifiedLogger logger = new UnifiedLogger();

        logger.log("This is an information.", LogLevel.INFO);
        System.out.println();

        logger.log("This is a debug information.", LogLevel.DEBUG);
        System.out.println();

        logger.log("This is an error information.", LogLevel.ERROR);
    }
}
