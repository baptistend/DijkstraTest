package djikstra;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
	

    public static void main(String[] args)
    {
//    	
    	ShortestPaths djikstra = new ShortestPaths();
    	
    	File inputFile = new  File("./input.txt"); 
    	File outputFile = new File("./output.txt");
    	GraphReader graphReader = new GraphReader();
    	
	
		try(FileReader fr = new FileReader(inputFile);
			FileWriter fw = new FileWriter(outputFile,false);
			BufferedReader br = new BufferedReader(fr) ){

			String line ;
			if( (line = br.readLine()) != null && line.length() > 0) {
				
				graphReader.readLine(line);
				Integer minCost = djikstra.findShortestPaths(graphReader.getGraph(), graphReader.getSource(), graphReader.getNbNodes(), graphReader.getDestination());
				fw.write(minCost.toString());
				
			}
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}

    			
    			

    			
//        // initialise les bords selon le diagramme ci-dessus
//        // (u, v, w) représente le bord du sommet `u` au sommet `v` ayant le poids `w`
//        List<Edge> edges = Arrays.asList(
//                new Edge(0, 1, 4), new Edge(0, 2, 3), new Edge(1, 5, 5),
//                new Edge(1, 4, 12), new Edge(2, 3, 7), new Edge(2, 4, 10),
//                new Edge(3, 4, 2), new Edge(4, 6, 5), new Edge(5, 6, 16)
//        );
// 
//        // nombre total de nœuds dans le graphe (étiquetés de 0 à 4)
//        int n = 7;
//        
//     
//        Graph graph = new Graph(edges,n);
//        int source = 0 ;
//        
//        int destination = 6 ; 
//        
//
// 
//        // construit le graphe
//        ShortestPaths djikstra = new ShortestPaths();
//    	System.out.println(djikstra.findShortestPaths(graph, source, n, destination));
    	
    	
 
        // exécute l'algorithme de Dijkstra à partir de chaque nœud
     
            
       
    }

	

}
