package chengyun.chapter1;

import java.util.Stack;

/**
 * description：设计一个类，使用两个栈结构实现一个队列，包含基本操作add,poll,peek。
 * require：时间复杂度add:O(1);poll,peek:O(n)，空间复杂度O(n)。
 * idea：使用两个栈，一个负责入队列操作，出队时把数据移动到另一个栈，弹出最后一个元素，依次类推。
 * level：2
 */
public class TowStackQueue {

    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    public TowStackQueue() {
        this.pushStack = new Stack<>();
        this.popStack = new Stack<>();
    }

    public void add(Integer num) {
        this.pushStack.push(num);
    }

    public Integer poll() {
        if (this.popStack.empty() && this.pushStack.empty()) {
            throw new RuntimeException("Queue is empty, can not poll value.");
        }
        if (this.popStack.empty()) {
            while (!this.pushStack.empty()) {
                this.popStack.push(this.pushStack.pop());
            }
        }
        return this.popStack.pop();
    }

    public Integer peek() {
        if (this.popStack.empty() && this.pushStack.empty()) {
            throw new RuntimeException("Queue is empty, can not peek value.");
        }
        if (this.popStack.empty()) {
            while (!this.pushStack.empty()) {
                this.popStack.push(this.pushStack.pop());
            }
        }
        return this.popStack.peek();
    }
}
