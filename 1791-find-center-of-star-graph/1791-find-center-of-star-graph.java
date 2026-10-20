class Solution {
    public int findCenter(int[][] edges) {
        // Extract the first two edge pairs
        int[] pair1 = edges[0];
        int[] pair2 = edges[1];

        // Check if the first node of pair1 exists in pair2
        if (pair1[0] == pair2[0] || pair1[0] == pair2[1]) {
            return pair1[0];
        }

        // If not, then the second node of pair1 must be the center
        return pair1[1];
    }
}