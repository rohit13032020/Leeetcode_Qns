class Solution {
    public int minimumDifference(int[] nums, int k) {
        return helper(nums,k);
    }
    private int helper(int[] arrs,int k){
        int n = arrs.length;
        int min_diff = Integer.MAX_VALUE;
        Arrays.sort(arrs);
        for(int i = 0 ; i <= n - k;i++){
            int diff = arrs[i+k-1] - arrs[i];
            min_diff = Math.min(min_diff,diff);
        }
        return min_diff;
    }
}