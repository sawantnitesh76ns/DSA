package Graph;

import java.util.*;

public class KosarajssAlgo {
    
    private int V;
    private LinkedList<Integer> adj[];

    KosarajssAlgo(int v) {
        V = v;
        adj = new LinkedList[v];
        for(int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // DFS to print SCC
    void DFSUtil(int s , boolean[] visited) {
        visited[s] = true;
        System.out.print(s + " ");
        int n;

        Iterator<Integer> i = adj[s].iterator();
        while(i.hasNext()) {
            n = i.next();
            if(!visited[n]) {
                DFSUtil(n, visited);
            }
        }

    }

    void addEdge(int v , int d) {
        adj[v].add(d);
    }

    KosarajssAlgo reverseGraph() {
        KosarajssAlgo g = new KosarajssAlgo(V);
        for(int i = 0; i < V; i++) {
            Iterator<Integer> adjNodes = adj[i].iterator();
            while(adjNodes.hasNext()) {
                g.adj[adjNodes.next()].add(i);
            }
        }

        return g;

    }


    void dfs(int i , boolean[] visited , Stack<Integer> statck) {
        visited[i] = true;

        Iterator<Integer> adjNodes = adj[i].iterator();

        while(adjNodes.hasNext()) {
            int edge = adjNodes.next();
            if(!visited[edge]) {
                dfs(edge, visited, statck);
            }
        }

        statck.push(i);
    }


    void printSCC() {
        // Step 1 - Travell through graph and build stack
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        Arrays.fill(visited , false);

        // DFS
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                dfs(i, visited, stack);
            }
        }

        // Step 2 - Reverse graph
        KosarajssAlgo graph = reverseGraph();
        
        // Reinitialise all edges unvisited
        Arrays.fill(visited, false);

        // Step 3: DFS reversed graph and print all element
        
        while(!stack.empty()) {
            int v = stack.pop();

            if(!visited[v]) {
                graph.DFSUtil(v, visited);
                System.out.println();
            }
            
        }

    }
    

    public static void main(String[] args) {
        KosarajssAlgo g = new KosarajssAlgo(8);
        g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(2, 4);
		g.addEdge(3, 0);
		g.addEdge(4, 5);
		g.addEdge(5, 6);
		g.addEdge(6, 4);
		g.addEdge(6, 7);

        System.out.println("Strongly connected graphs");
        g.printSCC();

    }

}
