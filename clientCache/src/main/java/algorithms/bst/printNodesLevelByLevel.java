//package algorithms.bst;
//
//import com.sun.source.tree.BinaryTree;
//
//import java.util.ArrayDeque;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Queue;
//
//public class printNodesLevelByLevel {
//    public static void main(String[] a) {
//
//        List<Integer> input = new ArrayList<>();
//        input.add(100);
//        input.add(50);
//        input.add(200);
//        input.add(25);
//        input.add(75);
//        input.add(350);
//
////        BinaryTree root = BinaryTree.create_BST(input);            Add list to Tree...
////        level_order_traversal_1(root);
//
//        System.out.println();
//
//
//        System.out.print("Inorder = ");
////        BinaryTree.display_inorder(root);
//    }
//
//    // Approach: create 2 queues, push current node to current_queue;
//    // pop current queue and push children to next queue;
//    // if current queue empty, swap current queue with next queue
//    // Iterative solution has O(n) memory complexity as it instantiates queues that can take space up to n/2 nodes
//    // Note: max leaves = n/2 where n is nodes
//    public static void level_order_traversal_1(
//            BinaryTree root) {
//
//        if (root == null) return;
//
//        ArrayList<Queue<BinaryTree>> queues = new ArrayList<>();
//
//        queues.add(new ArrayDeque<>());
//        queues.add(new ArrayDeque<>());
//
//        Queue<BinaryTree> current_queue = queues.get(0);
//        Queue<BinaryTree> next_queue = queues.get(1);
//
//        current_queue.add(root);
//        int level = 0;
//
//        while (!current_queue.isEmpty()) {
//            BinaryTree current = current_queue.poll();
//            System.out.print(current + ",");
//
//            if (current.getLeftOperand() != null) {
//                next_queue.add((BinaryTree) current.getLeftOperand());
//            }
//
//            if (current.getRightOperand() != null) {
//                next_queue.add((BinaryTree) current.getRightOperand());
//            }
//
//            if (current_queue.isEmpty()) {
//                System.out.println();
//                ++level;
//
//                current_queue = queues.get(level % 2);
//                next_queue = queues.get((level + 1) % 2);
//            }
//        }
//    }
//
//    //Approach: Use one queue
//    //For end of each level, insert null to indicate end of level. Used for println
//    public static void level_order_traversal_2(
//            BinaryTree root) {
//
//        if (root == null) return;
//
//        Queue<BinaryTree> current_queue = new ArrayDeque<>();
//        current_queue.add(root);
//        current_queue.add(null);
//
//        while (!current_queue.isEmpty()){
//           BinaryTree current = current_queue.poll();
//
//           System.out.print(current + ",");
//           if (current == null){
//               System.out.println();
//           }
//
//           if (current.getLeftOperand() != null)
//               current_queue.add((BinaryTree)current.getLeftOperand());
//
//           if (current.getRightOperand() != null)
//               current_queue.add((BinaryTree) current.getRightOperand());
//        }
//    }
//}
