class Solution {
    public long repairCars(int[] ranks, int cars) {
        long low = 1;
        long high = 1;

        int minrank = Integer.MAX_VALUE;
        for(int rank : ranks) {
            minrank = Math.min(minrank,rank);
        }

        high = (long)  minrank * cars * cars;

        long ans = high;

        while(low<=high) {

            long mid = low + (high - low) /2;

            if(helper(ranks,mid,cars)){
                ans = mid;
                high = mid -1;
            } else {
                low = mid +1;
            }
        }
        return ans;
    }
    private boolean helper(int[] ranks,long mid , int cars) {
        long total = 0;

        for(int rank : ranks) {
            long n = (long) Math.sqrt(mid/rank);
            total += n;

            if(total >= cars) {
                return true;
            }
        }
        return false;
    }
}