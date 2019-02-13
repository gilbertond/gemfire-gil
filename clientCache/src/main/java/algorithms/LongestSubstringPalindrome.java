package algorithms;

public class LongestSubstringPalindrome {
    public static void main(String[] a) {

//        String value = "abqstabcdcbaffs";
        String value = "abqstabcddcbaffs";

        System.out.println(getLongestPalindrome(value));
    }

    static String getLongestPalindrome(String value) {

        //If empty string
        if (value.length() == 0) throw new IllegalArgumentException("String is empty!!");

        //If longer string. i.e. >=3 size
        if (value.length()<1) return value;

        int end=0,start=0;
        for(int i=0;i<value.length();i++){
            int Length1=ChkAround(value,i,i);
            int Length2=ChkAround(value,i,i+1);
            int Length=Math.max(Length1,Length2);
            if(Length>(end-start+1)){
                if(Length==Length1){
                    start=i-(Length/2);
                }else {
                    start=i-(Length/2)+1;
                }
                end=start+Length-1;
            }
        }
        return value.substring(start,end+1);
    }

    static int ChkAround(String s,int left,int right){
        int L=left;
        int R=right;
        int temp=0;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            temp=R - L + 1;
            L--;
            R++;
        }
        return temp;
    }
}
