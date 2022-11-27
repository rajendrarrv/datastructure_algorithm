package test;

import com.rajendra.collection.algorithm.KadaneAlgorithm;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Rajendra Verma on 25/09/22.
 */
public class KadaneAlgoTest implements VTest {
    KadaneAlgorithm algorithm;
@Before
    @Override
    public void before() {
    algorithm  = new KadaneAlgorithm();
    }
@Test
    @Override
    public void test() {
    algorithm.simpleApproach(new int[]{-2,3,-1,2});
    }

    @Test
    public void kadaneApproach(){
    algorithm.kadaneApproach(new int[]{-2,3,-1,2});
    }

    @Override
    public void after() {

    }
}
