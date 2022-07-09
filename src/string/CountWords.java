package string;

public class CountWords {
    public static void main(String[] args) {
        String str = "coding is awesome yh fd";
        int count=0;

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)== ' '){
                count++;
            }
        }
        System.out.println(count+1);
    }
}
