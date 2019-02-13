package algorithms;

public class AplhanumericStringIsPalindrome {
    public static void main(String[] a){
        System.out.println(isPalindrome("I am :IronnorI Ma, i".toLowerCase()));
    }

    static String isPalindrome(String s){
        int j = s.length()-1;

        for (int i=0; i<s.length(); i++){
            if(j==i) return "YES";

            Character current = s.charAt(i);
            Character last = s.charAt(j);

            if (!Character.isLetterOrDigit(last)) {
               j--;
                last = s.charAt(j);
            }

            if (!Character.isLetterOrDigit(current)) {
                continue;
            }

            if(!last.equals(current)) return "NO";

            j--;
        }

        return "YES";
    }
}
