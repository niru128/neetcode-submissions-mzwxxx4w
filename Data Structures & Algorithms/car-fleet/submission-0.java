class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] res = new double[n][2];

        for(int i = 0 ; i < n ; i++){
            res[i][0] = position[i];
            res[i][1] = (double)(target - position[i])/speed[i];
        }   

        Arrays.sort(res , (a,b)->Double.compare(b[0],a[0]));

        Stack<Double> stack = new Stack<>();
        for(int i = 0 ; i < res.length ; i++){
            double time = res[i][1];

            if(stack.isEmpty() || time > stack.peek()){
                stack.push(time);
            }
        }

        return stack.size();
    }
}
