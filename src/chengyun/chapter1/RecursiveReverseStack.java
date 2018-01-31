package chengyun.chapter1;

import java.util.Stack;

/**
 * description：将一个栈逆序，不能借助任何数据结构，只能借助递归。
 * require：只能借助递归，不能使用其他数据结构。
 * idea：使用两个递归函数，借助递归的栈来回溯数据。需要深刻理解递归的底层实现。
 * level：2
 */
public class RecursiveReverseStack {

    public void reverse(Stack<Integer> stack) {
        if (stack == null || stack.empty()) {
            return ;
        }
        Integer last = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(last);
    }

    public Integer getAndRemoveLastElement(Stack<Integer> stack) {
        Integer value = stack.pop();
        if (stack.empty()) {
            return value;
        }
        Integer last = getAndRemoveLastElement(stack);
        stack.push(value);
        return last;
    }

}
