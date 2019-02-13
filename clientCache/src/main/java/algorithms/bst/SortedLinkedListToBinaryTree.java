package algorithms.bst;

import algorithms.Node;

public class SortedLinkedListToBinaryTree {

    public static void main(String[] a){
        Node node =new Node(1);
        node.next=new Node(2);
        node.next.next=new Node(3);
        node.next.next.next=new Node(4);
        node.next.next.next.next=new Node(5);
        node.next.next.next.next.next=new Node(6);

        int count = 0;
        Node head = node;
        while (head!=null){
            count++;

            head = head.next;
        }
        TreeNode root = buildBST(node, 0, count-1);
    }

    static TreeNode buildBST(Node node, int start, int end){
        if (start > end) return null;

        int mid = (end + start)/2;
        TreeNode root = getMid(node, mid);

        root.left = buildBST(node, start, mid-1);
        root.right = buildBST(node, mid+1, end);

        return root;
    }

    static TreeNode getMid(Node node, int mid){
        while (node!=null){
            mid--;

            if(mid == 0) return new TreeNode(node.data);

            node = node.next;
        }

        return null;
    }
}
