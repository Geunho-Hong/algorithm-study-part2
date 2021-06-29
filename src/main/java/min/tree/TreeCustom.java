package min.tree;

public class TreeCustom {

    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node makeNode(Node left, int val, Node right) {
        return new Node(val, left, right);
    }

    // Left, Root, Right
    public void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.println(node.val);
            inorder(node.right);
        }
    }

    // Root, Left, Right
    public void preorder(Node node) {
        if (node != null) {
            System.out.println(node.val);
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.println(node.val);
        }
    }

    public static void main(String[] args) {

    }

}
