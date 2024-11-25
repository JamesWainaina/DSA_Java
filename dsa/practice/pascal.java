import java.util.*;

class pascal {
    public static List<List<Integer>>generatePascalTriangle(int n){
        List<List<Integer> triangle = new ArrayList<>();

        if (n <= 0){
            return triangle;
        }

        // loop through to generate each row of the pascals triangle
        for (int rowNum = 0; rowNum < n; rowNum++){
            List<Integer>row = new ArrayList<>();

            // each rw starts with 1
            row.add(1);

            // populate the middle values of the row
            if (rowNum > 0){
                List<Integer> prevRow = triangle.get(rowNum - 1);
                for (int j = 1; j < rowNum; j++){
                    // each element is the sum of the two elements above it
                    int value = prevRow.get(j - 1) + prevRow.get(j);
                    row.add(value);
                }
                // end each row with 1
                row.add(1);
            }
            // add the row to the triangle
            triangle.add(row);
        }
        return triangle;
    }
}
