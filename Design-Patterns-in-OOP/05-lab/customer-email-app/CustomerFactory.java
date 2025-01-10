public class CustomerFactory {
    public static Customer createCustomer(CustomerType type) {
        return switch (type) {
            case REGULAR -> new RegularCustomer();
            case MOUNTAIN -> new MountainCustomer();
            case DELINQUENT -> new DelinquentCustomer();
        };
    }
}
