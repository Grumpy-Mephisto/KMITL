public abstract class Customer {
    public String generateCommunication() {
        String mail = createMail();
        String brochure = createBrochure();

        return brochure == null ? mail : mail + "\n" + brochure;
    }

    protected abstract String createMail();

    protected abstract String createBrochure();
}
