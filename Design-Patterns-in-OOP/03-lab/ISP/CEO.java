class CEO implements IBasicEmployee, IBonusEmployee, ICEO {
    public void salary() {
        System.out.println("Getting the salary...");
    }

    public void addBonus() {
        System.out.println("Adding bonus at the end of the year...");
    }

    public void makeDecisions() {
        System.out.println("Making decisions...");
    }

    public void addStocks() {
        System.out.println("Gettings shares of the company as bonus...");
    }
}

