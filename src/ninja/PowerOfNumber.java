package ninja;

public class PowerOfNumber {
    public int powerOfNumber(int num, int pow) {
        int result = 1;
        for (int i = 0; i < pow; i++) {
            result = result * num;
        }
        return result;
    }

}
