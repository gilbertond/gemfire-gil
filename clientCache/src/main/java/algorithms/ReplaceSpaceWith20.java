package algorithms;

public class ReplaceSpaceWith20 {
    public static void main(String[] a){
        String s = "hello gilbert   sir "  ;
        
        System.out.println(replaceSpace(s));
    }

    static String replaceSpace(String s){
        StringBuffer buffer = new StringBuffer();

        for (int i=0; i< s.length(); i++){
            if(Character.isWhitespace(s.charAt(i))){
                buffer.append("%20");
            }                        else{
                buffer.append(s.charAt(i));
            }
        }
        return buffer.toString();
    }
}
