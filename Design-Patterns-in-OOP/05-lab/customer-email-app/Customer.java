public abstract class Customer {
    /**
     * Template method that defines the algorithm for creating a communications
     * 
     * @return the communication
     */
    public final String createCommunication() {
        StringBuilder communication = new StringBuilder();
        communication.append(createMail());

        if (shouldIncludeBrochure()) {
            communication.append("\n").append(createBrochure());
        }
        return communication.toString();
    }

    /**
     * Abstract method to be implemented by concrete customer types for mail creation
     */
    protected abstract String createMail();

    /**
     * Abstract method to be implemented by concrete customer types for brochure creation
     */
    protected abstract String createBrochure();

    /**
     * Hook method that can be overridden by subclasses to control brochure inclusion
     */
    protected boolean shouldIncludeBrochure() {
        return true;
    }
}
