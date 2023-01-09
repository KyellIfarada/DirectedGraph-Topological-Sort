
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/**
 * Program for generating kanji component dependency order via topological sort.
 * 
 * @author (your name), Acuna
 * @version (version)
 */
public class StewartMain   {
    
   
	/**
     * Entry point for testing.
     * @param args the command line arguments
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        //TODO: implement this 
    	
    //FilePath as Parameter
    // File KanjiTxt          = new File("/home/lorenzo/eclipse-workspace/STEWARTTS/holdmyfiles/data-kanji.txt");
    // File DataComponentsTxt = new File("/home/lorenzo/eclipse-workspace/STEWARTTS/holdmyfiles/data-components.txt");
    	
    //Create HASH TABLE including Id's paired with characters.
    HashMap<Integer, String> KanjiTextHashMap = new HashMap();

    //Create BufferReader Objects 
    BufferedReader EdgeConnector;
    BufferedReader indexReader;
    
	//Store File Data in Buffer Objects
	indexReader = new BufferedReader(new InputStreamReader(new FileInputStream("data-kanji.txt"),"UTF8"));
	
	EdgeConnector = new BufferedReader(new InputStreamReader(new FileInputStream("data-components.txt"),"UTF8"));
	
	//Create Graph instance for Indexes
	BetterDiGraph KanjiGraph= new BetterDiGraph();
	
   // MAPS ID/KANJI to HASHTABLE     // Creates Graph of Nodes/Vertices of Kanji Indexes
   String TheData ;
   while( ( TheData = indexReader.readLine() )!= null)
   {
	  if(TheData.charAt(0) != '#'  && TheData.charAt(1) != '#' ) 
	  {
		  
	  
	  String TheDataStored = TheData;
	  String strings[]=TheDataStored.split("\t");
	  KanjiTextHashMap.put(Integer.valueOf(strings[0]), strings[1]);          //HASHMAP ENCODING
	              //Graph ENCODING
	  }
	  
		  	
   }
  
   
   //Creates EDGES
   String Components ;
   while( ( Components = EdgeConnector.readLine() ) != null) 
   {
	   if(Components.charAt(0) != '#'  && Components.charAt(1) != '#'  ) 
	   {
	  String ComponentsStored = Components;
	  String strings[]=ComponentsStored.split("\t");
	  KanjiGraph.addEdge( Integer.valueOf(strings[0]), Integer.valueOf(strings[1]  ));
	   }
   }
   
   
   //Create Topological Sort 
    IntuitiveTopological SortedTopological = new IntuitiveTopological(KanjiGraph);
  
   //Display
   {
	   			for(Integer t: SortedTopological.order())
	   			{
	   			System.out.println(KanjiTextHashMap.get(t));
	   			}
   }
  

   

   
  
   
   
   
   
   
   
   
    }
}