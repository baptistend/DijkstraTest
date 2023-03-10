package djikstra;

// Une classe pour stocker une arête de graphe
public class Edge
{
    int source, dest, weight;
 
    public Edge(int source, int dest, int weight)
    {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }
}