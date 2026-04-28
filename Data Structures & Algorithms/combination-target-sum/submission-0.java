class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0,nums,new ArrayList<>(),result,target);
        return result;
    }

    void backtrack(int index , int[] nums, List<Integer> temp, List<List<Integer>> res,int target){

        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }

        if(target < 0){
            return;
        }

        for(int i = index ; i< nums.length ; i++){
            temp.add(nums[i]);
            backtrack(i,nums,temp,res,target - nums[i]);
            temp.remove(temp.size()-1);
        }
    }
}
