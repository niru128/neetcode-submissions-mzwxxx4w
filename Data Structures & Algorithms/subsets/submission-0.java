class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0,nums,new ArrayList<>(),result);

        return result;
    }

    void backtrack(int index, int[] nums, List<Integer> temp , List<List<Integer>> res ){

        res.add(new ArrayList<>(temp));

        for(int i = index ; i < nums.length ; i++){
            temp.add(nums[i]);
            backtrack(i+1,nums,temp,res);
            temp.remove(temp.size()-1);

        }

    }
}
