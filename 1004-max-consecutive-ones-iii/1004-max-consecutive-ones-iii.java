class Solution {
    public int longestOnes(int[] nums, int k) {
        int count = 0;
        int max_count = 0;
        int flip = 0;
        int left = 0;

        for(int right = 0; right < nums.length;right++){
            if(nums[right] != 1) {
               flip++;
            }
            while(flip > k){
                if(nums[left] != 1) {
                    flip--;
                }
                left++;
            }
            max_count = Math.max(max_count,right - left + 1);
        }
        return max_count;
    }
}