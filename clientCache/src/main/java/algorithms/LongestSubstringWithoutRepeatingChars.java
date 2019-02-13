package algorithms;

public class LongestSubstringWithoutRepeatingChars {
    public static void main(String[] args){
        String s = "abcdbcdefa";

        System.out.println(getLongestSubString(s));
    }

    static String getLongestSubString(String s){
        if(s==null || s.length()==0) throw new RuntimeException("Invalid String!!");

        if (s.length()==1) return s;
        String holder = "";
        int k = 0;

        for(int index=0; index<s.length(); index++){
            String left = s.substring(k, index);

            if(left.contains(String.valueOf(s.charAt(index)))){
                if (holder.length()<left.length()) holder=left;
                k=index;
                index=k;
            }

            if (holder.length() < s.substring(k, index+1).length()) holder = s.substring(k, index+1);
        }

//        System.out.println(holder);       
        return holder;
    }
}
