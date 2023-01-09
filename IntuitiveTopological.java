import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

public class IntuitiveTopological implements TopologicalSort {
	

private boolean[] marked;
private int[] edgeTo;
LinkedList<Integer> cycle;
private boolean[] onStack;
private int Size;
LinkedList<Integer> ZeroStore;
private BetterDiGraph GraphCopy;
private LinkedList<Integer> ToplogicalOrder;




public IntuitiveTopological(BetterDiGraph Graph)                    //Constructor need to keep working on
{
	
	GraphCopy = Graph;
	if(GraphCopy.Checkcycle() )                                     // If true  Has a cycle
	   {
	    System.out.println("A cycle Exists!");;              
	   }
	
	
	if(isDAG())
	{		
		for(int v = 0; v < GraphCopy.getVertexCount(); v++)
		{
			if(GraphCopy.getIndegree(v)== 0)
			{
				if(ToplogicalOrder == null)
				{
				ToplogicalOrder = new LinkedList<>();
				}
				ToplogicalOrder.add(v);
			}
			
			if(GraphCopy.getIndegree(v)!= 0)
			{
			GraphCopy.removeVertex(v);
			}
		}
	
	}
	
}


	@Override
	public Iterable<Integer> order() 
	{
		Iterable store = ToplogicalOrder;
		 
		return store;
	}

	//Checks if Cycles Exist
	@Override
	public boolean isDAG() 
	{
		return GraphCopy.Checkcycle() == false;
	}
	
	
	
}
	
	
	
	
	

	
	
	
	

	

