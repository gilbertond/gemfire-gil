package algorithms;

public class NonRepeatingCharacter {
    public static void main(String[] args){

        String someString = "GeeksQuizG";

        System.out.println(getFirstNonRepeatingChar(someString));
    }


     static char getFirstNonRepeatingChar(String someString){
        int[] chars = new int[256];

        int offset = (int) 'a';
        int offsetCaps = (int) 'A';

        for (int i =0; i<someString.length(); i++){
            int index =  Character.isUpperCase(someString.charAt(i))? someString.charAt(i)-offsetCaps : someString.charAt(i) - offset;

            System.out.println((int) someString.charAt(i) + "-"+ index);
            chars[index]++;
        }

        for (int j=0; j< someString.length(); j++){
            int index =  Character.isUpperCase(someString.charAt(j))? someString.charAt(j)-offsetCaps : someString.charAt(j) - offset;
            if (chars[index] == 1) return someString.charAt(j);
        }

        return ' ';
     }
}
