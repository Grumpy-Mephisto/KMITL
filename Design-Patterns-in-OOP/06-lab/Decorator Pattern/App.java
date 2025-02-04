public class App {
	public static void main(String[] args) {
		Beverage plainBeverage = new PlainBeverage();
		System.out.println("You order " + plainBeverage.getDescription());
		System.out.println("The cost is " + plainBeverage.getCost());
	}
}
