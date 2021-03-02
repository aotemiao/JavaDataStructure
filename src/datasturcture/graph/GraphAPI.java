package datasturcture.graph;

public interface GraphAPI {
    GraphAPI Graph(int V);

    //    Graph Graph(In in);

    int V();

    int E();

    void addEdge(int v, int w);

    Iterable<Integer> adj(int v);   //和v相邻的所有顶点

    String toString();

}
