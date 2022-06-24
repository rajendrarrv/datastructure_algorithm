package ninja.cl;

public class NumberOfPattern {
    public void triangle() {
        int num = 4;
        int increment = 1;
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" " + increment);
                increment++;
            }
            System.out.println();
        }

    }

    public void reverseTriangle() {
        int i, j;
        int n = 4;
        int  increment =1;

        // outer loop to handle number of rows
        //  n in this case
        for (i = 0; i < n; i++) {

            // inner loop to handle number spaces
            // values changing acc. to requirement
            for (j = 2 * (n - i); j >= 0; j--) {
                // printing spaces
                System.out.print(" ");
            }

            //  inner loop to handle number of columns
            //  values changing acc. to outer loop
            for (j = 0; j <= i; j++) {
                // printing stars
                System.out.print(" "+ increment);
                increment++;
            }

            // ending line after each row
            System.out.println();
        }
    }
}