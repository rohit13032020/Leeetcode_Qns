class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int low = 0;
        int high =  1;
        int count = 0;

        while(high < n) {
            if(low == high || nums[high] - nums[low] < k) {
            high++;
            } else if(nums[high] - nums[low] > k) {
                low++;

            } else {
                count++;
                int left = nums[low];
                int right = nums[high];

                while(low < n && nums[low] == left) {
                    low++;
                }
                while(high < n && nums[high] == right) {
                    high++;
                }
                
            }
        }
        return count;
    }
}