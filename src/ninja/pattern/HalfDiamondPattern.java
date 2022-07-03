package ninja.pattern;

/**
 * Created by Rajendra Verma on 03/07/22.
 */
public class HalfDiamondPattern {
public  void  solution(){
    int n=5;

    for(int i=1;i<2*n;i++){
        int col;
        if(i>n){
            col=2*n-i;
        } else{
            col=i;
        }
        for(int j=1;j<=col;j++){
            System.out.print("  *");
        }
        System.out.println();
    }

    }
//        *
//        * *
//        * * *
//        * * * *
//        * * * * *
//        * * * *
//        * * *
//        * *
//        *
}

