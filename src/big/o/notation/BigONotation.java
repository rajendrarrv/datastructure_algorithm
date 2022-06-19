package big.o.notation;

public class BigONotation {
    /*
     *
     * Linear Time algorithm
     * */
    public void linearTimeAlgorithm(int n) {

        for (int i = 0; i < n; i++) {
            System.out.println("Hey - I'm busy looking at: " + i);
            System.out.println("Hmm.. Let's have another look at: " + i);
            System.out.println("And another: " + i);
        }
    }

    /*
     *Log N Time Algorithms – ( log n)
     * */

    public void logNAlgorithms(int n, int base) {
        for (int i = 1; i <= n; i = i + base) {
            System.out.println("Hey - I'm busy looking at: " + i + "");

        }

    }
    /*
     N Log N Time Algorithms – O(n log n)
     */

    public  void nLogNTimeAlgorithm(int n, int base){
        for (int i = 1; i <= n; i++){
            for(int j = 1; j < n; j = j * base) {
                System.out.println("Hey - I'm busy looking at: " + i + " and " + j);
            }
        }

    }

/*
7. Polynomial Time Algorithms – O(np)

 */

    public  void  polynomialTimeAlgorithm(int n){
        for (int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                System.out.println("Hey - I'm busy looking at: " + i + " and " + j);
            }
        }

    }

    /*
    * Exponential time algorithm
    * */

    public  void exponentialTimeAlgorithm(int n){

        for (int i = 1; i <= Math.pow(2, n); i++){
            System.out.println("Hey - I'm busy looking at: " + i);
        }
    }

    /*
    * Factorial Time algorithm
    * */
    

}
