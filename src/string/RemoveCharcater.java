package string;

public class RemoveCharcater {
    public StringBuilder solution(String s, char x){
        StringBuilder ans= new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==x){
                continue;
            }else{
                ans.append(s.charAt(i));
            }
        }
        return ans;
    }
}
