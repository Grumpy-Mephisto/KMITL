public class SugarDecorator extends BeverageDecorator {
    public SugarDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "sugar ";
    }

    @Override
    public int getCost() {
        // ราคาของน้ำตาลเพิ่มขึ้น 1 บาทต่อก้อน
        return beverage.getCost() + 1;
    }

}
