//union find 
class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if(positions == null) return res;
        UnionFind uf = new UnionFind(m, n);
        for(int[] position : positions){
            int i = position[0], j = position[1], p = uf.idx(position[0], position[1]);
            uf.addIsland(p); 
            List<int[]> neis = getNeis(i, j, m, n); //union with the neighbor where is island too
            for(int[] nei : neis){
                int q = uf.idx(nei[0], nei[1]);
                if(uf.isIsland(q) && !uf.find(p, q)) uf.union(p,q);
            }
            res.add(uf.size);
        }
        return res;
    }
    
    private List<int[]> getNeis(int i, int j, int row, int col){
        List<int[]> res = new ArrayList<>();
        int[][] dirs = {{1,0},{-1,0},{0,-1},{0,1}};
        for(int[] dir : dirs){
            int newRow = dir[0] + i;
            int newCol = dir[1] + j;
            if(newRow >= 0 && newRow < row && newCol >= 0 && newCol < col) res.add(new int[]{newRow, newCol});
        }
        return res;
    }
    
    class UnionFind{
        public int size, row, col;
        public int[] ids, sz;
        public UnionFind(int row, int col){
            this.size = 0;
            this.row = row;
            this.col = col;
            int len = row * col;
            ids = new int[len]; //parents
            sz = new int[len]; //size 
            for(int i = 0; i < len; i++){
                ids[i] = -1; //means it is not an island
                sz[i] = 1;
            }
        }
        public boolean find(int p, int q){
            return root(p) == root(q);
        }
        public void union(int p, int q){
            int rootP = root(p), rootQ = root(q);
            if(sz[rootP] < sz[rootQ]){
                ids[rootP] = rootQ;
                sz[rootQ] += sz[rootP];
                this.size--;
            }
            else{
                ids[rootQ] = rootP;
                sz[rootP] += sz[rootQ];
                this.size--;
            }
        }
        private int root(int p){
            int tempP = p;
            while(ids[p] != p){
                ids[p] = ids[ids[p]];
                p = ids[p];
            }
            ids[tempP] = p;
            return p;
        }
        public int idx(int i, int j){
            return i * col + j;
        }
        public void addIsland(int p){
            if(ids[p] == -1){
                ids[p] = p;
                size++;
            }
        }
        public boolean isIsland(int p){
            return ids[p] != -1;
        }
    }
}
