public class AppWithSRP {
    public static void main(String[] args) {
        System.out.println("Welcome to Application");

        // get a pair of values
        PairOfInput pair = PairOfInputProcessor.read();

        // IMathOperation operation = new Addition();
        IMathOperation operation = new Subtraction();
        MathOperation mathOperation = new MathOperation(operation);

        // Check whether the inputs are valid
        if (PairOfInputProcessor.isValid(pair)) {
            int firstInt, secondInt;
            firstInt = Integer.parseInt(pair.getFirst());
            secondInt = Integer.parseInt(pair.getSecond());

            // do the methematical operation
            int result = mathOperation.execute(firstInt, secondInt);
            System.out.println("The result is: " + result);
        } else {
            System.out.println("Invalid number");
        }

        System.out.println("End of the application");
    }
}
