import java.util.ArrayList;

public class WordDictionary {
     private TrieNode root = new TrieNode();
     
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode r = root;
        ArrayList<TrieNode> children = null;
        for(int i = 0; i < word.length(); i++)
        {
            char val = word.charAt(i);
            children = r.getChildren();
            int j = 0;
            for(; j < children.size(); j++)
            {
                TrieNode node = children.get(j);
                if(val == node.val)
                {
                    r = node;
                    break;
                }
            }
            if(j >= children.size())
            {
                TrieNode node = new TrieNode();
                node.val = val;
                r.addChild(node);
                r = node;
            }
            if(i == word.length() - 1)
                r.isLeaf = true;
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        TrieNode r = root;
        return match(r, word, -1);
    }
    
    private boolean match(TrieNode r, String word, int i)
    {
        if(i >= word.length() || r != root && r.val != word.charAt(i) && word.charAt(i) != '.')
            return false;
        ArrayList<TrieNode> children = r.getChildren();
        boolean res = (i == word.length() - 1) && r.isLeaf;
        for(int j = 0; j < children.size(); j++)
        {
            res = res || match(children.get(j), word, i + 1);
        }
        return res;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");