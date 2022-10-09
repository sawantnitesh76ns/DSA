package GreedyAlgorithams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

class Pair implements Comparable<Pair> {

    int wt;
    int v;

    Pair(int _v, int _wt) {
        v = _v;
        wt = _wt;
    }

    @Override
    public int compareTo(Pair that) {
        // TODO Auto-generated method stub
        return this.wt - that.wt;
    }
    
}

public class DijkrasAlgo {
    
    
    static int[] dijkstra(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj, int s) {

        // Array to keep track of visited vertices
        boolean[] vis = new boolean[v];
        PriorityQueue<Pair> q = new PriorityQueue<>();

        q.offer(new Pair(s, 0));
        int ans[] = new int[v];
        Arrays.fill(ans, Integer.MAX_VALUE);

        ans[s] = 0;

        while(!q.isEmpty()) {
            Pair pair = q.poll();
            System.out.println(q.size());
            int u = pair.v;
            if(vis[u]) {
                continue;
            }
            vis[u] = true;

            ArrayList<ArrayList<Integer>> neighbour = adj.get(u);
            System.out.println(neighbour.size());
            for( ArrayList<Integer> list : neighbour) {
                int vertex = list.get(0);
                int wt = list.get(1);

                if(ans[vertex] > ans[u] + wt) {
                    ans[vertex] = ans[u] + wt;
                    q.offer(new Pair(vertex, ans[vertex]));
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        

        // edge 0 -> 2,3
        ArrayList<ArrayList<Integer>> edge0 = new ArrayList<>();
        edge0.add(new ArrayList<Integer> (List.of(2,4)));
        edge0.add(new ArrayList<Integer> (List.of(3,2)));
        adj.add(0,edge0);

        // edge 1 -> 2,4
        ArrayList<ArrayList<Integer>> edge1 = new ArrayList<>();
        edge1.add(new ArrayList<Integer> (List.of(2,9)));
        edge1.add(new ArrayList<Integer> (List.of(4,1)));
        adj.add(1,edge1);

        // edge 2 --> 1,5,3
        ArrayList<ArrayList<Integer>> edge2 = new ArrayList<>();
        edge2.add(new ArrayList<Integer> (List.of(1,9)));
        edge2.add(new ArrayList<Integer> (List.of(3,3)));
        edge2.add(new ArrayList<Integer> (List.of(5,1)));
        adj.add(2,edge2);

        // edge 3 -> 2,5
        ArrayList<ArrayList<Integer>> edge3 = new ArrayList<>();
        edge3.add(new ArrayList<Integer> (List.of(2,3)));
        edge3.add(new ArrayList<Integer> (List.of(5,1)));
        adj.add(3,edge3);

        // edge 0 -> 2,3
        ArrayList<ArrayList<Integer>> edge4 = new ArrayList<>();
        edge4.add(new ArrayList<Integer> (List.of(1,1)));
        edge4.add(new ArrayList<Integer> (List.of(5,2)));
        adj.add(4,edge4);

        // edge 0 -> 2,3
        ArrayList<ArrayList<Integer>> edge5 = new ArrayList<>();
        edge5.add(new ArrayList<Integer> (List.of(2,1)));
        edge5.add(new ArrayList<Integer> (List.of(3,1)));
        edge5.add(new ArrayList<Integer> (List.of(4,2)));
        adj.add(5,edge5);

        int[] result = dijkstra(6, adj, 1);
        System.out.println(Arrays.toString(result));
    }
}
