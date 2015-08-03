import java.util.ArrayList;

class TrieNode {
    // Initialize your data structure here.
    ArrayList<TrieNode> children;
    char val;
    boolean isLeaf;
    public TrieNode() {
        children = new ArrayList<TrieNode>();
        val = ' ';
    }
    public ArrayList<TrieNode> getChildren()
    {
        return children;
    }
    public void addChild(TrieNode c)
    {
        children.add(c);
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
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

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode r = root;
        ArrayList<TrieNode> children = null;
        int i = 0;
        for(; i < word.length(); i++)
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
                return false;
        }
        //if it is leaves node
        return r.isLeaf;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode r = root;
        ArrayList<TrieNode> children = null;
        for(int i = 0; i < prefix.length(); i++)
        {
            char val = prefix.charAt(i);
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
                return false;
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");