class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(List<Integer> wal : wall){ //compare the gap position
            int gap = 0;
            for(int i = 0; i < wal.size() - 1; i++){
                gap += wal.get(i);
                map.put(gap, map.getOrDefault(gap, 0) + 1);
            }
        }
        int max = 0;
        for(Integer key : map.keySet()){
            if(key == wall.size()) continue;
            max = Math.max(map.get(key), max);
        }
        return wall.size() - max;
    }
}
