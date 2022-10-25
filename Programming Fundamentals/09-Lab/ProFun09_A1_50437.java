import java.util.*;

public class ProFun09_A1_50437 {
    public static void main(String[] args) {
        int[] data = { 0, 1, 0, 1, 1, 0, 0, 0, 1};
        shake(data);
        System.out.println(Arrays.toString(data));
    }

    static int[] shake(int[] data) {
        int storeValue = 0;
        int changeValue = 1;

        while(changeValue > 0) {
            changeValue = 0;
            for (int i = 0; i < data.length - 1; i++) {
                if (data[i] > data[i+1]) {
                  storeValue = data[i];
                  data[i] = data[i+1];
                  data[i+1] = storeValue;
                  changeValue++;
                }
            }
        }

        return data;
    }
}
