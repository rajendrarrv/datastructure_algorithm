package string;

public class CompressString {
    public StringBuilder solution(String s){
        StringBuilder ans= new StringBuilder();
        int i=0;
        int j=0;
        int count=0;
        while (i<s.length()){
            count=0;
            while (i<s.length() && s.charAt(i)==s.charAt(j)){
              count++;
                i++;

            }
            if(count==1){
                ans.append(s.charAt(j));
            }else {
                ans.append(s.charAt(j) + "" + count);
            }
            j=i;
        }
        return ans;
    }
}
