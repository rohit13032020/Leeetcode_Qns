class Solution {
    public int minCapability(int[] nums, int k) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int num : nums) {
            high = Math.max(high,num);
            low = Math.min(low,num);
        }

        int ans = -1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(Helper(nums,k,mid)) {
               ans = mid;
               high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    private boolean Helper(int[] nums,int k,int mid) {
     int count = 0;
     
     for(int i = 0; i < nums.length;i++) {
        if(nums[i] <= mid) {
            count++;
            i++;
        }
     }
     return count >= k;
    }
}