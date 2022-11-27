package test;

import com.rajendra.collection.queue.MyCircularQueue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Rajendra Verma on 25/09/22.
 */
public class LeetCodeTest {
    MyCircularQueue circularQueue;

    @Before
    public void before() {
        circularQueue = new MyCircularQueue(5);
    }

    @Test
    public void test() {

        circularQueue.enQueue(1);
        circularQueue.enQueue(2);
        circularQueue.enQueue(3);
        circularQueue.enQueue(4);
        circularQueue.enQueue(5);
        circularQueue.deQueue();
        circularQueue.deQueue();
        circularQueue.deQueue();
        circularQueue.deQueue();
        circularQueue.deQueue();
        circularQueue.deQueue();
    }
}
