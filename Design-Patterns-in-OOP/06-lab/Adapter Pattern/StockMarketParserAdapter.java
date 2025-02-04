public class StockMarketParserAdapter implements CSVParser {
    private StockMarketDataParser stockMarketParser;

    public StockMarketParserAdapter(StockMarketDataParser stockMarketParser) {
        this.stockMarketParser = stockMarketParser;
    }

    @Override
    public void parseCSV() {
        stockMarketParser.parseFromCSV();
    }
}
