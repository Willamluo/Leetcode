package graphs;

import java.util.*;



public class GraphImplementation 
{
    public void dfs(Node root)
    {       
        //Avoid infinite loops
        if(root == null) return;

        System.out.print(root.getVertex() + "\t");
        root.state = State.Visited;

        //for every child
        for(Node n: root.getChild())
        {
            //if childs state is not visited then recurse
            if(n.state == State.Unvisited)
            {
                dfs(n);
            }
        }
    }
    
    public void dfsIteration(Node root)
    {
    	if(root == null) return;
    	
    	//System.out.print(root.getVertex() + "\t");
    	Stack<Node> stack = new Stack<Node>();
    	stack.push(root);
    	//for every child
    	while(!stack.isEmpty())
    	{
    		Node n = stack.pop();
    		if(n.state == State.Unvisited)
    		{
    			System.out.print(n.getVertex() + "\t");
    			n.state = State.Visited;
    			for(Node c : n.getChild())
    			{
    				stack.push(c);
    			}
    		}
    	}
    }

    public void bfs(Node root)
    {
        //Since queue is a interface
        Queue<Node> queue = new LinkedList<Node>();

        if(root == null) return;

        root.state = State.Visited;
         //Adds to end of queue
        queue.add(root);

        while(!queue.isEmpty())
        {
            //removes from front of queue
            Node r = queue.remove(); 
            System.out.print(r.getVertex() + "\t");

            //Visit child first before grandchild
            for(Node n: r.getChild())
            {
                if(n.state == State.Unvisited)
                {
                    queue.add(n);
                    n.state = State.Visited;
                }
            }
        }


    }

    public static Graph createNewGraph()
    {
        Graph g = new Graph();        
        Node[] temp = new Node[8];

        temp[0] = new Node("A", 3);
        temp[1] = new Node("B", 3);
        temp[2] = new Node("C", 1);
        temp[3] = new Node("D", 1);
        temp[4] = new Node("E", 1);
        temp[5] = new Node("F", 1);

        temp[0].addChildNode(temp[1]);
        temp[0].addChildNode(temp[2]);
        temp[0].addChildNode(temp[3]);

        temp[1].addChildNode(temp[0]);
        temp[1].addChildNode(temp[4]);
        temp[1].addChildNode(temp[5]);

        temp[2].addChildNode(temp[0]);
        temp[3].addChildNode(temp[0]);
        temp[4].addChildNode(temp[1]);
        temp[5].addChildNode(temp[1]);

        for (int i = 0; i < 7; i++) 
        {
            g.addNode(temp[i]);
        }
        return g;
    }


}
