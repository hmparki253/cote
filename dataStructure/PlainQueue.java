package dataStructure;

import java.util.LinkedList;
import java.util.Queue;

public class PlainQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5);
        q.poll();

        while(!q.isEmpty()) {
            System.out.println(q.peek());
            q.poll();
        }
    }
}
