package Functions;

public class Scoping {
    public static void main(String[] args) {
        int a=10;
        System.out.println( increment(a));
        System.out.println(a);
    }

    private static int increment(int a) {
     return    a=a+1;

    }
}
