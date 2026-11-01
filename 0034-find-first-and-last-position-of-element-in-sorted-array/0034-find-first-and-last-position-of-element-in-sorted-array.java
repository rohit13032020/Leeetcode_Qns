class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findfirst(nums,target);

        if(first == -1){
            return new int[]{-1,-1};
        }
        int last = findlast(nums,target);
            return new int[]{first,last};
        
    }
    private int findlast(int[] nums, int target){
       int high = nums.length-1;
       int low = 0;
       int result=-1;

       while(low <= high){
        int mid = low + (high - low) / 2;
        if(nums[mid]==target) {
            result = mid;
            low = mid+1;
        } else if(nums[mid]<target){
            low = mid +1;
        } else {
            high = mid - 1;
        }
       }
        return result;
       
    }
    private int findfirst(int[] nums, int target){
    
    int low = 0;
    int high = nums.length-1;
    int result = -1;

    while(low <= high){
        int mid = low + (high - low) / 2;

        if(nums[mid] == target){
            result = mid;
            high = mid -1;
        } else if(nums[mid] < target){
            low = mid +1;
        } else {
            high = mid - 1;
        }
    }
    return result;
    
    }
}