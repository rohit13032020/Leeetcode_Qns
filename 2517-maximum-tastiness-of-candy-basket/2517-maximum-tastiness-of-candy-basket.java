class Solution {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);

        int low = 0;
        int high = price[price.length - 1] - price[0];
        int ans = 0;

        while(low <= high) {
          int mid = low + (high - low) / 2;

          if(helper(price,k,mid)) {
             ans = mid;
             low = mid + 1;
          } else {
            high = mid -1;
          }
        }
        return ans;
    }
    private boolean helper(int[] prices,int k,int mindiff) {
        int count = 1;
        int lastprice = prices[0];
        
        for(int price : prices) {
           if(price - lastprice >= mindiff) {
            count++;
            lastprice = price;

            if(count == k) {
                return true;
            }
           }
        }
        return false;

    }
}