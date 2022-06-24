package ninja.cl;

public class CharacterCase {
    public void checkCharacter(char c) {

        if (c >= 'a' || c < 'z') {

            System.out.print("Character is lower case[0]");
        } else if (c >= 'A' || c <= 'Z') {

            System.out.print("Character is upper  case[1]");
        } else {
            System.out.print("Character is  either symbol or digit");
        }


    }
}
