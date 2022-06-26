package ninja.la;

/**
 * Created by Rajendra Verma on 26/06/22.
 */
public class TermOfApp {
    public  void solution(int num ){

        for (int i = 1; i <= num; i++) {

            int res = 3*i+2;
            if (res%4!=0)
                System.out.println(res);
        }
    }
}
