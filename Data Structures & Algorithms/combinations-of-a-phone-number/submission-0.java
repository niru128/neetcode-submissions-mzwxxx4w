class Solution {
    public List<String> letterCombinations(String digits) {
        String[] map = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        List<String> res = new ArrayList<>();
        if(digits == "" || digits.length() == 0) return res;

        backtrack(new StringBuilder(),0,res,digits,map);
        return res;
    }

    void backtrack( StringBuilder sb, int index , List<String> res,String digits, String[] map){

        if(sb.length() == digits.length() ){
            res.add(sb.toString());
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for(char c : letters.toCharArray()){
            sb.append(c);
            backtrack(sb,index+1,res,digits,map);
            sb.deleteCharAt(sb.length()-1);

        }
    }
}
