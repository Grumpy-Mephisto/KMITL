public class AppWithSRP {
    public static void main(String[] args) {
        System.out.println("Welcome to Application");

        // get a pair of values
        PairOfInput pair = PairOfInputProcessor.read();

        // Check whether the inputs are valid
        if (PairOfInputProcessor.isValid(pair)) {
            int firstInt, secondInt;
            firstInt = Integer.parseInt(pair.getFirst());
            secondInt = Integer.parseInt(pair.getSecond());

            // do the methematical operation
            int result = MathOperation.add(firstInt, secondInt);
            System.out.println("The result is: " + result);
        } else {
            System.out.println("Invalid number");
        }

        System.out.println("End of the application");
    }
}
