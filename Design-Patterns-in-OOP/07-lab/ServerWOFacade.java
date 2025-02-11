public class ServerWOFacade {
	public static void main(String[] args) {
		ScheduleServer scheduleServer = new ScheduleServer();
		ServerFacade facade = new ServerFacade(scheduleServer);

		// Start the server
		facade.startServer();

		System.out.println("Start working......");
		System.out.println("After work done.........");

		// Stop the server
		facade.stopServer();
	}

}
