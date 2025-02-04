public class App {
	public static void main(String[] args) {
		CSVParser realEstate = new RealEstateMarketDataParser();
		CSVParser machineLearning = new MachineLearningDataParser();

		parse(realEstate);
		parse(machineLearning);
	}

	public static void parse(CSVParser parser) {
		parser.parseCSV();
	}
}
