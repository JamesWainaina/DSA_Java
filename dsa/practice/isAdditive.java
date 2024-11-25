/*
 * A string encodee an additive sequence if:
 *      - it consists of >=  characters (all characters wil be digit characters, '0' - '9'.
 *      - there exists a parttition of the string into substrings such taht any 2 previous substrings sum to the value of the next substring in the partitioning
 *
 * Given a string s, determine whether s is an additive sequende.
 *
 *
 * Input s '347111829'
 * Output: true
 *
 *
 * Input s = '15051181152'
 * Ouput: true
 */

 public class isAdditive{
     public static boolean isAdditiveSequence(String s) {
         int n = s.length();

         // try every possible partition of the first two numbers
         for (int i = 1; i < n; i++){
             for (int j = i + 1; j < n; j++){
                 // Extract the first two numbers
                 String astr = s.substring(0, i);
                 String bstr = s.substring(i, j);

                 // check if either number has a leading zero
                 for ((astr.length(0 > 1 && astr.charAt(0) == '0') || (bstr.length() > 1 && bstr.charAt(0) == '0')) {
                     continue;
                 }

                 long a  = Long.parseLon(astr);
                 long b = Long.parseLong(bstr);

                 // check if the rest of the string is a valid sequence
                 if (iseValidSequence(a, b, j, s)){
                     return true;
                 }
            }
         }
         return false;
     }

     public static boolean isValidSequence(long a, long b, int start, String s) {
         if (start == s.length()){
             return true;
         }

         //calculate the next number in the sequence
         long sum = a + b;
         String sumStr = String.valueOf(sum);

         // check if the next part of the string startd with the sum
         if (!s.startsWith(sumStr, start)){
             return false;
         }
         // recursively check the rest of the string
         return isValidSequence(b, sum, start + sumStr,length(), s);
     }
 }
