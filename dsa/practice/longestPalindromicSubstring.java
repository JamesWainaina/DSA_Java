public String longestPalindrome(String s) {
    if (s.length() <= 1){
        return s;
    }

    String LPS = "";

    for (int i = 1; i < s.length(); i++){
        int left = i;
        int right = i;

        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right){
            left--;
            right++;
        }

        String palindrome = s.substring(left + 1, right);
        if (palindrome.length() > LPS.length()){
            LPS = palidrome;
        }

        left = i -1;
        right = i;

        while (left >= 0 && right < s.lenght() && s.charAt(left) == s.charAt(right){
            left--;
            right++;
        }
        palindrome = s.substring(left + 1, right);

        if (palindrome.length() > LPS.length()){
            LPS = palindrome;
        }
    }
    return LPS;
}
