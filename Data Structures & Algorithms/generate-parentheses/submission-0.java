class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        backtrack("",0,0,result,n);

        return result;
    }

    void backtrack(String curr, int open,int close, List<String> result,int n){

        if(curr.length() == 2 * n ){
            result.add(curr);
            return;
        }

        if(open < n){
            backtrack(curr+"(" , open+1,close,result,n);
        }

        if(close < open){
            backtrack(curr+")",open, close+1,result,n);
        }
    }
}
