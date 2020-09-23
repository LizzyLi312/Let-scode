class Solution {
    public int scheduleCourse(int[][] courses) {
        if(courses == null || courses.length == 0 || courses[0] == null || courses[0].length == 0) return 0;
        Arrays.sort(courses, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[1] - b[1];
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                return b - a;
            }
        });
        int time = 0;
        for(int[]  c : courses){
            time+= c[0];
            pq.add(c[0]);
            if(time > c[1]) time -= pq.poll();
        }
        return pq.size();
    }
}
