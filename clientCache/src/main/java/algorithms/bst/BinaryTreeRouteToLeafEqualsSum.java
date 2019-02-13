package algorithms.bst;

import java.util.LinkedList;

public class BinaryTreeRouteToLeafEqualsSum {

    public static void main(String[] args){

        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.left.left = new TreeNode(11);
        node.left.right = new TreeNode(1);
        node.left.left.left = new TreeNode(7);
        node.left.left.right = new TreeNode(2);


        node.right = new TreeNode(8);
        node.right.left = new TreeNode(13);
        node.right.right = new TreeNode(4);

        int sum = 22;

        System.out.println(hasPathToLeaf(node, sum));
        System.out.println(hasPathToLeafRecursion(node, sum));
    }

    //Using Queue for BFS
    static boolean hasPathToLeaf(TreeNode node, int sum){

        if(node==null) return false;
        
        LinkedList<TreeNode> nodes = new LinkedList<>();
        LinkedList<Integer> sums = new LinkedList<>();

        nodes.add(node);
        sums.add(node.val);
        
        while (!nodes.isEmpty())  {
                TreeNode currentNode = nodes.poll();
                int currentSum = sums.poll();

                if (currentNode.left==null && currentNode.right==null && currentSum == sum){
                     return true;
                }

                if (currentNode.left != null){
                    sums.add(currentNode.left.val + currentSum);
                    nodes.add(currentNode.left);
                }

                if (currentNode.right != null){
                    sums.add(currentNode.right.val + currentSum);
                    nodes.add(currentNode.right);
                }
        }
        return false;
    }
    static boolean hasPath = false;
    //Using recursion for BFS
    static boolean hasPathToLeafRecursion(TreeNode node, int sum){

        if (node==null) return hasPath;

        if (node != null){
            if(node.left == null && node.right == null && node.val==sum){
                return true;
            }

            if (node.left != null){
                node.left.val += node.val;
                 hasPath = hasPathToLeafRecursion(node.left, sum);
            }

            if(node.right!=null){
                node.right.val+=node.val;
                hasPath = hasPathToLeafRecursion(node.right, sum);
            }
        }

        return hasPath;
    }
}

 class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int newVal){
        this.val = newVal;
    }
}
