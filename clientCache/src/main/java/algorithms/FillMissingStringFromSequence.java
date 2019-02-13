package algorithms;

public class FillMissingStringFromSequence {
    public static void main(String [] a){

        System.out.println(solveSequence("VTS: RPO : AYX: ____"));
    }

    static String solveSequence(String input){

        String[] values = input.split(":");

        for (int i=0; i<values.length-1; i++){
            System.out.println("---------------");
            System.out.println(values[i].trim());

            String value = values[i].trim();

            int sum = 0;
            for (int j=0; j<value.length(); j++){
                System.out.println(value.charAt(j)+'0');
                sum+= value.charAt(j)+'0';
            }

            System.out.println("Sum:"+sum);
        }

        return "";
    }
}
