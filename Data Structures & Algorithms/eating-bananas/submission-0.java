class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        Arrays.sort(piles);
        int low = 1;
        int high = piles[piles.length-1];


        while(low <= high){
            int mid = low + (high - low)/2;

            int hour = 0;
            for(int n : piles){
                hour+=(n + mid - 1)/mid;
            }

            if(hour <= h){
                high = mid-1;
            }else{
                low = mid+1;
            }

        }return low;
    }
}
