class Solution {
    public double findMaxAverage(int[] nums, int k) {
        return Helper(nums,k);
    }
    private double Helper(int[] nums,int k){
        int curr_Sum = 0;
        
        for(int i = 0 ; i < k;i++){
            curr_Sum = curr_Sum + nums[i];
        }
        int max_Sum = curr_Sum;

        for(int i = k; i < nums.length ; i++){
            curr_Sum += nums[i] - nums[i-k];
            max_Sum = Math.max(curr_Sum,max_Sum);
        }
        return (double) max_Sum / k;
    }
}