package algorithms.expedia;

public class FourthBit {
    public static void main(String[] a){

          System.out.println("\n" +fourthBit(4));
    }

    static int fourthBit(int num){

        if (Math.pow(2, 31)-1 < num) return -1;
        if (-Math.pow(2, 31) > num) return -1;
        
        int bit=0;
        int count = 0;

        while (count < 4){
            bit = num%2;

            bit = num%2;
            count+=1;
            num /= 2;

            System.out.print(bit);
        }

        return bit;
    }
}
