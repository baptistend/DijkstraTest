package djikstra;

import java.util.ArrayList;
import java.util.List;

public class Graph
{
    // Une liste de listes pour représenter une liste de contiguïté
    List<List<Edge>> adjList = null;
 
    // Constructeur
    Graph(List<Edge> edges, int n)
    {
        adjList = new ArrayList<>();
 
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
 
        // ajoute des arêtes au graphe orienté
        for (Edge edge: edges) {
            adjList.get(edge.source).add(edge);
        }
    }
}