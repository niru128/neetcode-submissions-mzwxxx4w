class Solution {
    public int maxArea(int[] nums) {

        int max = 0;
        int i = 0;
        int j = nums.length-1;
        int areaOfWater = 1;
        while(i <= j) {
            if(nums[i] < nums[j]){
                areaOfWater = area(nums[i] , j - i);
                i++;
            }else{
                areaOfWater = area(nums[j] , j-i);
                j--;
            }

            if(areaOfWater > max){
                max = areaOfWater;
            }
        }
        return max;
        
    }
    int area(int i , int j){
        return i*j;
    }
}
