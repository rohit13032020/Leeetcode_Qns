import java.util.Arrays;

class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int windowSize = 2 * k + 1;
        
        int[] res = new int[n];
        Arrays.fill(res, -1);
        
        // If window size is greater than the array length, return default res filled with -1
        if (windowSize > n) {
            return res;
        }
        
        long windowSum = 0;
        
        // Build the first sliding window
        for (int i = 0; i < windowSize; i++) {
            windowSum += nums[i];
        }
        
        // Assign the average to the first valid pivot center (at index k)
        int pivotIndex = k;
        res[pivotIndex] = (int) (windowSum / windowSize);
        
        // Slide the window across the remaining array
        for (int i = windowSize; i < n; i++) {
            // Subtract the element leaving the window and add the new element entering
            windowSum -= nums[i - windowSize];
            windowSum += nums[i];
            
            pivotIndex++;
            res[pivotIndex] = (int) (windowSum / windowSize);
        }
        
        return res;
    }
}