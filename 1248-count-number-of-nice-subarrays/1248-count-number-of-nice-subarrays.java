import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> prefixsum = new HashMap<>();
        prefixsum.put(0, 1);
        int curr_sum = 0;
        int count = 0;

        for (int num : nums) {
            curr_sum += (num % 2 != 0) ? 1 : 0;

            // Typo 1 fixed: containsKey
            if (prefixsum.containsKey(curr_sum - k)) {
                count += prefixsum.get(curr_sum - k);
            }
            // Typo 2 fixed: getOrDefault
            prefixsum.put(curr_sum, prefixsum.getOrDefault(curr_sum, 0) + 1);
        }
        return count;
    }
}