package dynamicprogramming;

public class RegularExpression {
    public boolean isMatch(String s, String p) {
        int m = p.length() + 1;
        int n = s.length() + 1;
        boolean[][] dp = new boolean[m][n];
        

            dp[0][0] = true;
        
        for(int j = 1; j < m; j++)
        {
            if(p.charAt(j - 1) == '*')
                dp[j][0] = dp[j - 1][0];
        }
        for(int i = 1; i < m; i++)
        {
            for(int j = 1; j < n; j++)
            {
                char pat = p.charAt(i - 1);
                char c = s.charAt(j - 1);
                if(pat == c || pat == '?')
                    dp[i][j] = dp[i - 1][j - 1];
                else if(pat == '*')
                    dp[i][j] = dp[i - 1][j - 1] | dp[i][j - 1];
                System.out.printf("i %d j %d %b", i, j, dp[i][j]);
            }
        }
        return dp[m - 1][n - 1];
    }
}
