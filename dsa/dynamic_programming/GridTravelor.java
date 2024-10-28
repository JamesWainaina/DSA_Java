import java.util.HashMap;

public class GridTravelor {
	private HashMap<String, Long> memo = new HashMap<>();
	public long gridTravelor(int m, int n) {
		String key = m + "," + n;
		
		if (memo.containsKey(key)) {
			return memo.get(key);
		}
		
		if (m == 1 && n == 1) {
			return 1;
		}
		
		if (m == 0 || n == 0){
			return 0;
		}
		long ways = gridTravelor(m-1,n) + gridTravelor(m, n-1);
		memo.put(key, ways);
		return ways;
	}
	public static void main(String[] args) {
		GridTravelor travelor = new GridTravelor();
		System.out.println(travelor.gridTravelor(1,1));
		System.out.println(travelor.gridTravelor(14,14));
	}
}	
