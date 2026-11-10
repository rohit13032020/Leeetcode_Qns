class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for(int pile : piles){
            high = Math.max(high,pile);
        }
        int result = high;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            long hours_taken = helper(piles,mid);

            if(hours_taken <= h) {
               result = mid;
               high = mid-1;
            } else {
            low = mid +1;
            }
        }
        return result;
    }
    private long helper(int[] piles,int speed){
      long Total_Hours = 0;
      for(int pile : piles) {
          Total_Hours = Total_Hours + pile / speed;
          if(pile % speed != 0){
             Total_Hours++;
          }
      }
      return Total_Hours;
    }
}