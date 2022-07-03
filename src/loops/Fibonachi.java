package loops;

public class Fibonachi {
    public static void main(String[] args) {
     int i=0;
     int j=1;
     int fib = 0;
        System.out.println(i);

    for(int f=0;f<4-1;f++){
         fib=i+j;
         i=j;
         j=fib;
         System.out.println(fib);
        }
    }
}
