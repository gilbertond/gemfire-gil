//package algorithms;
//
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.LinkedList;
//
//public class BFSnDFS {
//    public static void main(String[] args){
//
//    }
//
//    private HashMap<Integer, Node> nodeLookup = new HashMap<>();
//
//    private static class Node{
//        private int id;
//        LinkedList<Node> adjacent = new LinkedList<>();
//
//        private Node(int id){
//            this.id = id;
//        }
//    }
//
//    private Node getNode(int id){
//        return new Node(id);
//    }
//
//    public void addEdge(int source, int destination){
//       Node node = getNode(source);
//       node.adjacent.add(getNode(destination));
//    }
//
//    private boolean hasPathDFS(int source, int destination) {
//
//        Node s = getNode(source);
//        Node d = getNode(destination);
//
//        HashSet<Integer> visited = new HashSet<>();
//        return hasPathDFS(s, d, visited);
//    }
//
//    private boolean hasPathDFS(Node source, Node destination, HashSet<Integer> visited){
//
//    }
//}
