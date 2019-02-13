package algorithms.bst;


public class SortedArrayToBinaryTree {

    public static void main(String[] a){
        int[] sortedArr = {1,2,3,4,5,6};

        TreeNode root = buildBST(sortedArr, 0, sortedArr.length-1);
    }

    static TreeNode buildBST(int[] arr, int start, int end){
        if (arr.length==0 || start > end) return null;

        int mid = (end + start)/2;
        TreeNode root = new TreeNode(arr[mid]);

        root.left = buildBST(arr, start, mid-1);
        root.right = buildBST(arr, mid+1, end);

        return root;
    }
}
