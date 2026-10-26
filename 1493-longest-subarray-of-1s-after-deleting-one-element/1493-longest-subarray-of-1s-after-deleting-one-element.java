class Solution {
    public int longestSubarray(int[] nums) {

        int max_count = 0;
        int flip = 0;
        int left = 0;

        for(int right = 0; right<nums.length;right++){

            if(nums[right]!=1) {
                flip++;
            }
            while(flip>1){
                if(nums[left]==0){
                    flip--;
                }
                left++;
            }
            max_count = Math.max(max_count,right - left);

        }
        return max_count;
        
    }
}