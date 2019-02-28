package algorithms;

import java.util.HashSet;
import java.util.Set;

public class CombinationsOfSumsOfCoins {

    public static void main(String[] a){
        printSums(10,15,20);
    }

    public static void printSums(int c1, int c2, int c3) {

        Set sums = new HashSet<>();
        sums.add(0);

        for(int sum = 1; sum <= 1000; sum++) {

            if(sums.contains(sum - c1) || sums.contains(sum - c2) || sums.contains(sum - c3)) {
                System.out.println(sum);
                sums.add(sum);
            }
        }
    }
}
