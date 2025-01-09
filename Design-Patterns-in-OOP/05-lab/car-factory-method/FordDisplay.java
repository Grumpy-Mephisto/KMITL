public class FordDisplay extends AutomobileDisplay {

    @Override
    public Automobile create() {
        return new Ford();
    }
    
}
