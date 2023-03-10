package djikstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestPaths {
	
	 private void getRoute(int[] prev, int i, List<Integer> route)
    {
        if (i >= 0)
        {
            getRoute(prev, prev[i], route);
            route.add(i);
        }
    }
	 
	 
	 
 // Exécute l'algorithme de Dijkstra sur un graphe donné
    public int findShortestPaths(Graph graph, int source, int n, int destination)
    {
        // crée un min-heap et pousse le nœud source ayant une distance de 0
        PriorityQueue<Node> minHeap;
        minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        minHeap.add(new Node(source, 0));
 
        // définit la distance initiale de la source à `v` comme infini
        List<Integer> dist;
        dist = new ArrayList<>(Collections.nCopies(n, Integer.MAX_VALUE));
 
        // la distance de la source à elle-même est nulle
        dist.set(source, 0);
 
        // array booléen pour suivre les sommets pour lesquels le minimum
        // le coût est déjà trouvé
        boolean[] done = new boolean[n];
        done[source] = true;
 
        // stocke le prédécesseur d'un sommet (dans un chemin d'impression)
        int[] prev = new int[n];
        prev[source] = -1;
 
        // exécuter jusqu'à ce que le Min-Heap soit vide
        while (!minHeap.isEmpty())
        {
            // Supprime et renvoie le meilleur sommet
            Node node = minHeap.poll();
 
            // récupère le numéro du sommet
            int u = node.vertex;
 
            // faire pour chaque voisin `v` de `u`
            for (Edge edge: graph.adjList.get(u))
            {
                int v = edge.dest;
                int weight = edge.weight;
 
                // Etape détente
                if (!done[v] && (dist.get(u) + weight) < dist.get(v))
                {
                    dist.set(v, dist.get(u) + weight);
                    prev[v] = u;
                    minHeap.add(new Node(v, dist.get(v)));
                }
            }
 
            // marque le sommet `u` comme terminé pour qu'il ne soit plus repris
            done[u] = true;
        }
 
        List<Integer> route = new ArrayList<>();
        List<Character> route_c = new ArrayList<>();
        
        if (destination != source && dist.get(destination) != Integer.MAX_VALUE){
        	
        	 getRoute(prev, destination, route);
        	 
        	 System.out.println( String.format("Path (%d —> %d): Minimum cost = %d, Route = %s",
                    source , destination, dist.get(destination), route) ) ;
        	 
        	 
        	 route.clear();
        	 
        	
        } 
        
        return dist.get(destination);
        
      
 
//	        for (int i = 0; i < n; i++)
//	        {
//	            if (i != source && dist.get(i) != Integer.MAX_VALUE)
//	            {
//	                getRoute(prev, i, route);
//	                System.out.printf("Path (%d —> %d): Minimum cost = %d, Route = %s\n",
//	                                source, i, dist.get(i), route);
//	                
//	            }
//	        }
    }
    
  

}
