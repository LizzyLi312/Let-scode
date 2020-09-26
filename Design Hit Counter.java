class HitCounter {
    private int[] times;
    private int[] hits;
    /** Initialize your data structure here. */
    public HitCounter() {
        times = new int[300];
        hits = new int[300];
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int idx = timestamp % 300; //circular array
        if(times[idx] != timestamp){ //update to new hit 
            times[idx] = timestamp;
            hits[idx] = 1;
        }
        else hits[idx]++; //if it is the same hit in the same period 
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int total = 0;
        for(int i = 0; i < 300; i++){
            if(timestamp - times[i] < 300){
                total += hits[i];
            }
        }
        return total;
    }
}

//how to scale?
