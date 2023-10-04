public class SillyLuckyNumber {
    private String breed;
    private int luckyNumber;
    private int threeDigit; // 0 to 999

    public SillyLuckyNumber(String str) {
        breed = str;
        // str.chars().forEach(c -> luckyNumber += c);
        for (int i = 0; i < str.length(); i++) {
            luckyNumber += str.charAt(i);
        }
        threeDigit = luckyNumber % 1000;
    }

    public int getLuckyNumber() {
        return luckyNumber;
    }

    public void setBreed(String str) {
        breed = str;
        luckyNumber = 0;
        for (int i = 0; i < str.length(); i++) {
            luckyNumber += str.charAt(i);
        }
        threeDigit = luckyNumber % 1000;
    }

    @Override
    public String toString() {
        return String.format("<< %s %d %d >>", breed, luckyNumber, threeDigit);
    }
}
