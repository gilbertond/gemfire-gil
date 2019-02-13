package algorithms;

import java.util.*;

public class ClosestPalindrom {
    public static void main(String[] a){
        Scanner scanner = new Scanner(System.in);
        System.out.println(getPalindrome(scanner.nextInt()));
        Integer.toUnsignedString(300);
        
    }

    static int getPalindrome(int val){
        if(val < 1 || val > Math.pow(10, 14)) return 0;

        if(isPalindrom(val)) return val;

        int pal = 0;

        int left = val - 1;
        int right = val + 1;

        if(left == right && isPalindrom(left) && isPalindrom(right)) return left;

        if(isPalindrom(left)) return left;
        if(isPalindrom(right))return right;


        boolean isLeftPal = isPalindrom(left);
        while (!isLeftPal)  {
            return getPalindrome(left);
        }

        while (!isPalindrom(right))  {
            return getPalindrome(right);
        }

        return pal;
    }

    static boolean isPalindrom(int val){

        String number = String.valueOf(val);

        for (int i=0; i<number.length(); i++){

            if (number.charAt(i) != number.charAt(number.length()-1-i))   return false;
        }
        return true;
    }
}
