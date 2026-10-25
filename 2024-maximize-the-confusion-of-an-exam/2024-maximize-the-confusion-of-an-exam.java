class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(Helper(answerKey, k, 'T'), Helper(answerKey, k, 'F'));
    }
    public int Helper(String answerKey, int k,char target) {
        int left = 0;
        int maxLen = 0;
        int flip = 0;
        for(int right = 0; right < answerKey.length();right++){
            if(answerKey.charAt(right) != target){
                flip++;
            }
            while(flip > k){
                if(answerKey.charAt(left) != target){
                    flip--;
                }
                left++;
            }
            maxLen = Math.max(maxLen,right - left +1);
        }
        return maxLen;
    }
}