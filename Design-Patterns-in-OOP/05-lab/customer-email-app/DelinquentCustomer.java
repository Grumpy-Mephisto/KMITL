public class DelinquentCustomer extends Customer {
    @Override
    protected String createMail() {
        return "Delinquent Customer Mail";
    }

    @Override
    protected String createBrochure() {
        return null; // Delinquent customers don't receive brochures
    }
}
