class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int[] res = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < temperatures.length ; i++){

            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int idx = stack.pop();
                res[idx] = i - idx;
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            res[stack.pop()] = 0;
        }

        return res;
        //s = [5,6]
        //res[1,4 ,1,2 , 1]
    }
}
