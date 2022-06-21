package ninja;

public class SumOfEvenAndOdd {

    public  void  sum(int num){
        int number  =num;
        int even = 0,odd=0;
        while (number>0){
            int d  = number%10;
            number  = number/10;
            if (d%2==0){
                even  =even+d;
            }           else {
                odd =odd+d;
            }
                  }

        String result = String.format("event =%d,odd=%d",even,odd);
        System.out.print(result);

    }


}
