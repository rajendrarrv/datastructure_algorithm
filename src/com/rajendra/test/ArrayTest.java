package com.rajendra.test;

import com.rajendra.collection.Array;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayTest {
    Array array =null;

    @Before
    public  void  before(){
        array  = new Array();
    }

    @Test

    public void  test_1(){
        int in[] = {1,7,3,6,5,6};
        array.setAnInt(in);
       int result = array.findPivot();

       int ans  = 3 ;
        Assert.assertEquals(result, ans);

    }
}
