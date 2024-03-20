package dataStructure;

import java.util.Stack;

public class PlainStack {
    
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.pop();
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.pop();
        stack.push(9);
        stack.push(10);

        for(int a : stack) {
            System.out.println(a);
        }

        // 맨 위의 요소만 뽑아내는 것
        System.out.println(stack.peek());
        System.out.println(stack.peek());

        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
