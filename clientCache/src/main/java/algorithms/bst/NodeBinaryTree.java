package algorithms.bst;

//Initial Template for Java
import java.util.Scanner;
class NodeBinaryTree

{
    int data;
    NodeBinaryTree
            left, right;

    NodeBinaryTree
            (int item)
    {
        data = item;
        left = right = null;
    }
}

class Res
{
    int r = Integer.MIN_VALUE;
}

class BinaryTree
{
    public static void main (String[] args) 
    {
         Scanner sc=new Scanner(System.in);
          int t=sc.nextInt();
          
           while(t-->0){
            int n=sc.nextInt();
            if(n==0){
                System.out.println(0);
                continue;
            }
            NodeBinaryTree
                    root = null;
            for(int i=0;i<n;i++){
                int a=sc.nextInt();
                int a1=sc.nextInt();
                char lr=sc.next().charAt(0);
                if(i==0){
                    root=new NodeBinaryTree
                            (a);
                    switch(lr){
                        case 'L':root.left=new NodeBinaryTree
                                (a1);
                        break;
                        case 'R':root.right=new NodeBinaryTree
                                (a1);
                        break;
                    }
                }
                else{
                    insert(root,a,a1,lr);
                }
            }
            
            GfG g=new GfG();
            System.out.println(g.maxDiff(root));
            
        }
    }
    public static void insert(NodeBinaryTree root,int a,int a1,char lr){
        if(root==null){
            return;
        }
        if(root.data==a){
            switch(lr){
                case 'L':root.left=new NodeBinaryTree
                        (a1);
                break;
                case 'R':root.right=new NodeBinaryTree
                        (a1);
                break;
            }
            return;
        }
        insert(root.left,a,a1,lr);
        insert(root.right,a,a1,lr);
    }
}

class GfG
{

    int maxDiffUtil(NodeBinaryTree t, Res res)
    {
        
        /* Returning Maximum int value if node is not
           there (one child case)  */
        if (t == null)
            return Integer.MIN_VALUE;

        /* If leaf node then just return node's value  */
        if (t.left == null && t.right == null)
            return t.data;

        /* Recursively calling left and right subtree
           for minimum value  */
        int val = Math.min(maxDiffUtil(t.left, res),
                maxDiffUtil(t.right, res));

        /* Updating res if (node value - minimum value
           from subtree) is bigger than res  */
        res.r = Math.max(res.r, t.data - val);

        /* Returning minimum value got so far */
        return Math.min(val, t.data);
    }

    int maxDiff(NodeBinaryTree root)
    {
        // Initialising result with minimum int value
        Res res = new Res();
        maxDiffUtil(root, res);

        return res.r;
    }
}