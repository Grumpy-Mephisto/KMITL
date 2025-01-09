public class RegularCustomer extends Customer {
    @Override
    protected String createMail() {
        return "Regular Customer Mail";
    }

    @Override
    protected String createBrochure() {
        return "Regular Customer Brochure";
    }
}
