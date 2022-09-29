package test;

import com.rajendra.collection.algorithm.AuxillaryArrayAlgorithm;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Rajendra Verma on 25/09/22.
 */
public class AuxillaryArrayAlgorithmTest implements VTest {
    private AuxillaryArrayAlgorithm auxillaryArrayAlgorithm;

    @Before
    @Override
    public void before() {
        auxillaryArrayAlgorithm = new AuxillaryArrayAlgorithm();
    }

    @Test
    @Override
    public void test() {
        System.out.println("Simple Approach");
        int[] input = new int[]{10, 11, 12};
        int[] index = new int[]{1, 0, 2};

        auxillaryArrayAlgorithm.simpleApproach(input, index);
    }
    @Test
    public void test1(){
        int[] input = new int[]{50, 40, 70, 60, 90};
        int[] index = new int[]{3,  0,  4,  1,  2};

        auxillaryArrayAlgorithm.simpleApproach(input, index);

    }
    @Test
    public void algo(){
        System.out.println("Algo Approach");
        int[] input = new int[]{10, 11, 12};
        int[] index = new int[]{1, 0, 2};

        auxillaryArrayAlgorithm.algorithmApproach(input, index);
    }
    @Test
    public void algo1(){
        int[] input = new int[]{50, 40, 70, 60, 90};
        int[] index = new int[]{3,  0,  4,  1,  2};

        auxillaryArrayAlgorithm.algorithmApproach(input, index);
    }



    @Override
    public void after() {

    }
}
