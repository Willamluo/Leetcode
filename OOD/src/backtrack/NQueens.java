package backtrack;
import java.util.*;

public class NQueens {
	public List<List<String>> solveNQueens(int n) {
        List<List<String>> solution = new ArrayList<List<String>>();
        if(n == 1)
        {
            List<String> list = new ArrayList<String>();
            list.add("Q");
            solution.add(list);
            return solution;
        }
        if(n < 4)
            return solution;
            
        boolean[][] queens = new boolean[n][n];
        
        for(int i = 0; i < n; i++)
        {
            List<String> list = new ArrayList<String>();
            System.out.println("i: " + i);
            solveNQueens(queens, 0, i, solution);
            
        }
        return solution;
            
    }
    
    private void solveNQueens(boolean[][] queens, int i, int j, List<List<String>> solution)
    {
        if(j < 0 || j > queens[0].length - 1)
            return;
        if(!validPosition(queens, i, j))
            return;
        queens[i][j] = true;
        if(i == queens.length - 1)
        {
        	System.out.println("i:" + i + " j:" + j);
        	generateSolution(queens, solution);
        }


        for(int k = j + 2; k < queens[0].length; k++)
            solveNQueens(queens, i + 1, k, solution);
            
        for(int k = j - 2; k >= 0 ; k--)
            solveNQueens(queens, i + 1, k, solution);
            
        queens[i][j] = false;
        
    }
    
    private boolean validPosition(boolean[][] queens, int i, int j)
    {
        for(int k = i - 1; k >= 0; k--)
        {
                if(queens[k][j])
                {
                	return false;
                }
            
        }
        int x = i - 1, y = j - 1;
        while(x >= 0 && y >= 0)
        {
        	if(queens[x][y])
        		return false;
        	x--;
        	y--;
        }
        x= i - 1; y = j + 1;
        while(x >= 0 && y < queens.length)
        {
        	if(queens[x][y])
        		return false;
        	x--;
        	y++;
        }
        return true;
    }
    private void generateSolution(boolean[][] queens, List<List<String>> solution)
    {
    	List<String> list = new ArrayList<String>();
    	for(int i = 0; i < queens.length; i++)
    	{
    		String s = "";
    		for(int j = 0; j < queens[0].length; j++)
    		{
    			if(queens[i][j])
    				s += "Q";
    			else
    				s += ".";
    		}
    		list.add(s);
    		//System.out.println(s);
    	}
    	solution.add(list);
    	//System.out.println("---------");
    }
}
