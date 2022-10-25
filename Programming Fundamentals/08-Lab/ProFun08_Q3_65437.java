import java.util.*;

class ProFun08_Q3_65437 {
    static void topK(int[] arr) {
        Scanner input = new Scanner(System.in);
        System.out.println("If you want to exit, enter 0 or press Ctrl+C");
        int arrLength = arr.length;
        
        while(true) {
            System.out.print("Enter value: ");
            int value = input.nextInt();
            
            // Terminate the program if value is 0
            if(value <= 0) {
                System.out.println("Terminate");
                break;
            }
            
            int[] emptyArr = new int[arrLength + 1];

            for (int i = 0; i < arrLength; i++){
                emptyArr[i] = arr[i];
            }

            emptyArr[arrLength] = value;
            
            int[] arrDesc = Arrays.stream(emptyArr).boxed()
                    .sorted(Collections.reverseOrder())
                    .mapToInt(Integer::intValue)
                    .toArray();

            for (int i = 0; i < arrLength; i++) {
                arr[i] = arrDesc[i];
                System.out.println(Arrays.toString(arr));
                System.out.println("");
            }
        }
        input.close();
    }

    public static void main(String[] args) {
        int[] arrays = new int[10];
        topK(arrays);
    }
}
