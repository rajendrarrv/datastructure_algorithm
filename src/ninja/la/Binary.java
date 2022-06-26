package ninja.la;

/**
 * Created by Rajendra Verma on 26/06/22.
 */
public class Binary {

    public void binary(int num) {

        System.out.println(Integer.toBinaryString(num));
    }
    public  void  decimal(int num){

        int decimal=0 , i =0;
        while (num!=0){

            int remainder  = num%10;
            num = num/10;
            decimal  = (int) (decimal + remainder*Math.pow(2,i));
i++;
        }
        System.out.println(decimal);
    }

}
