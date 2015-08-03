package backtrack;
import java.util.*;

class Vetex{
    String word;
    boolean visited;
    List<Vetex> adj;
    public Vetex(String word)
    {
        this.word = word;
        adj = new ArrayList<Vetex>();
    }
}
public class WordLadder {
	 public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
		 if(beginWord == null || endWord == null || wordDict == null || endWord.length() != beginWord.length())
	            return 0;
	        LinkedList<String> queue = new LinkedList<String>();
	        queue.addFirst(beginWord);
	        int curNum = 1, nextNum = 0;
	        int level = 1;
	        while(!queue.isEmpty())
	        {
	            String word = queue.removeFirst();
	            wordDict.remove(word);
	            curNum--;
	            
	            for(int i = 0; i < word.length(); i++)
	            {
	                char[] s = word.toCharArray();
	                for(char j = 'a'; j <= 'z'; j++)
	                {
	                    s[i] = j;
	                    String temp = new String(s);
	                    if(temp.equals(endWord))
	                    {
	                        return level + 1;
	                    }
	                    if(wordDict.contains(temp))
	                    {
	                        queue.addLast(temp);
	                        nextNum++;
	                    }
	                }
	            }
	            if(curNum <= 0)
	            {
	                curNum = nextNum;
	                nextNum = 0;
	                level++;
	            }
	        }
	        return 0;
	    }
}
