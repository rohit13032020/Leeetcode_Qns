class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int low = 1;
        int high = 0;

        for(int q: quantities) {
            high = Math.max(high,q);
        }
        int result = high;

        while(low <= high) {
           int mid = low+(high -low) / 2;
           long storeneed = helper(quantities,mid);

           if(storeneed <= n) {
            result = mid;
            high = mid -1;

           } else {
            low = mid +1;
           }
        }
        return result;
    }
    private long helper(int[] quantities, int k) {
        long stores = 0;
        for(int q : quantities) {
            stores = stores + q / k;

            if(q%k != 0) {
                stores++;
            }
        }
        return stores;
    }
}