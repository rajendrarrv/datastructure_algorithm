package test;

import com.rajendra.collection.LinkedListImpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Rajendra Verma on 21/09/22.
 */
public class LinkListTest {
    private LinkedListImpl linkedList ;

    @Before
    public  void  before(){
        System.out.println("Before");
//        linkedList = new LinkedListImpl();
    }
    @After
    public  void  after(){
        System.out.println("After");
        linkedList.display();

    }

    @Test
    public  void  test(){
        System.out.println("Test");
        linkedList.insertLast(1);
        linkedList.insertLast(2);
        linkedList.insertLast(3);
        linkedList.insertLast(4);
    }
}
