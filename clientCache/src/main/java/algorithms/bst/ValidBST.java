package algorithms.bst;

import java.util.HashSet;
import java.util.Set;

public class ValidBST {
    public static void main(String[] a){

        Node leftRight = new Node(null, null, 3);
        Node leftLeft = new Node(null, null, 1);

        Node rightRight = new Node(null, null, 7);
        Node rightLeft = new Node(null, null, 5);

        Node left = new Node(leftLeft, leftRight, 2);
        Node right = new Node(rightLeft, rightRight, 6);
        Node node1 = new Node(left, right, 4);

        System.out.println(checkBST(node1));

    }

    //The Node class is defined as follows:
    static class Node {
        Node(Node left, Node right, int data){
            this.data = data;
            this.left=left;
            this.right=right;
        }
        int data;
        Node left;
        Node right;

        @Override
        public String toString() {
            return "Root:" + data + " Left:" + left + " Right: "+right;
        }
    }

    static Set<Integer> unique = new HashSet<>();
    static int isValid = 0;
    static int maxLeft = -1;
    static int minRight = -1;
    static boolean checkBST(Node root) {

        Node rootNode = root;

        if (rootNode!=null) {
            if (maxLeft<0) maxLeft = root.data;
            if (minRight<0) minRight = root.data;

            Node left = rootNode.left;
            Node right = rootNode.right;
            
            if (left != null && left.data >= rootNode.data){
                isValid += 1;
            }

            if (left != null && left.data >= maxLeft){
              isValid+=1;
            }
            if (right != null && right.data <= minRight){
              isValid+=1;
            }

            if (right != null && right.data <= rootNode.data){
                isValid += 1;
            }

            if (!unique.add(rootNode.data)){
                isValid += 1;
            }
            
            checkBST(left);
            checkBST(right);
        }
        return isValid==0;
    }
}
