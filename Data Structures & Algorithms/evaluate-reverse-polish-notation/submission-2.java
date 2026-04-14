class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack<>();
       

        for(String s : tokens){

            if("+-*/".contains(s)){
                
                int num2 = stack.pop();
                int num1 = stack.pop();

                int result = 0;

                switch(s){
                    case "+" : result = num1 + num2;
                    break;
                    case "-" : result = num1 - num2;
                    break;
                    case "*" : result = num1 * num2;
                    break;
                    case "/" : result = num1 / num2;
                    break;
                }

                stack.push(result);
               
            }else{
                
                int num = Integer.parseInt(s);
                stack.push(num);
            }
            
        }

        return stack.pop();
    }
}
