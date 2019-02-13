package algorithms;

public class CompressedString {
    public static void main(String[]args){
        String s1 = "aabbcccccaa";
        System.out.println(getCompressed(s1));
    }

    static String getCompressed(String s){
        StringBuffer buffer = new StringBuffer();
        int count = 1;

        for (int index = 1; index < s.length(); index++){
            if (s.charAt(index) == s.charAt(index-1)) {
                count++;
            }else {
                 buffer.append(String.valueOf(s.charAt(index-1)));
                 if (count > 1) buffer.append(count);

                 count = 1;
            }

            if (index == s.length() -1) {
                buffer.append(String.valueOf(s.charAt(index-1)));
                if (count > 1) buffer.append(count);
            }
        }

        return buffer.toString().length() < s.length()? buffer.toString(): s;
    }
}
