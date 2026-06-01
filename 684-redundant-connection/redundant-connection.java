class UnionFind{
    int[] parent,size;
    public UnionFind(int n){
        parent = new int[n];
        size = new int[n];

        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x){
        if(x==parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    public boolean union(int u, int v){
        int pu = find(u);
        int pv = find(v);

        if(pu==pv) return false;

        if(size[pu]>size[pv]){
            size[pu] += size[pv];
            parent[pv] = pu;
        } else{
            size[pv] += size[pu];
            parent[pu] = pv;
        }
        return true;
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n);
        for(int[] edge: edges){
            if(!uf.union(edge[0]-1, edge[1]-1)){
                return new int[]{edge[0], edge[1]};
            }
        }
        return new int[]{};
    }
}