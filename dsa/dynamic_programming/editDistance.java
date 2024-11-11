
public class editDistance {
	public static int editDistRec(String s1, String s2, int m, int n) {
		// if the first string is empty the only options is to insert all characters of second string into first
		if(m == 0) return n;
		// viceversa
		if (n == 0) return m;
		
		// if the last characters of two string are the same, nothing much to do. Get the count for remaining strings
		if (s1.charAt(m -1) == s2.charAt(n -1)) {
			return editDistRec(s1, s2, m-1, n-1);
		}
		

		// if the last characters are not same, consider all three operations on last character of first string,recursively compute mimimum cost for all  three operations and take minimum of thress values.
		return 1 + Math.min(Math.min(editDistRec(s1,s2, m, n-1),//insert
				editDistRec(s1, s2, m -1, n)),// Remove
				editDistRec(s1, s2, m -1, n -1)); // replace
		}
		public static int editDist(String s1, String s2) {
			return editDistRec(s1, s2, s1.length(), s2.length());
		}
		public static void main(String[] args) {
			String s1 = "GEEXSFRGEEKKS";
			String s2 = "GEEKSFORGEEKS";
			System.out.println(editDist(s1, s2));
		}
	}
