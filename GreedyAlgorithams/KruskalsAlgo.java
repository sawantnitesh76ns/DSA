package GreedyAlgorithams;

import java.util.Arrays;

public class KruskalsAlgo {
    class Edge implements Comparable<Edge> {
        int src,dest,wt;

        @Override
        public int compareTo(Edge o) {
            // TODO Auto-generated method stub
            return this.wt - o.wt;
        }
    }

    class Subset {
        int parent, rank;
    }

    int vertices, edges;
    Edge[] edge;

    KruskalsAlgo(int _v , int _e) {
        vertices = _v;
        edges = _e;
        edge = new Edge[_e];

        for(int i = 0; i < _e; i++) {
            edge[i] = new Edge();
        }
    }


    int find(Subset subsets[], int i) {
        if (subsets[i].parent != i)
          subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
      }
    
      void Union(Subset subsets[], int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);
    
        if (subsets[xroot].rank < subsets[yroot].rank)
          subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
          subsets[yroot].parent = xroot;
        else {
          subsets[yroot].parent = xroot;
          subsets[xroot].rank++;
        }
      }

    void kruskalsAlgo() {
        Edge result[] = new Edge[vertices];
        // Indexing for result array
        int e = 0;
        for(int  i = 0; i < vertices; i++) {
            result[i] = new Edge();
        }

        // Sort edge array
        Arrays.sort(edge);

        Subset[] subsets = new Subset[vertices];
        for(int i = 0; i < vertices; i++) {
            subsets[i] = new Subset();
        }
        for(int i = 0; i < vertices; i++) {
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }

        int  i = 0;
        while(e < vertices - 1) {
            Edge curr = edge[e++];

            int xRoot = find(subsets , curr.src);
            int yRoot = find(subsets, curr.dest);

            if(xRoot != yRoot) {
                Union(subsets, xRoot, yRoot);
                result[e++] = curr;
            }
            
        }

        for(i = 0; i < e; i++) {
            System.out.println(result[i].src + " - " + result[i].dest + ": " + result[i].wt);
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        int edges = 8;

        KruskalsAlgo G = new KruskalsAlgo(vertices, edges);

        G.edge[0].src = 0;
        G.edge[0].dest = 1;
        G.edge[0].wt = 4;

        G.edge[1].src = 0;
        G.edge[1].dest = 2;
        G.edge[1].wt = 4;

        G.edge[2].src = 1;
        G.edge[2].dest = 2;
        G.edge[2].wt = 2;

        G.edge[3].src = 2;
        G.edge[3].dest = 3;
        G.edge[3].wt = 3;

        G.edge[4].src = 2;
        G.edge[4].dest = 5;
        G.edge[4].wt = 2;

        G.edge[5].src = 2;
        G.edge[5].dest = 4;
        G.edge[5].wt = 4;

        G.edge[6].src = 3;
        G.edge[6].dest = 4;
        G.edge[6].wt = 3;

        G.edge[7].src = 5;
        G.edge[7].dest = 4;
        G.edge[7].wt = 3;
        G.kruskalsAlgo();
    }
}
