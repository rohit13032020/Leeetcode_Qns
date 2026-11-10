class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
 
        for(int pile : piles) {
            high = Math.max(high,pile);
        }
        int result = high;

        while(low <= high ){
            int mid = low + (high - low) / 2;

            long ans = Helper(piles,mid);

               if(ans <= h) {
                result = mid;
                high = mid -1;
               } else {
                low = mid + 1;
                }
        }
        return result;
    }
    private long Helper(int[] piles,int k) {
        long time_hours = 0;

        for(int pile : piles) {
            time_hours = time_hours + pile / k;

            if(pile % k != 0) {
                time_hours ++;
            }
        }
        return time_hours;
    }
}