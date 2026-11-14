class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long low = 1;
        long minTime = Long.MAX_VALUE;

        for(int t : time) {
           minTime = Math.min(t,minTime);
        } 
        long high = minTime * totalTrips;
        long ans = high;

        while(low<= high) {
            long mid = low + (high - low) / 2;

            long total_trip = helper(time,mid,totalTrips);
           
           if(total_trip >= totalTrips) {
              ans = mid;
              high = mid-1;
           } else {
            low = mid +1;
           }
        }
        return ans;
    }
    private long helper(int[] times,long guess,int totalTrips) {
        long total_trip = 0;

        for(int time : times) {
            total_trip = total_trip + guess / time;

            if(total_trip >= totalTrips) {
               return total_trip;
            }
        }
        return total_trip;
    }
}