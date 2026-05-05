class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s,0,new ArrayList<>(),res);
        return res;
    }

    void backtrack(String s, int index, List<String> temp, List<List<String>> res){

        if(index == s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = index ; i < s.length(); i++){
            if(palindrome(s,index,i)){
                temp.add(s.substring(index,i+1));
                backtrack(s,i+1,temp,res);
                temp.remove(temp.size()-1);
            }
        }
    }

    boolean palindrome(String s, int start,int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}
