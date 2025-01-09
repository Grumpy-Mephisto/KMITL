import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class CustomerFactory {
    private static final Map<String, Supplier<Customer>> CUSTOMER_TYPES = new HashMap<>();

    static {
        CUSTOMER_TYPES.put("Regular", RegularCustomer::new);
        CUSTOMER_TYPES.put("Mountain", MountainCustomer::new);
        CUSTOMER_TYPES.put("Delinquent", DelinquentCustomer::new);
    }

    /**
     * Factory method to create customer instances
     * 
     * @param customerType the type of customer to create
     * @return Customer instance
     * @throws IllegalArgumentException if customer type is not supported
     */
    public static Customer createCustomer(String customerType) {
        Supplier<Customer> supplier = CUSTOMER_TYPES.get(customerType);
        if (supplier == null) {
            throw new IllegalArgumentException("Unsupported customer type: " + customerType);
        }
        return supplier.get();
    }

    /**
     * Register a new customer type
     * 
     * @param type customer type identifier
     * @param supplier supplier function to create customer instance
     */
    public static void registerCustomerType(String type, Supplier<Customer> supplier) {
        CUSTOMER_TYPES.put(type, supplier);
    }
}
