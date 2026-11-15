class Solution {
    public int maximumCandies(int[] candies, long k) {
        int low = 1;
        int high = 0;

        for(int candy : candies) {
            high = Math.max(high,candy);
        }
        int ans = 0;

        while(low <= high) {
            int mid = low+(high - low) / 2;

            if(helper(candies,mid,k)) {
                ans = mid;
                low = mid +1;
            } else {
                high = mid -1;
            }
        }
        return ans;
    }
    private boolean helper(int[] candies,int mid,long k) {
        long ans = 0;

        for(int candys : candies) {
            ans = ans + candys / mid;
        }
        return ans >= k;
    }
}