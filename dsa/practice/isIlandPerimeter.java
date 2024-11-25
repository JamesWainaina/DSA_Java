

class isIlandperimeter{
     public static int islandPerimeter(int[][] grid) {
         int row = grid.length;
         int col = grid[0].length;
         int perimeter = 0;


        for (int i = 0; i < row; i++){
            for (int j = 0; j < cols; j++){
                if (grid[i][j] == 1){
                    // check the top neighbour
                    if (i == 0 || grid[i - 1][j] == 0){
                        perimeter++;
                    }
                    //check bottom
                    if (i = rows -1 || grid[i+ 1][j] == 0){
                        perimeter++;
                    }
                    //check the left neighbor
                    if (j == 0 || grid[i][j -1] == 0){
                        perimeter++;
                    }
                    // check the right neighbor
                    if (j = cols-1 || grid[i][j+1] == 0)P
                        perimeter++;
                }
            }
        }
        return perimeter;
     }
}
