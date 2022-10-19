package test;

import com.rajendra.collection.queue.VCircularQueue;
import com.rajendra.collection.queue.VLinearQueue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Rajendra Verma on 25/09/22.
 */
public class QueueTestCase {
    VLinearQueue queue;
    VCircularQueue circularQueue;

    @Before
    public void before() {
        circularQueue = new VCircularQueue(5);
        queue = new VLinearQueue(5);
    }

    @Test
    public void test() {
        queue.enqueue(1);
        System.out.println("Size " + queue.size());
        queue.enqueue(2);
        System.out.println("Size " + queue.size());

        queue.enqueue(3);
        System.out.println("Size " + queue.size());

        queue.enqueue(4);
        System.out.println("Size " + queue.size());

        queue.enqueue(5);
        System.out.println("Size " + queue.size());
        queue.dequeue();
        System.out.println("Size " + queue.size());

        queue.dequeue();
        System.out.println("Size " + queue.size());
        queue.dequeue();
        System.out.println("Size " + queue.size());
        queue.dequeue();
        System.out.println("Size " + queue.size());
        queue.dequeue();
        System.out.println("Size " + queue.size());
        queue.dequeue();
        System.out.println("Size " + queue.size());


    }

    @Test
    public void circularQueueTest() {
        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        circularQueue.enqueue(3);
        circularQueue.enqueue(4);
        circularQueue.enqueue(5);
        circularQueue.enqueue(6);
        circularQueue.dequeue();
        circularQueue.dequeue();
        circularQueue.dequeue();
        circularQueue.dequeue();
        circularQueue.dequeue();
        circularQueue.dequeue();
    }
}
