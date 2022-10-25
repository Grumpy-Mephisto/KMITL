// java .\Lab4Q365437.java 2 3 4 5 20 22 123

public class Lab4Q365437 {
    public static void main(String[] args) {
        int amountCharge = 0;
        int hrsPark = 0;
        for(int i = 0; i < args.length; i++){
            hrsPark = Integer.parseInt(args[i]);

            if(hrsPark <= 2) {
                amountCharge += 4;
            } else if(hrsPark <= 4) {
                amountCharge += 3 + 4;
            } else {
                if(hrsPark < 24) {
                    amountCharge += ((hrsPark - 4) + 7);
                } else {
                    float day = hrsPark / 24;
                    if(hrsPark % 24 == 0) {
                        amountCharge += 24 * day;
                    } else {
                        day++;
                        amountCharge += 24 * day;
                    }
                }
            }

            // System.out.println(hrsPark);
            System.out.println(amountCharge);
            amountCharge = 0;
        }
    }
}

