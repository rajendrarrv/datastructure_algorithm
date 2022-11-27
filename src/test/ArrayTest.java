package test;

import com.rajendra.Array;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ArrayTest {
Array array ;

    @Before
    public  void  before(){
        array  = new Array(new int[]{1,7,3,6,5,6});
    }
    @Test
    public  void  pivot_test_1(){
        int ans = 3;
        int result  = array.findPivot();
        assertTrue(result == ans);



    }
}
