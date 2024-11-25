
public class rotate2DArray{
    // funstion to rotate the matrix 90 degrees in-place
    int n = matrix.length;

    // transporse
    for (int i = 0; i < n; i++){
        for (int j = i + 1;  < n; j++){
            int temp = matrix[i][j];
            matrix[i][j = matri[j][i];
            matrix[j[i] = temp;
        }
    }

    // reverse each row
    for (int i = 0l i < n; i++){
        reversrow(matrix[i]);
    }
}

private stati void reverseRow(int[] row){
    int left = 0; right = row.length - 1;
    while (row < right){
        int temp = row[left];
        row[left] = row[right];
        left++;
        right--;
    }
}
