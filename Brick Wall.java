// be careful with the right boundary 
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(List<Integer> wal : wall){ //compare the gap position
            int gap = 0;
            for(int i = 0; i < wal.size() - 1; i++){ // wal.size() - 1 since we dont need to count the last gap which is the boundary of right side
                gap += wal.get(i);
                map.put(gap, map.getOrDefault(gap, 0) + 1);
            }
        }
        int max = 0;
        for(Integer key : map.keySet()){
            if(key == wall.size()) continue; // need to ignore the right boundary
            max = Math.max(map.get(key), max);
        }
        return wall.size() - max;
    }
}
