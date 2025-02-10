package dsa.HashMap;

import java.util.HashMap;
import java.util.Map;

public class TraversrTheHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("vishal", 10);
        map.put("Sachin", 30);
        map.put("vaibhar", 20);

        for(Map.Entry<String , Integer> e : map.entrySet()){
            System.out.println("Key:" + e.getKey() + " value:" + e.getValue());
        }
    }
}
