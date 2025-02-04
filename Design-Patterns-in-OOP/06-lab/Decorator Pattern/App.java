public class App {
	public static void main(String[] args) {
		Beverage plainBeverage = new PlainBeverage();
		System.out.println("You order " + plainBeverage.getDescription());
		System.out.println("The cost is " + plainBeverage.getCost());

		System.out.println();

		Beverage specialBeverage = new PlainBeverage();
		specialBeverage = new MilkDecorator(specialBeverage); // เพิ่มนม
		specialBeverage = new SugarDecorator(specialBeverage); // เพิ่มน้ำตาล 1 ก้อน
		specialBeverage = new SugarDecorator(specialBeverage); // เพิ่มน้ำตาล 1 ก้อน
		System.out.println("You order " + specialBeverage.getDescription());
		System.out.println("The cost is " + specialBeverage.getCost());
	}
}
