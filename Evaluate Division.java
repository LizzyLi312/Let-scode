//union find
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int len = equations.size(), lenQ = queries.size();
        double[] res = new double[lenQ];
        HashMap<String, V> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            List<String> equa = equations.get(i);
            String s1 = equa.get(0), s2 = equa.get(1);
            double val = values[i];
            if(!map.containsKey(s1)) map.put(s1, new V(s1));
            if(!map.containsKey(s2)) map.put(s2, new V(s2));
            V v1 = map.get(s1);
            V v2 = map.get(s2);
            if(!find(v1, v2)) union(v1, v2, val);
        }
        for(int i = 0; i < lenQ; i++){
            List<String> query = queries.get(i); 
            String s1 = query.get(0), s2 = query.get(1);
            if(!map.containsKey(s1) || !map.containsKey(s2)) res[i] = -1.0;
            else{
                V v1 = map.get(s1), v2 = map.get(s2);
                if(find(v1, v2)) res[i] = division(v1, v2);
                else res[i] = -1.0;
            }
        }
        return res;
    }
    private void union(V v1, V v2, double d){
        V root1 = root(v1), root2 = root(v2);
        if(root1.size > root2.size){
            root2.parent = root1;
            root2.val = v1.val * d / v2.val;
            root1.size += root2.size;
        }
        else{
            root1.parent = root2;
            root1.val = v2.val / (v1.val * d);
            root2.size += root1.size;
        }
    }
    private V root(V v){
        V cur = v;
        double d = 1.0;
        while(cur != cur.parent){
            cur.val *= cur.parent.val;
            d *= cur.val;
            cur.parent = cur.parent.parent;
            cur = cur.parent;
        }
        v.parent = cur;
        v.val = d;
        return cur;
    }
    private boolean find(V v1, V v2){
        return root(v1) == root(v2);
    }
    private double division(V v1, V v2){
        return v2.val / v1.val;
    }
    class V{
        public String name;
        public double val;
        public V parent;
        private int size;
        public V(String name){
            this.name = name;
            this.parent = this;
            this.val = 1.0;
            this.size = 1;
        }
    }
}
