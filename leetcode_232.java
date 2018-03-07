// Leetcode_232
// Implement Queue using Stack

class MyQueue {
    
    Stack<Integer> stk1, stk2;

    /** Initialize your data structure here. */
    public MyQueue() {
        stk1 = new Stack<>();
        stk2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stk1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!stk2.empty())
            return stk2.pop(); 
        
        while(!stk1.empty())
            stk2.push(stk1.pop());
        return stk2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(!stk2.empty())
            return stk2.peek(); 
        
        while(!stk1.empty())
            stk2.push(stk1.pop());
        
        return stk2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stk1.empty() && stk2.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */