class Solution {
    public boolean hasDuplicate(int[] nums) {
        

        Map<Integer, Integer> map = new HashMap<>();

        for(int n : nums){
            map.put(n , map.getOrDefault(n , 0) + 1);
        }

        for(Map.Entry<Integer, Integer> m : map.entrySet()){
            if(m.getValue() > 1){
                return true;
            }
        }

        return false;
        
    }
}