package algorithms.bst;

class IsBST {
    public static boolean is_bst(
            BinaryTreeNode root) {
        return is_bst_2(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean is_bst_2(BinaryTreeNode root, int min_value, int max_value) {
        if (root == null) return true;

        if (root.data <= min_value || root.data >= max_value) return false;
        return is_bst_2(root.left, min_value, root.data) && is_bst_2(root.right, root.data, max_value);
    }


    static BinaryTreeNode prev = null;

    //Using inorder traversal, Keep track of the prev visited, check if current node is less than prev and return false if greater or equal
    static boolean is_binary_search_tree(
            BinaryTreeNode root) {

        if (root == null) {
            return true;
        }

        if (!is_binary_search_tree(root.left)) {
            return false;
        }

        if (prev != null && prev.data >= root.data) {
            return false;
        }
        prev = root;

        if (!is_binary_search_tree(root.right)) {
            return false;
        }

        return true;
    }
}