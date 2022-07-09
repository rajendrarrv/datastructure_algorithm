package string;

public class Palindrome {
    public static void main(String[] args) {
        String str = "abcddcbal";
        int s=0;
        int e= str.length()-1;
        boolean palin=false;
        while (s<e){
            if(str.charAt(s)!=str.charAt(e)){
                System.out.println("not");
                palin=true;
                return;
            }
            s++;
            e--;

        }
        if(!palin){
            System.out.println("palindrome");
        }
    }
}
