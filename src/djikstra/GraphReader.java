package djikstra;

import java.util.ArrayList;
import java.util.List;

public class GraphReader {
	
	private Graph graph; 
	private int nbNodes;
	private int source  ;
	private int destination ; 
	
	public int []  readNumber(String line, char curChar, int  curValue) {
	    	
		int[] val  = new int[2];
		val[0]= 0 ; 
		val[1] = 0 ; 
		while(Character.isDigit(curChar)) {
					
					int digitWeight = Character.getNumericValue(curChar);
					val[0] = val[0] * 10 + digitWeight;
					val[1]++;
					curValue ++ ;
					curChar = line.charAt(curValue);
					
		}
		
		return val; 
		
	}
	
	 
    public Graph getGraph() {
		return graph;
	}


	public int getNbNodes() {
		return nbNodes;
	}


	public int getSource() {
		return source;
	}


	public int getDestination() {
		return destination;
	}


	public void readLine(String line) {
    	
    	List<Edge> edges = new ArrayList<>(); 


    	int curValue = 0; 

    	char curChar =  line.charAt(curValue);
    	
    	int[] numberInfo = readNumber(line, curChar, curValue);
    	
    	nbNodes  =  numberInfo [0];
    	
    	curValue +=  numberInfo [1];
    	curChar =  line.charAt(curValue);
    	
	
		//Se placer sur la première arrête
		curValue ++;
		curValue++;
		curChar = line.charAt(curValue);
	
		
		
		int[] edge  = new int[3];
		
	
		while(curChar != ';') {
			
			 int indEdge = 0;
			 while(curChar != '|') {
				 
				 int valChar = 0 ;
				 int sizeValChar = 0; 
				 
				 numberInfo = readNumber(line, curChar, curValue);
				 valChar = numberInfo[0];
				 curValue += numberInfo[1];
				 curChar = line.charAt(curValue);

				 if(curChar == ',') {
					 
					 curValue ++;
					 curChar = line.charAt(curValue);
					 
				 }
				
				 edge[indEdge] = valChar;
				 indEdge++;
					 
				
			 }
			 edges.add(new Edge(edge[0], edge[1], edge[2]));
			 
			 if(curChar != ';') {
				 
				 curValue ++;
				 curChar = line.charAt(curValue);
				 
			 }
			 
			 
			 
		}
		
		curValue++;
		curChar = line.charAt(curValue);
		
		numberInfo = readNumber(line, curChar, curValue);
		source = numberInfo[0];
		curValue += numberInfo[1];
		
		curValue++;
		curChar = line.charAt(curValue);
		
		numberInfo = readNumber(line, curChar, curValue);
		destination = numberInfo[0];
		curValue += numberInfo[1];
	 
	 
	 
		////	 System.out.println( edges.get(iemeEdge).source + " " +edges.get(iemeEdge).dest + " " +  edges.get(iemeEdge).weight );
		//	for(Edge e : edges) {
		//		System.out.println( e.source + " " +e.dest + " " +  e.weight );
		//	}
		//	
		//	System.out.println("Source = "+ source + " Destination = " + destination);

		graph = new Graph(edges, nbNodes);
	
	
    }


}
