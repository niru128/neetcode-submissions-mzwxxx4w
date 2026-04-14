class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {

        stack.push(val);

        if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }
        
    }
    
    public void pop() {

        if( !stack.isEmpty() && !minStack.isEmpty() && minStack.peek().equals(stack.peek())){
            minStack.pop();
        }

        stack.pop();
        
    }
    
    public int top() {

        return stack.peek();
        
    }
    
    public int getMin() {

        if(minStack.isEmpty()){
            return 0;
        }
        return minStack.peek();
    }
}
