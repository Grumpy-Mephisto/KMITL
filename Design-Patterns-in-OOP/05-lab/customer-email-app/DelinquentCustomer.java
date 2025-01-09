public class DelinquentCustomer extends Customer {
    @Override
    protected String createMail() {
        return "Delinquent Customer Mail";
    }

    @Override
    protected String createBrochure() {
        return "Delinquent Customer Brochure";
    }

    @Override
    protected boolean shouldIncludeBrochure() {
        return false; // Delinquent customers don't receive brochures
    }
}
