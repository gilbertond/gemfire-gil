package algorithms.snapsheet;

import java.util.Stack;

//"group = admin_user_user_group.user_group.as_json(include: { permissions: { only: [:id, :name, :code] } }, only: [:id, :name, :active])"

//test1 = "((((()}))))"
public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        
        System.out.println(stringValidator("()[]{}"));
    }
    
    static boolean stringValidator(String str){
        if(str == null || str.length()==0) return false;
        
        Stack<Character> found = new Stack<>();
        
        
        for(int i=0; i<str.length(); i++){
            char current = str.charAt(i);
            if(current=='(' || current == '{' || current == '['){
                found.push(current);
            }
            
            if(current==')'){
                if(found.isEmpty()) return false;
                
                char pop = found.pop();
                if(pop != '(') return false;
            }
            
            if(current=='}'){
                if(found.isEmpty()) return false;
                
                char pop = found.pop();
                if(pop != '{') return false;
            }
            
            if(current==']'){
                if(found.isEmpty()) return false;
                
                char pop = found.pop();
                if(pop != '[') return false;
            }
        }
        
        
        if(found.size() > 0) return false;
        
        return true;
    }
}