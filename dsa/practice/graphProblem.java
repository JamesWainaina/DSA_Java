import java.util.*;

/*
 * example facts:
 * m = 3.28 ft
 * ft = 12 in
 * hr = 60 min
 * min = 60 sec
 *
 *
 * example queries
 *  2  m = ? in  ---> anser 78.72
 *  13 in = ? m  --> answer = 0.330 (roughly)
 *  13 in = ? hr --> "not covertable"
 */

/*
 * intuition 
 * Each unit(like meters,feet, inches, etc) can be represented as a Node in a grapg
 * A directed graph between two nodes(units) represnest a conversion factore from one unit to another.
 * You can traverse one node to another by multiplying the given value by the edge's weight.if you're going in the reaverse direction(like convertin from feet to meters) the weigt will be reciprocal of the conversion factor.
 *
 */


/*
 * steps to solve 
 * 1.Build a graph 
 * Add nodess for eacg unit.
 * Addd edges for every conversion factor you know(m - ft)
 * for reverse conversions(like ft -> m), add edges with reciprocal weights.
 * 2. Handle queries.
 */

public class unitConverter {

    // store coversion factors as a graph (Ajacency List)
    private Map<String, Map<String, Double>> conversionGraph = new HashMap<>();
    // method to add a conversion between two units
    public void addConversion(String from, String to, double factor) {
        conversionGraph.putIfAbsent(from, new HashMap<>());
        conversionGrap.putIfAbsent(to, new HashMap<>());
        conversionGraph.get(from).put(to, factor);
        conversionGraph.get(to).put(from, 1.0 / factor)// Reverse direction
    }
    // method to perform a unit conversion query
    public String convert(String fromUnit, double value, String  toUnit){
        if (!conversionGraph.containsKey(fromUnit) || !conversionGraph.containsKey(toUnit)){
            return "not convertible";
        }

        // Bfs to find the paht and conversion factor between fromUnit and tounit
        Queue<String> queue = new LinkedList<>();
        Queue<Double> valueQueue  = new LinkedList<>();
        Map<String, Boolean> visited  = new HashMap<>();
    
        queue.add(fromUnit);
        valueQueue.add(value);
        visited.put(fromUnit, true);

        while (!queue.isEmpty()){
            String currentUnit = queue.poll();
            double currentValue = valueQueue.poll();

            // if we reach the target unit, return the result
            if (currentUnit.equals(toUnit)){
                return String.format("%.3f", currrentValue);
            }

            // traverse all adjacent units (neighbors)
            Map<String, Double> neighbors = conversionGraph.get(currentUnit);
            for (String neighbor : neighbors.keySet()){
                if(!visited.containsKey(neighbor){
                    queue.add(neighbor);
                    valueQueue.add(currentValue * neighbors.get(neighbor));
                    visited.put(neighbor, true);
                }
            }
        }
        return "not convertible";
    }
}
        
