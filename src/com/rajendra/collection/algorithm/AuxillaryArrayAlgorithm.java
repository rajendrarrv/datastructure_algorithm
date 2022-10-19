package com.rajendra.collection.algorithm;

import com.rajendra.utils.ArraysUtils;

/**
 * Created by Rajendra Verma on 25/09/22.
 */
public class AuxillaryArrayAlgorithm {
    private ArraysUtils util = new ArraysUtils();

    public void simpleApproach(int unsortedArray[], int indexArray[]) {
        int auxillaryArray[] = new int[unsortedArray.length];

        for (int i = 0; i < unsortedArray.length; i++) {

            auxillaryArray[indexArray[i]] = unsortedArray[i];
        }
        util.printArray(unsortedArray);
        for (int i = 0; i < unsortedArray.length; i++) {
            unsortedArray[i] = auxillaryArray[i];

        }
        util.printArray(unsortedArray);
        util.printArray(indexArray);

    }

    public void algorithmApproach(int unsortedArray[], int indexArray[]) {
        util.printArray(unsortedArray);
        // Fix all elements one by one
        for (int i = 0; i < unsortedArray.length; i++) {
            // While index[i] and arr[i] are not fixed
            while (indexArray[i] != i) {
                // Store values of the target (or correct)
                // position before placing arr[i] there
                int oldTargetI = indexArray[indexArray[i]];
                char oldTargetE = (char) unsortedArray[indexArray[i]];

                // Place arr[i] at its target (or correct)
                // position. Also copy corrected index for
                // new position
                unsortedArray[indexArray[i]] = unsortedArray[i];
                indexArray[indexArray[i]] = indexArray[i];

                // Copy old target values to arr[i] and
                // index[i]
                indexArray[i] = oldTargetI;
                unsortedArray[i] = oldTargetE;
            }
        }
        util.printArray(unsortedArray);
        util.printArray(indexArray);
    }


//    121. Best Time to Buy and Sell Stock



}

