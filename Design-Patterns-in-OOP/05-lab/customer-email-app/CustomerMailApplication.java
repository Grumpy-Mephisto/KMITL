import java.util.Objects;
import java.util.Scanner;

public class CustomerMailApplication {
    private final Customer customer;

    public CustomerMailApplication(Customer customer) {
        this.customer = Objects.requireNonNull(customer, "Customer cannot be null");
    }

    public static String getCustomerTypeFromUser() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Please choose customer type 1. Regular, 2. Mountain, 3. Delinquent ");
            int type = scanner.nextInt();

            return switch (type) {
                case 1 -> "Regular";
                case 2 -> "Mountain";
                case 3 -> "Delinquent";
                default -> throw new IllegalArgumentException("Invalid customer type: " + type);
            };
        }
    }

    public String generateCommunication() {
        return customer.createCommunication();
    }

    public static void main(String[] args) {
        try {
            String customerType = getCustomerTypeFromUser();
            Customer customer = CustomerFactory.createCustomer(customerType);
            CustomerMailApplication app = new CustomerMailApplication(customer);
            System.out.println(app.generateCommunication());
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
