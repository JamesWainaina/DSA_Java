/*
 * input: jumps = [4, 3, 4, 2, 3, 1, 2 ,1]
 * Output : 2
 *
 * Explanation : index 0 -> index 4 -> index 7
 *
 * Alternatives 3 -hop path (valid but longer);
 * index 0-> index 1 -> index 4 -> index7
 *
 *
 * return ,min heaps to get from index 0 to index len(arr) -1
 */

class min_jumps {
     static class Node {
         int index;
         int jumps;

         public Node(int index, int jumps){
             this.index = index;
             this.jumps = jumps;
         }

     }

     public static int minJumps(int[] jumps){
         int n = jumps.length;
         if (n <= 1) return 0;

         // Min heap to store the nodes (index , jumps where jumps is the number of hops to reach the index
         PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.jumps - b.jumps);
         // add the starting index with 0 jumps
         minHeap.offer(new Node(0, 0);

         // boolean array to keep track of visited indeces
         boolean[] visited  = new boolean[n];
         visited[0] = true;

         while(!minHeap.isEmpty()){
             Node currentNode = minHeap.poll();
             int currentIndex = currentNode.index;
             int currentJumps = currentNode.jumps;

             // expore all the possible jumps from the current index
             int maxJump = jumps[currentIndex];


             for (int nextIndex = currentIndex + 1; nextIndex <= currentIndex + maxJump && nextIndex < n; nextIndex++) {
                    if (nextIndex == n -1) {
                        return currentJumps + 1;
                    }

                    if (!visited[nextIndex]) {
                        visited[nextIndex] = true;
                        minHeap.offer(new Node(nextIndex, currentJumps + 1));
                    }
             }
         }
         return -1;
     }
}
