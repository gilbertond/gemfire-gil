package algorithms;

public class ReverseCstyleString {


    public static void main(String[] args){
         System.out.println(reverse("abcd"));
         System.out.println(reverse2("abcd"));
    }

    static String reverse(String s){
        if(s == null || s.length() == 0) throw new IllegalArgumentException("Invalid");

        StringBuffer buffer = new StringBuffer();

        for (int index = s.length()-1; index >= 0; index--){
            if ((Character)s.charAt(index) == null) continue;

            buffer.append(s.charAt(index));
        }

        return buffer.toString();
    }


    static String reverse2(String s){
        if(s == null || s.length() == 0) throw new IllegalArgumentException("Invalid");

        char[] res = new char[s.length()];

        int j=0;

        for (int index = s.length()-1; index >= 0; index--){
            if ((Character)s.charAt(index) == null) continue;

            char jChar = s.charAt(j);
            res[j] = s.charAt(index);
            res[index] = jChar;

            if(index < j) break;

            j++;
        }

        return String.valueOf(res);
    }
}
