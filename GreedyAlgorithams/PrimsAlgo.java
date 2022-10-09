package GreedyAlgorithams;
import java.util.*;

class Pair implements Comparable<Pair> {
    int v , wt;

    Pair(int _v, int _wt) {
        this.v = _v;
        this.wt = _wt;
    }

    @Override
    public int compareTo(Pair o) {
        return this.wt - o.wt;
    }
}

public class PrimsAlgo {

    private int spanningTree(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj) {

        boolean[] visited = new boolean[v];
        PriorityQueue<Pair> q = new PriorityQueue<>();

        q.offer(new Pair(0,0));

        int ans = 0;

        while(!q.isEmpty()) {
            Pair pair = q.poll();

            int u = pair.v;
            int wt = pair.wt;

            if(visited[u]) {
                continue;
            }
            visited[u] = true;
            ArrayList<ArrayList<Integer>> neighbours = adj.get(u);
            ans += wt;

            for(ArrayList<Integer> neighbour : neighbours) {
                int vertex = neighbour.get(0);
                int weight = neighbour.get(1);
                if(!visited[vertex]) {
                    q.offer(new Pair(vertex, weight));
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        PrimsAlgo primsAlgo = new PrimsAlgo();

        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        // edge 0 -> 2,3
        ArrayList<ArrayList<Integer>> edge0 = new ArrayList<>();
        edge0.add(new ArrayList<Integer> (List.of(1,2)));
        edge0.add(new ArrayList<Integer> (List.of(4,6)));
        edge0.add(new ArrayList<Integer> (List.of(3,7)));
        adj.add(0,edge0);

        // edge 1 -> 2,4
        ArrayList<ArrayList<Integer>> edge1 = new ArrayList<>();
        edge1.add(new ArrayList<Integer> (List.of(4,4)));
        edge1.add(new ArrayList<Integer> (List.of(2,1)));
        edge1.add(new ArrayList<Integer> (List.of(0,2)));
        adj.add(1,edge1);

        // edge 2 --> 1,5,3
        ArrayList<ArrayList<Integer>> edge2 = new ArrayList<>();
        edge2.add(new ArrayList<Integer> (List.of(1,1)));
        edge2.add(new ArrayList<Integer> (List.of(3,3)));
        edge2.add(new ArrayList<Integer> (List.of(4,2)));
        adj.add(2,edge2);

        // edge 3 -> 2,5
        ArrayList<ArrayList<Integer>> edge3 = new ArrayList<>();
        edge3.add(new ArrayList<Integer> (List.of(0,7)));
        edge3.add(new ArrayList<Integer> (List.of(2,3)));
        edge3.add(new ArrayList<Integer> (List.of(4,5)));
        adj.add(3,edge3);

        // edge 4 -> 2,3
        ArrayList<ArrayList<Integer>> edge4 = new ArrayList<>();
        edge4.add(new ArrayList<Integer> (List.of(1,4)));
        edge4.add(new ArrayList<Integer> (List.of(2,2)));
        edge4.add(new ArrayList<Integer> (List.of(3,5)));
        adj.add(4,edge4);

        System.out.println(primsAlgo.spanningTree(5, adj));

    }
}
