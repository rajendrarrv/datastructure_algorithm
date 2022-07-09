package string;

public class ReverseeachWord {
    public StringBuilder solution(String s){
        StringBuilder ans = new StringBuilder();
        int i=0;
        while (i<s.length()){
            while (i<s.length() && s.charAt(i)==' ' ){
                i++;
            }
            int j=i;
            if(i>s.length()){
                break;
            }
            while (i<s.length() && s.charAt(i)!=' ' ){
                i++;
            }

                for(int sa=i-1;sa>=j;sa--) {
                   ans.append(s.charAt(sa));
                }
                ans.append(" ");


        }
        return ans;
    }
}
