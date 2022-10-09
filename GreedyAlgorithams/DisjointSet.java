package GreedyAlgorithams;

public class DisjointSet {
    int[] parent, rank;
    int n;

    DisjointSet(int size) {
        this.n = size;
        parent = new int[size];
        rank = new int[size];
        makeParent();
    }

    void makeParent() {
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(x);
        }
        return x;
    }


    void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);

        if(xRoot == yRoot) {
            return;
        }

        if(rank[xRoot] > rank[yRoot]) {
            parent[yRoot] = xRoot;
        } else if(rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = yRoot;
        } else {
            parent[yRoot] = xRoot;
            rank[xRoot] = rank[xRoot]++;
        }
    }
}
