package dataStruct.heap.PriorityQueueHeap;

import edu.princeton.cs.algs4.*;

/**
 * @author : Administrator
 * @create 2019-01-06 22:32
 */
public class ToM {
    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]);
        MinPQ<Transaction> pq = new MinPQ<>(M + 1);
        while (StdIn.hasNextLine()) {
            pq.insert(new Transaction(StdIn.readLine()));
            if (pq.size() > M) {
                pq.delMin();
            }
            Stack<Transaction> stack = new Stack<>();
            while (!pq.isEmpty()) stack.push(pq.delMin());
            for (Transaction t : stack) {
                StdOut.println(t);
            }
        }
    }
}
