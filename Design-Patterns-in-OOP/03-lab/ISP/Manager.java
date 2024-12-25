class Manager implements IBasicEmployee, IManager, IBonusEmployee {
    public void salary() {
        System.out.println("Getting the salary...");
    }

    public void hire() {
        System.out.println("Hiring new employees...");
    }

    public void train() {
        System.out.println("Training employees...");
    }

    public void addBonus() {
        System.out.println("Adding bonus at the end of the year...");
    }
}
