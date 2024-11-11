


class shortestCommonSuperSequence {
	 public String shortestCommonSupersequence(String str1, String str2) {
		String lcs = longestCommonSequence(str1, str2);
		
		// use the LCS to construct the shortest common superSequence
		StringBuilder scs = new StringBuilder();
		int i = 0, j = 0;
		// traverse through str1 and str2 to build the scs
		for(char c: lcs.toCharArray()) {
			// add the character for str1 that are before the lcs
			while (i < str1.length() && str1.charAt(i) != c) {
				scs.append(str1.charAt(i));
				i++;
			}
			// add the character for str2 that are before the lcs
			while (j < str2.length() && str2.charAt(j) != c ) {
				scs.append(str2.charAt(j));
				j++;
			}
			// add lcs character
			scs.append(c);
			i++;
			j++;
		}
		// add the remaining characters from str1 and str2
		scs.append(str1.charAt(i));
		scs.append(str2.charAt(j));
		return scs.toString();
	}
	public String longestCommonSequence(String str1, String str2){
		int m = str1.length();
		int n = str2.length();
		int[][] dp = new int[m+1][n+1];
		
		for (int i = 1; i <= m; i++){
			for (int j = 1; j <= n; j++) {
				if (str1.charAt(i -1) == str2.charAt(j-1)) {
					dp[i][j] = 1 + dp[i -1][j-1];
				} else {
					dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
		// reconstruct the LCS using backtracking 
		StringBuilder lcs = new StringBuilder();
		int i = m , j = n;
		while (i > 0 && j > 0 ){
			if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
				lcs.append(str1.charAt(i -1));
				i--;
				j--;
			} else if (dp[i - 1][j] > dp[i][j - 1]) {
				i--;
			} else {
				j--;
			}
		}
		return lcs.reverse().toString();
	}
	
	public static void main(String[] args) {
		shortestCommonSuperSequence solution = new shortestCommonSuperSequence();
		String str1 = "abac";
		String str2 = "cab";
		System.out.println(solution.shortestCommonSupersequence(str1, str2));
	}
}
