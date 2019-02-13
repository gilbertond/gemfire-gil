package algorithms.bst;

class TreeNodex {
    int val;
    TreeNodex left;
    TreeNodex right;
    TreeNodex(int x) { val = x; }
}

public class BinaryTreeFromInorderPostOrderArrays {
     public static void main(String [] a){
         int [] inOrder = {4, 2, 5, 1, 6, 7, 3, 8};
         int [] postOrder = {4, 5, 2, 6, 7, 8, 3, 1};

         buildBinaryTree(inOrder, postOrder);
     }

     static TreeNodex buildBinaryTree(int [] inOrder, int [] postOrder){
         int startInorder = 0;
         int startPostorder = 0;

         int endInorder = inOrder.length-1;
         int endPostorder = postOrder.length-1;

         return buildTree(inOrder, startInorder, endInorder, postOrder, startPostorder, endPostorder);
     }

     static TreeNodex buildTree(int[] inOrder, int startInorder, int endInorder, int[] postOrder, int startPostorder, int endPostorder){

         if (startInorder > endInorder || startPostorder > startPostorder) return null;

         //Post order has root node as last index
         int rootValue = postOrder[endPostorder];

         int currentRootIndex = 0;
         //Get root from the inorder
         for (int index = 0; index < inOrder.length; index++){
             if(inOrder[index] == rootValue){
                 currentRootIndex = index;
                 break;
             }
         }

         TreeNodex node = new TreeNodex(rootValue);

         node.left = buildTree(inOrder, startInorder, currentRootIndex-1, postOrder, startPostorder, startPostorder+currentRootIndex-(startInorder+1));

         node.right = buildTree(inOrder, currentRootIndex+1, endInorder, postOrder, startPostorder+currentRootIndex-startInorder, endPostorder-1);

         return node;
     }
}
