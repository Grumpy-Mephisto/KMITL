public class ToyotaDisplay extends AutomobileDisplay {
    @Override
    public Automobile create() {
        return new Toyota();
    }
}
