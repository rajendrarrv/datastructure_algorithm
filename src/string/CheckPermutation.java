package string;

public class CheckPermutation {
    public boolean solution(String s,String t){
        if(s.length()!=t.length()){
            return false;
        }
        boolean ans=false;
        for(int i=0;i<s.length();i++){
           ans=false;
            for(int j=0;j<t.length();j++){
                if(s.charAt(i)==t.charAt(j)) {
                    ans=true;
                    break;
                }


                }
            if(ans==false){
                return false;
            }
            }
       return ans;
        }
    }

