class Lab5Q4_265437 {
    public static void main(String[] args) {
        String s1 = "I am happy";
        String s2 = "xyz";
        String str1 = s1.toLowerCase();
        String result;
        int i, vowel = 0; 
        

        for(i = 0; i < s1.length(); i++) {
            if(
                str1.charAt(i) == 'a' || 
                str1.charAt(i) == 'e' || 
                str1.charAt(i) == 'i' || 
                str1.charAt(i) == 'o' || 
                str1.charAt(i) == 'u')  {
                vowel = 0;
                break;
            } else {
                vowel = -1;
            }
        }
        result = (vowel == 0) ? "have a vowel" : "no vowel";
        System.out.printf("%s is %d (%s)%n", s1, vowel, result);

        for(i = 0; i < s2.length(); i++) {
            if (
                s2.charAt(i) == 'a' || 
                s2.charAt(i) == 'e' || 
                s2.charAt(i) == 'i' || 
                s2.charAt(i) == 'o' || 
                s2.charAt(i) == 'u')  {
                vowel = 0;
                break;
            } else {
                vowel = -1;
            }
        }
        result = (vowel == 0) ? "have a vowel" : "no vowel";
        System.out.printf("%s is %d (%s)", s2, vowel, result);
    }
}
