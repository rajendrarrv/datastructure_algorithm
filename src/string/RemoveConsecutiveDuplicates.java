package string;

public class RemoveConsecutiveDuplicates {
    public StringBuilder solution(String s){
        StringBuilder str = new StringBuilder();
        if(s.length()<=1){
            System.out.print(s.charAt(s.length()-1));
        }
int i=0;
          while (i<s.length()-1){
              if(s.charAt(i)!=s.charAt(i+1)){
                  str.append(s.charAt(i));
              }
              i++;
          }
        str.append(s.charAt(s.length()-1));
        return str;
    }

}
