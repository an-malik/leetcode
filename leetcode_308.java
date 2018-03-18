// Leetcode_308
// Range Sum Query 2D - Mutable

class NumMatrix {

    int[][] bit;
    int[][] vals;
    int m, n;
    
    public NumMatrix(int[][] matrix) {
        
        m = matrix.length;
        if (m == 0) return;
        
        n = matrix[0].length;
        if (n == 0) return;
        
        vals = new int[m][n];
        bit = new int[m+1][n+1];
        
        // add values using update
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                update(i, j, matrix[i][j]);
            }
        }
    }
    
    public void update(int row, int col, int val) {
        if(m == 0 || n == 0) return;
        
        // get delta change in value
        int delta = val - vals[row][col];
        
        // update value - might be skipped?
        vals[row][col] = val;
        
        // update BIT tree values with delta starting at row + 1, col + 1
        for(int r = row + 1; r <= m; r += r & (-r)){
            for(int c = col + 1; c <= n; c += c & (-c)){
                bit[r][c] += delta;
            }
        }
    }
    
    private int sum(int row, int col) {
        int sum = 0;
        
        // same as update to get cummulative sum
        for(int r = row; r > 0; r -= r & (-r)){
            for(int c = col; c > 0; c -= c & (-c)){
                sum += bit[r][c];
            }
        }
        return sum;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(m == 0 || n == 0) return 0;
        return sum(row2+1, col2+1) + sum(row1, col1) - sum(row1, col2+1) - sum(row2+1, col1);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */