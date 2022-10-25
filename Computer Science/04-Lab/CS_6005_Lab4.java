public class CS_6005_Lab4 {
       public static void main(String[] args) {
        // int [] arr = { 1, 2, 1, 4, 2, 5, 2, 7 };            /*10*/ 
        int [] arr = { 1, 1, 2, 2, 2, 4, 5, 7 };            /*10*/ 
        int k = 0;
        int m = 0;     
        int ans = 0;
        int secret = 0;
        int maxCnt = 0;                                     /*20*/
        int arrSize = arr.length; // arrSize is 8           /*30*/
        for (int i = 0; i < arrSize; i++) {                 /*40*/
            int cnt = 0;                                    /*50*/ 
            for (int j = 0; j < arrSize; j++) {             /*60*/ 
                if (arr[i] == arr[j]) {                     /*70*/  
                    cnt++;                                  /*80*/  
                    k++; /* A */                           /*90*/  
                } // if                                     /*100*/
            } // j                                          /*110*/ 
            if (cnt > maxCnt) {                             /*120*/   
                maxCnt = cnt;                               /*130*/ 
                ans = arr[i];                               /*140*/ 
                secret = i; /* B */                         /*150*/  
                m++; /* C */                                /*160*/  
            } // if                                         /*170*/
        }                                                   /*180*/
        System.out.println(ans + " " + maxCnt);             /*190*/
        secret += k + m;                                    /*200*/
        System.out.println(secret);                         /*210*/
    }
}