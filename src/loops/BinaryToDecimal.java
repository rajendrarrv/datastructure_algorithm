package loops;

public class BinaryToDecimal {
    public static void main(String[] args) {
        int bin = 1100;
        int dec=0;
        int c=0;
        while(bin>0){
            int rem = bin%10;
            dec+=  ( rem* ( Math.pow(2,c)));
            c++;
            bin=bin/10;

        }
        System.out.println(dec);
    }
}
