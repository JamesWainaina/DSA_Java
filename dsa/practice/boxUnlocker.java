

import java.util.*;

public class BoxUnlocker {
    // method to determine if all boxes can be opened
    public static boolean canUnlockAll(List<List<Integer>> boxes) {
        // number of boxes
        int n = boxes.size();

        // A set to keep track of the boxes we have opened
        Set<Integer> openedBoxes = new HashSet<>();

        // a queue to keep track of the boxes to explore ( Bfs approach)
        Queue<Interger> queue = new LinkedList<>();

        // start by unlocking the first box(box 0)
        openedBoxes.add(0);
        queue.add(0);

        // perform BFS
        while (!queue.isEmpty()){
            int currentBox = queue.poll();

            // for each key in the current box, try to open the corresponding box
            for (int key : boxes.get(currentBox){
                if (key  < n && !openedBoxes.contains(key)) {
                    // if we havent opened this box and the key is valid, open it
                    openedBoxes.add(key);
                    queue.add(key);
                }
            }
        }
        // After the traversal check if all the boxes have been traversed
        return openedBoxes.size() == n;
    }
}
