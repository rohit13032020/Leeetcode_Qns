class Solution {
    public int triangleNumber(int[] nums) {
      Arrays.sort(nums);
      int n = nums.length; 
      int count = 0;
      
      for(int high = n-1; high >= 2;high --) {
        int low = 0;
        int mid = high -1;
        while(low < mid) {
            if(nums[low] + nums[mid] > nums[high]) {
                count = count + (mid - low);
                mid--;
            } else {
                low++;
            }
        }
      
      
    }
    return count;
    }
}