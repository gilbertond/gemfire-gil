package algorithms;

import java.util.Arrays;

public class ClassPassExam {
    public static void main(String[] args){
      int[] A = {0, 1, 2, 3, 4, 100000};

      System.out.println(solution(A));
    }

    static int solution(int[] A) {
        int ans = 0;

        if(A == null || A.length>1000) throw new IllegalArgumentException("invalid input");

        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {

            if(A[i] < -1000 || A[i] > 1000) throw new IllegalArgumentException("invalid input");
            ans += A[i];
        }
        return ans;
    }
}
