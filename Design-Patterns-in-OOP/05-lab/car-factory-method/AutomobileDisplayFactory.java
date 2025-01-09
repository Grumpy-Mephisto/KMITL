public class AutomobileDisplayFactory {
    public enum AutomobileType {
        FORD, TOYOTA
    }

    public static AutomobileDisplay createDisplay(AutomobileType type) {
        return switch (type) {
            case FORD -> new FordDisplay();
            case TOYOTA -> new ToyotaDisplay();
            default -> throw new IllegalArgumentException("Unsupported automobile type: " + type);
        };
    }
}
