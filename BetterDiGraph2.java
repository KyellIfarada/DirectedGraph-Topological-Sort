
import java.util.NoSuchElementException;
import java.util.stream.StreamSupport;
import java.util.LinkedList;

import java.io.InputStream;
public class BetterDiGraph2 implements EditableDiGraph {

	private int V;
	private int E;
	private LinkedList<Integer>[] adj;
	
	public BetterDiGraph2()
	{
		this.V = 0;
		this.E = 0;
		adj = (LinkedList<Integer>[]) new LinkedList[V];
		for(int v = 0 ; v < V ; v++) 
			adj[v] = null;
		
	}

	
	public BetterDiGraph2(int V)
	{
		this.V = 0;
		this.E = 0;
		adj = (LinkedList<Integer>[]) new LinkedList[V];
		for(int v = 0 ; v < V ; v++) 
			adj[v] = null;
		
	}
	
	//Get Vertex
	public int V()
	{
		return V;
		
	}
	
	//Get Edges
	public int E() {
		return E;
	}
	
	// adjacent vertices
	public Iterable<Integer> adj(int v) {
		return adj[v];
		}

	
	@Override
	public void addEdge(int v, int w) {
		if(adj[v] == null )
		{
		addVertex(v);
		}
		if(adj[w] == null)
		{
		addVertex(w);
		}
			
		adj[v].add(w);
		E++;
		
		
		
         }
	

	@Override
	public void addVertex(int v) {
		adj[v]= new LinkedList<>() ;
		V++;	
	}

	@Override
	public Iterable<Integer> getAdj(int v) {
		// TODO Auto-generated method stub
		return adj[v];
	}

	@Override
	public int getEdgeCount() {
		return E;
	}

	@Override
	public int getIndegree(int v) throws NoSuchElementException {
		int count =0;
		BetterDiGraph2 ReversedGraph = reverse();
		
		Iterable<Integer> MyValues = ReversedGraph.getAdj(v);
		for(Integer i:MyValues)
		{
			count++;
		}
		
		
		return count;
	}
	
	public BetterDiGraph2 reverse()
	{
		BetterDiGraph2 R = new BetterDiGraph2(V);;
		for (int x = 0 ; x < V; x++)
		{
			for (int w: adj(x))
			{
				R.addEdge(w,x);
			}
		}
		return R;
	}

	@Override
	public int getVertexCount() {
		// TODO Auto-generated method stub
		return V();
	}

	@Override
	public void removeEdge(int v, int w) 
	{
		adj[v].remove(w);
		E--;
	}

	@Override
	public void removeVertex(int v) {
		adj[v] = null;
		V--;
	}

	@Override
	public Iterable<Integer> vertices() {
		
		// TODO Auto-generated method stub
    	LinkedList<Integer> NewList = new LinkedList<Integer>();
		for (int a = 0; a < V; a++)
			NewList = adj[a];
		return NewList;
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (V >= 1)
			return false;
		else
			return true;
	}

	@Override
	public boolean containsVertex(int v) {
		
			if (adj[v] != null);
				return true;
	}

}
