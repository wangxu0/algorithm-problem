package chengyun.chapter1;

import java.util.Stack;

/**
 * description:设计一个带有getMin功能的栈，实现一个栈，具有push,pop,getMin操作，getMin为返回当前最小值。
 * require：所有操作的时间复杂度o(1)，空间复杂度O(n)。
 * idea：维护两个栈，一个保存原始数据，一个保存当前最小值。
 * level：1
 */
public class MinStack {

    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public MinStack() {
        this.dataStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(Integer num) {
        this.dataStack.push(num);
        if (this.minStack.empty() || num <= this.getMin()) {
            this.minStack.push(num);
        }
    }

    public Integer pop() {
        if (this.dataStack.empty()) {
            throw new RuntimeException("Stack is empty, can not pop value.");
        }
        int value = this.dataStack.pop();
        if (value == this.minStack.peek()) {
            this.minStack.pop();
        }
        return value;
    }

    public Integer getMin() {
        if (this.minStack.empty()) {
            throw new RuntimeException("Stack is empty, can not get min value.");
        }
        return this.minStack.peek();
    }
}
