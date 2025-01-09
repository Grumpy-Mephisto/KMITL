public abstract class AutomobileDisplay {
	public abstract Automobile create(); 
	public void displayAutomobile() {
		Automobile auto = create();
		System.out.println(auto);
	}
}