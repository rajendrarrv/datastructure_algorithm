package ninja.la;

public class SumOfProduct {
    public int sum(int num, int c) {
        int result = -1;
        for (int i = 1; i <= num; i++) {

            if (c == 1) {
                result = result + 1;
            } else if (c == 2) {
                result = result * i;
            } else {
                return -1;
            }

        }

        return result;
    }
}
