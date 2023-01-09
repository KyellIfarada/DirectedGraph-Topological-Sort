
import java.util.NoSuchElementException;
import java.util.HashMap;
import java.util.stream.StreamSupport;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.io.InputStream;
public class BetterDiGraph implements EditableDiGraph {
LinkedList<Integer> SomeQueue;
	private int V;
	private int E;
//	private LinkedList<Integer>[] adj;
    private HashMap<Integer,LinkedList<Integer>>  adj = new HashMap();
    private HashMap<Integer,Integer> IncomingADJ = new HashMap();
    int touchednodes;
    int nodes;
	
	public BetterDiGraph()
	{
	    adj = new HashMap<Integer,LinkedList<Integer>>() ;
		this.V = 0;
		this.E = 0;
	    IncomingADJ = new HashMap();
	    nodes = V;
	    for (int i = 0; i < 997; i++) 
	    {
	    	IncomingADJ.put(i,0);
	    }
	}

	
	
	
	
	//Get Vertex
	public int V()                                           //Complete
	{
		return V;
		
	}
	 
	//Get Edges                                              //Complete
	public int E() 
	{
		return E;
	}
	public int LinkedLinkListElement(int v,int x)
	{
		return adj.get(v).get(x);
	}
	public int LinkedListSize(int v)
	{
		return adj.get(v).size();
	}
	
	// adjacent vertices                                      //Complete
	public Iterable<Integer> adj(int v) 
	{
		return  (Iterable<Integer>) adj.get(v).listIterator(0);
	}

	
	@Override
	public void addEdge(int v, int w) 				      	   //Complete
	{
		if(!adj.containsValue(v) )
		{
		addVertex(v);
		}
		if(!adj.containsValue(w))
		{
		addVertex(w);
		}
			
		adj.get(v).add(w);
		IncomingADJ.put(w,IncomingADJ.get(w)+1);
		E++;
		
		
		
         }
	
	                                                                               //Complete 
	@Override
	public void addVertex(int v) {  
		
		
		if(!adj.containsValue(v))           
		{	
		adj.put(v, new LinkedList<Integer>()) ;
		V++;
		}
	
		adj.get(v).add(v);
		
	}

	@Override
	public Iterable<Integer> getAdj(int v) 
	{
		
		// TODO Auto-generated method stub
	
		Iterable Values;
		return  Values =  adj.get(v);
	
		
	}

	@Override
	public int getEdgeCount() {
		return E;
	}

	@Override
	public int getIndegree(int v) throws NoSuchElementException 
	
	{
		int  storeIntDegree = 0;
		
		
			for(Entry<Integer, Integer> i: IncomingADJ.entrySet())
			{
				if (i.getKey()  == v ) 
				{
					storeIntDegree = i.getKey();
				}

			}
			
		
		return storeIntDegree;
	}
	
	
	public boolean Checkcycle() 
	{
		
		for(Entry<Integer, Integer> i: IncomingADJ.entrySet())
		{
			if (i.getKey()  == 0 ) 
			{
				if(SomeQueue == null)
				{   nodes++;
					SomeQueue =new LinkedList<>();
				}
				SomeQueue.add(i.getKey());
			}

		}
		
		
		while(!SomeQueue.isEmpty()) 
		{
		
			touchednodes++	;
			int source = SomeQueue.remove();	
		
		
		Iterable<Integer> ninorenList = adj.get(source);
		if(ninorenList == null)
		{
			ninorenList = new LinkedList<>();
		}
		for(Integer nino:ninorenList)
		 {
			IncomingADJ.put(nino, IncomingADJ.get(nino)-1);
			
			if(IncomingADJ.get(nino) == 0) {
				SomeQueue.add(nino);
			                                 }
			                                   
		 }
		}
		return nodes != touchednodes;
	
		
	}
	
	
	
	

	@Override
	public int getVertexCount() {                       //Complete
		// TODO Auto-generated method stub
		return V;
	}

	@Override
	public void removeEdge(int v, int w)               //Complete
	{  
		if(adj.containsKey(v) &&  adj.containsKey(w))
		{
		adj.get(v).remove(w);	
		E--;
		}

		
		
	}

	@Override
	public void removeVertex(int v)              //Complete
	{         
		if(adj.containsKey(v))
		{
		adj.remove(v);
		V--;
		}
	}

	@Override
	public Iterable<Integer> vertices() {
		
		// TODO Auto-generated method stub
		return	adj.keySet();
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (V >= 1)
			return false;
		else
			return true;
	}

	@Override                                         //Complete
	public boolean containsVertex(int v) {
		
			if (adj.containsKey(v));
				return true;
	}

}
