package algorithm.search;

public class RedBlackTree {
    private final int R = 0;
    private final int B = 1;
    private Node root = null;
    class Node{
        int data;
        int color = R;
        Node parent;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
        }
    }
    public void insert(Node root,int data){
        if (root.data<data){
            if (root.right==null) root.right = new Node(data);
            else  insert(root.right,data);
        }else {
           if (root.left==null) root.left = new Node(data);
           else insert(root.left,data);
        }
    }
    public void leftRotate(Node node){
        if (node.parent==null){
            Node E = root;
        }
    }
}
