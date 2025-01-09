public class MountainCustomer extends Customer {
    @Override
    protected String createMail() {
        return "Mountain Customer Mail";
    }

    @Override
    protected String createBrochure() {
        return "Mountain Customer Brochure";
    }
}
