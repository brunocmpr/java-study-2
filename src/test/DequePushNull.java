package test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class DequePushNull {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(null);

        Deque<Integer> deque = new LinkedList<>();
        deque.push(null);
    }
}
