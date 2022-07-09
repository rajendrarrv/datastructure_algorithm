package string;

public class HighestOccuringCharacter {
    public char solution(String s){
        char ch=' ';

        int largest=0;
         for(int i=0;i<s.length();i++){
             int count=0;
             char ch1= s.charAt(i);
             for(int j=0;j<s.length();j++){
                 if(ch1==s.charAt(j)){
                     count++;
                 }
             }
             if(count>largest){
                 largest=count;
                 ch=s.charAt(i);
             }
         }
        return ch;
    }
}
