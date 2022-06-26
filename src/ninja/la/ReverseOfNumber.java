package ninja.la;

/**
 * Created by Rajendra Verma on 26/06/22.
 */
public class ReverseOfNumber {
public  void  reverseOfNumber(int num){
    int result =0;
    while (num>0){

        int remainder  = num%10;
        result  = result*10 +remainder;
        num  = num/10;



    }
    System.out.println(result);


}
}
