package ninja.array;

/**
 * Created by Rajendra Verma on 02/07/22.
 */
public class SwapAlternate {
    public void solution(int arry[]) {
//        print the element of array
        int n = arry.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arry[i] + " ");
        }
//        updating the array
        int i = 0;
        int j = n - 1;
//        while there are elments to swap
        while (i < j) {
            int temp = arry[i];
            arry[i] = arry[j];
            arry[j] = temp;
//            update the pointers
            i += 2;
            j -= 2;
        }
        for (int k = 0; k < n; k++) {
            System.out.print("" + arry[k]);
        }

    }
}
