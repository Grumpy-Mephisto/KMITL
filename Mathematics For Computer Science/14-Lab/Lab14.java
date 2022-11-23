class Lab14 {
    
    class MyFixedPoint {
        public int data;
        
        float getReal() {
            return data;
        }
        
        void adds(MyFixedPoint b) {
            // your code here
            data = data + b.data;
        }

        void subtracts(MyFixedPoint b) {
            // your code here
            data = data - b.data;
        }
        void multiplies(MyFixedPoint b) {
            // your code here
            data = data * b.data;
        }
        void divides(MyFixedPoint b) {
            // your code here
            data = data / b.data;
        }
    }

    class MyFloatingPoint {
        public float data;

        float getReal() {
            return data;
        }
        
        void adds(MyFloatingPoint b) {
            data = data + b.data;
        }
        
        void subtracts(MyFloatingPoint b) {
            data = data - b.data;
        }
        
        void multiplies(MyFloatingPoint b) {
            data = data * b.data;
        }
        
        void divides(MyFloatingPoint b) {
        data = data / b.data;
        }
    }

    public static void main(String[] args) {
        Lab14 Lab14 = new Lab14();
        long start, end, result_fix, result_float;
        
        // Test Fixed Point Speed
        Lab14.MyFixedPoint Fixed = Lab14.new MyFixedPoint();
        Lab14.MyFixedPoint Fixed2 = Lab14.new MyFixedPoint();
        Fixed.data = 1000;
        Fixed2.data = 1;
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            Fixed.adds(Fixed2);
            Fixed.subtracts(Fixed2);
            Fixed.multiplies(Fixed2);
            Fixed.divides(Fixed2);
        }
        end = System.currentTimeMillis();
        result_fix = end - start;
        System.out.println("MyFixedPoint Value: " + Fixed.getReal());
        System.out.println("MyFixedPoint Time: " + result_fix + "ms");

        // Test Floating Point Speed
        Lab14.MyFloatingPoint Float = Lab14.new MyFloatingPoint();
        Lab14.MyFloatingPoint Float2 = Lab14.new MyFloatingPoint();
        Float.data = 1000;
        Float2.data = 1;
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            Float.adds(Float2);
            Float.subtracts(Float2);
            Float.multiplies(Float2);
            Float.divides(Float2);
        }
        end = System.currentTimeMillis();
        result_float = end - start;
        System.out.println("MyFloatingPoint Value: " + Float.getReal());
        System.out.println("MyFloatingPoint Time: " + result_float + "ms");

        if(result_fix < result_float) {
            System.out.println("\nConclusion: Fixed Point is faster than Floating Point");
        } else {
            System.out.println("\nConclusion: Floating Point is faster than Fixed Point");
        }
    }
}