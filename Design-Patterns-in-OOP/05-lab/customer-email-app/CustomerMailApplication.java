import java.util.Scanner;

public class CustomerMailApplication {
    private static final Scanner scanner = new Scanner(System.in);

    private static CustomerType getCustomerTypeFromUser() {
        System.out.print("Please choose customer type 1. Regular, 2. Mountain, 3. Delinquent: ");
        int choice = scanner.nextInt();

        return switch (choice) {
            case 1 -> CustomerType.REGULAR;
            case 2 -> CustomerType.MOUNTAIN;
            case 3 -> CustomerType.DELINQUENT;
            default -> throw new IllegalArgumentException("Invalid choice");
        };
    }

    public static void main(String[] args) {
        try {
            CustomerType type = getCustomerTypeFromUser();
            Customer customer = CustomerFactory.createCustomer(type);
            System.out.println(customer.generateCommunication());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
