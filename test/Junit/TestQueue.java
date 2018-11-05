package Junit;

import dataStruct.queue.LinkedListQueue;
import org.junit.Test;

/**
 * @author : Administrator
 * @create 2018-11-01 21:59
 */
public class TestQueue {


    @Test
    public void testqueue() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }


}
