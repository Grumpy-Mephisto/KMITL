public class MilkDecorator extends BeverageDecorator {
    public MilkDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "milk ";
    }

    @Override
    public int getCost() {
        // ราคาของนมเพิ่มขึ้น 8 บาทต่อช้อน
        return beverage.getCost() + 8;
    }
}
