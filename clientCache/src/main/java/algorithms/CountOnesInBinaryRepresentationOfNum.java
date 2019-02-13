package algorithms;

public class CountOnesInBinaryRepresentationOfNum {
    static int COUNT = 0;

    public static void main(String[] a) {
        System.out.println(countSetBits(117));
        System.out.println(countOnes(117));
    }

    static int countSetBits(int number) {
        if (number == 0)
            return 0;
        else
            return 1 + countSetBits(number & (number - 1));
    }

    // not working.....
    static int countOnes(int number) {

        if(number==0) return 0;
        if (number==1) return 1;

        int mod = number % 2;
        int div = number / 2;

        COUNT += mod;

        if (div == 1) {
            return COUNT + div;
        } else if (div > 1) {
//            COUNT+=1;
            countOnes(div);
        }
        return COUNT+1;
    }
}
