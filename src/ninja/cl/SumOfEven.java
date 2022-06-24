package ninja.cl;

public class SumOfEven {
    public int sum(int num) {
        int evenSum = 0;
        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0) {
                evenSum = evenSum + i;
            }
        }
        return evenSum;
    }
}
