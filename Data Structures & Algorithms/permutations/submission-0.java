class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums,result,used,new ArrayList<>());

        return result;
    }

    void backtrack(int[] nums, List<List<Integer>> res, boolean[] used, List<Integer> temp){

        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0 ; i < nums.length ; i++){
            if(used[i]) continue;

            used[i] = true;
            temp.add(nums[i]);
            backtrack(nums,res,used,temp);
            temp.remove(temp.size()-1);
            used[i] = false;
        }
    }
}
