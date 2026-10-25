class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <=1 ) return 0;
        int product = 1;
        int left = 0;
        int count = 0;

        for(int right = 0; right < nums.length;right++){
            //add right element
            product *= nums[right];

            while(product >= k){
                //remove left elemet
                product /= nums[left];
                left++;
            }
            count = count + right - left + 1;
        }
        return count;
    }
}