class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        int n = intervals.length;

        List<int[]> merged = new ArrayList<>();

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        int st = -1, ed = -1;
        for (int[] interval : intervals) {
            if (ed <= interval[0]) { // breaking tie 
                if (st != -1) merged.add(new int[]{st, ed});
                st = interval[0];
                ed = interval[1];
            } else {
                ed = Math.max(ed, interval[1]);
            }
        }
        if (st != -1) merged.add(new int[]{st, ed});
        return merged.size() == n ? true : false;
    }
}

// solutioin2
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        int n = intervals.length;

        List<int[]> merged = new ArrayList<>();

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        int st = -1, ed = -1;
        for (int[] interval : intervals) {
            if (ed <= interval[0]) {
                if (st != -1) merged.add(new int[]{st, ed});
                st = interval[0];
                ed = interval[1];
            } else {
                return false; // return false when there is an overlapping
            }
        }
        return true;
    }
}
