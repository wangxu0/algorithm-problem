package chengyun.chapter1;

import java.util.Stack;

/**
 * description:给定一个栈，将栈从栈顶到栈低按充大到小的顺序排序，要求只能使用另外一个辅助栈。
 * require：只能使用一个辅助栈，不能使用其他数据结构。
 * idea：辅助栈用来排序，两个栈来回倒数据，始终把当前最大数放到辅助栈尽可能的下层。
 * level：1
 */
public class SortStack {

    public void sortStackByStack(Stack<Integer> stack) {
        if (stack == null)
            return;
        Stack<Integer> help = new Stack<>();
        while (!stack.empty()) {
            Integer cur = stack.pop();
            while (!help.empty() && cur > help.peek()) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.empty()) {
            stack.push(help.pop());
        }
    }

}
