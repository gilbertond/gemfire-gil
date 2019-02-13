package algorithms;

public class PrintArraysIntersection {
    public static void main(String [] arr){
        int[] a = {13,27,35,40,49,55,59};
        int[] b = {17,35,39,40,55,58,60};

        findIntersection(a, b);
    }

    static void findIntersection(int[]a, int[] b){
        int j=0,k=0;

        for (int i =0; i<a.length; i++){

            if ((k < a.length && j < a.length) && a[j] == b[k]) {
                System.out.println(a[j]);
                j++;
                k++;
            }

            if ((k < a.length && j < a.length) && a[j] < b[k]) j++;
            if ((k < a.length && j < a.length) && a[j] > b[k]) k++;
        }
    }
}
