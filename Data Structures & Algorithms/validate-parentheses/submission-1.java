class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();

        for(int i = 0 ; i < s.length() ; i++){

            char c = s.charAt(i);

            if(c ==  '(' || c == '{' || c =='['){
                stack.push(c);
            }else{
                if(!stack.isEmpty()){
                    char t = stack.pop();

                    if(!valid(t,c)){
                        return false;
                    }
                }else{
                    stack.push(c);
                }
            }


        }

        return stack.isEmpty();
    }

    boolean valid(char a, char b){

        return ((a == '(' && b == ')') || (a == '{' && b=='}') || (a == '[' && b == ']'));
    }
}
