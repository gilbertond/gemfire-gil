package algorithms;

public class HexadecimalConsecutive {
    public static void main(String[] a){

        System.out.println(checkIfConcecutive("10001000", "10001001"));
    }

    static int checkIfConcecutive(String val1, String val2){
        return (Integer.parseInt(val1, 10)+1) == Integer.parseInt(val2, 10)?1:-1;
    }
}
