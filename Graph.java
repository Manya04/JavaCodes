import java.util.*; 

class BFS { 
	public BFS(){
		int V = 7;
		ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer>>(V); 
		
		for (int i = 0; i < V; i++) 
			adj.add(new ArrayList<Integer>()); 
				addEdge(adj,0,1); 
	        	addEdge(adj,0,2); 
	        	addEdge(adj,2,3); 
	        	addEdge(adj,1,3); 
	        	addEdge(adj,1,4);
	        	addEdge(adj,3,4);
		System.out.println("Following is Breath First Traversal: "); 
		BFS(adj,V,0);
	}

	static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) 
	{ 
		adj.get(u).add(v); 
		adj.get(v).add(u); 
	} 

	static void BFS(ArrayList<ArrayList<Integer>> adj,int V,int s) 
	{ 
		boolean[] visited=new boolean[V]; 
    	for(int i = 0; i < V; i++) 
    		visited[i] = false; 
    
    	Queue<Integer> q=new LinkedList<>();
    	
    	visited[s] = true; 
    	q.add(s); 
    
    	while(q.isEmpty()==false) 
    	{ 
    		int u = q.poll(); 
    		System.out.print(u + " "); 
    		 
    		for(int v:adj.get(u)){
    		    if(visited[v]==false){
    		        visited[v]=true;
    		        q.add(v);
    		    }
    		} 
    	} 
	} 	
} 

class DFS { 
	public DFS() {
			int V = 7; 
			ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer>>(V); 
			for (int i = 0; i < V; i++) 
				adj.add(new ArrayList<Integer>()); 
				addEdge(adj,0,1); 
	        	addEdge(adj,0,2); 
	        	addEdge(adj,2,3); 
	        	addEdge(adj,1,3); 
	        	addEdge(adj,1,4);
	        	addEdge(adj,3,4);
	    		System.out.println("Following is Depth First Traversal: "); 
	    	    DFS(adj,V,0);
	        	
	}
	static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) 
	{ 
		adj.get(u).add(v); 
		adj.get(v).add(u); 
	} 

	static void DFSRec(ArrayList<ArrayList<Integer>> adj,int s, boolean[] visited) 
	{ 
    	visited[s]=true;
        System.out.print(s +" ");
        
        for(int u:adj.get(s)){
            if(visited[u]==false)
                DFSRec(adj,u,visited);
        } 
	} 
	
	static void DFS(ArrayList<ArrayList<Integer>> adj, int V, int s){
	    boolean[] visited=new boolean[V]; 
    	for(int i = 0; i<V; i++) 
    		visited[i] = false;
    		
        DFSRec(adj,s,visited);
	}
} 


class Graph
{
	private int V; 
	private LinkedList<Integer> adj[];
	
	@SuppressWarnings("unchecked")
	Graph(int v)
	{
		V = v;
		adj = new LinkedList[V];
		for (int i=0; i<v; ++i)
			adj[i] = new LinkedList<Integer>();
	}

	void addEdge(int v,int w)
	{
		adj[v].add(w);
		adj[w].add(v);
	}


	boolean isCyclicUtil(int v, boolean visited[], int parent)
	{
	
		visited[v] = true;
		Integer i;

		Iterator<Integer> it = adj[v].iterator();
		while (it.hasNext())
		{
			i = it.next();

			if (!visited[i])
			{
				if (isCyclicUtil(i, visited, v))
					return true;
			}

			else if (i != parent)
			return true;
		}
		return false;
	}

	boolean isTree()
	{
	
		boolean visited[] = new boolean[V];
		for (int i = 0; i < V; i++)
			visited[i] = false;

		
		if (isCyclicUtil(0, visited, -1))
			return false;

		
		for (int u = 0; u < V; u++)
			if (!visited[u])
				return false;

		return true;
	}

	
}
 class Node{  
        int data;  
        Node left;  
        Node right;  
  
        //Assign data to the new node, set left and right children to null  
        public Node(int data){  
          this.data = data;  
          this.left = null;  
          this.right = null;  
        }  
      }  
      
class IdenticalTrees {  
  
      //Represent the node of the binary tree  
      
  
      //Represent the root of the binary tree  
      public Node root;  
  
      public IdenticalTrees(){  
        root = null;  
      }  
  
      //areIdenticalTrees() finds whether two trees are identical or not  
      public static boolean areIdenticalTrees(Node root1, Node root2) {  
  
          //Checks if both the trees are empty  
          if(root1 == null && root2 == null)  
              return true;  
  
          //If both trees are not empty, check whether the data of the nodes is equal  
          //Repeat the steps for left subtree and right subtree  
          if(root1 != null  && root2 != null)
              return ((root1.data == root2.data) &&  
                      (areIdenticalTrees(root1.left, root2.left)) &&  
                      (areIdenticalTrees(root1.right, root2.right)));  
 
          return false;  
      }  
}


public class IsGraph {
	public static void main(String[] args) 
	{  
		DFS dfsDemo = new DFS();
		System.out.println("");
		BFS bfsDemo = new BFS();
		System.out.println("");
		
		
		
		Graph g1 = new Graph(5);
		g1.addEdge(0,1);
		g1.addEdge(0,2);
		g1.addEdge(2,3);
		g1.addEdge(1,3);
		g1.addEdge(1, 4);
		g1.addEdge(3,4);
		if (g1.isTree())
			System.out.println("Graph is Tree");
		else
			System.out.println("Graph is not Tree");



	IdenticalTrees bfs = new IdenticalTrees(); 
        bfs.root= new Node(0);  
        bfs.root.left = new Node(1);  
        bfs.root.right = new Node(2);  
        bfs.root.left.left = new Node(3); 
        bfs.root.left.right = new Node(4);  
  
          IdenticalTrees dfs = new IdenticalTrees();  
          dfs.root = new Node(0);  
          dfs.root.left = new Node(1);  
          dfs.root.right = new Node(4);  
          dfs.root.left.left = new Node(3);  
          dfs.root.left.right = new Node(2);  
  
           if(IdenticalTrees.areIdenticalTrees(bfs.root, dfs.root))  
             System.out.println("DFS and BFS are equal. Therefore G=T");  
         else  
             System.out.println("DFS and BFS are unequal. Therefore G!=T");  

	} 
}



// 0,1,3,2,4 DFS (Preorder traversal) T

//						  0
//						/   \
//					   1	 4
//				      /  \	
//					 3    2


// 0,1,2,3,4 BFS T

//					0
//				   / \
//				  1   2
//				 / \
//			    3   4


/// Graph inputted G

//             0
//            / \
//			 1   2
//			/ \ /
//		   4 - 3

/* 
  2-3 and 4-3 edges are not there in any of the BFS or DFS tree therefore for G to be a Tree, we should not include 4-3 and 2-3 edges. 
  This clearly proves for G-Graph to be a Tree we should not include any edges in G-Graph that is not a part of Tree (BFS/DFS).
*/

