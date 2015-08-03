package dynamicprogramming;

public class UniquePath {
    public int uniquePaths(int m, int n) {
        return uniquePaths(1, 1, m, n);
    }
    
    private int uniquePaths(int i, int j, int m, int n)
    {
        if(i == m && j == n)
            return 1;
        int down = 0, right = 0;
        if(i < m)
            down = uniquePaths(i + 1, j, m, n);
        if(j < n)
            right = uniquePaths(i, j + 1, m, n);
        return down + right;
    }
}
