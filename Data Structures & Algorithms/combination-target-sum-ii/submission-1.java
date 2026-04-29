class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(0,candidates,new ArrayList<>(),result,target);

        return result;
    }

    void backtrack(int index , int[] nums, List<Integer> temp, List<List<Integer>> res, int target){

        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }

        if(target < 0) return;

        for(int i = index ; i < nums.length ; i++){

            if(i > index && nums[i] == nums[i-1]) continue;

            if(nums[i] > target) break;
            temp.add(nums[i]);
            backtrack(i+1,nums,temp,res,target - nums[i]);
            temp.remove(temp.size()-1);
        }
    }
}
