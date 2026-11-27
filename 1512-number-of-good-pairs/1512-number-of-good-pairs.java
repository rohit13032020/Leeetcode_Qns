class Solution {
    public int numIdenticalPairs(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int low = 0;
        int high = 1;
        int count = 0;

        while(low < n-1) {
            while(high < n) {
                if(nums[low] == nums[high]) {
                    count++;
                }
                high++;
            }
            low++;
            high = low +1;
        }
        return count;

    }
}