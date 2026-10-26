class Solution {
    public int minimumCardPickup(int[] cards) {
        int[] lastSeen = new int[1000001];
        Arrays.fill(lastSeen,-1);
        int res = Integer.MAX_VALUE;
        for(int right = 0 ; right < cards.length;right++){
            int card = cards[right];

            if(lastSeen[card] != -1){
                res = Math.min(res,right-lastSeen[card]+1);
            }
            lastSeen[card] = right; 
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}