package datasturcture.graph;

import datasturcture.bag.Bag;

public class Graph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Graph(int V) {
        this.V=V;
        this.E=0;
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }


    public static int degree(GraphAPI G, int v) {
        int degree = 0;
        for (int w : G.adj(v)) degree++;
        return degree;
    }

    public static int maxDegree(GraphAPI G) {
        int max = 0;
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                if (degree(G, w) > max) max = degree(G, w);
            }
        }
        return max;
    }

    public static double aveDegree(GraphAPI G) {
        return 2.0 * G.E() / G.V();
    }

    public static int numberOfSelfLoops(GraphAPI G) {
        int count = 0;
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                if (v == w) count++;
            }
        }
        return count / 2;
    }

    public String toString() {
        return "";
    }

}
