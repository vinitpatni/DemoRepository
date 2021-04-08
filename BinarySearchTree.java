public class BinarySearchTree {

    private Node root = null;

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(2);
        bst.insert(10);
        bst.insert(8);
        bst.insert(7);
        bst.insert(1);
        bst.insert(15);
        bst.insert(0);

        System.out.println(bst.root);
        System.out.println(bst.inorder());

        System.out.println(bst.queryIfPresent(111));
    }

    //TODO Need to add multiple usecases of delete ops
    public void delete(){

    }

    public void insert(int numberToInsert) {
        Node newNode = new Node(numberToInsert);
        if (root == null) {
            root = newNode;
            return;
        }
        Node node = root;
        while (node != null) {
            Node curr = null;
            if (numberToInsert < node.getData()) {
                curr = node.getLeft();
                if (curr == null) {
                    node.setLeft(newNode);
                    break;
                }
            } else if (numberToInsert > node.getData()) {
                curr = node.getRight();
                if (curr == null) {
                    node.setRight(newNode);
                    break;
                }
            }
            node = curr;
        }
        return;
    }

    /**
     * Number to search using bst tree
     *
     * @param numberToSearch
     * @return
     */
    public boolean queryIfPresent(int numberToSearch) {
        Node temp = root;
        while (temp != null) {
            if (numberToSearch == temp.getData())
                return true;
            else if (numberToSearch < temp.getData()) {
                temp = temp.getLeft();
            } else {
                temp = temp.getRight();
            }
        }
        return false;
    }

    public String inorder() {
        StringBuilder result = new StringBuilder();
        inorder(this.root, result);
        return result.toString();
    }

    private void inorder(Node node, StringBuilder result) {
        if(node == null)
            return ;
        if(node.isLeaf()) {
            if(result.length() == 0){
                result.append(node.getData());
            }else {
                result.append(",").append(node.getData());
            }
            return;
        }
        inorder(node.getLeft(), result);
        result.append(",").append(node.getData());
        inorder(node.getRight(), result);
    }

    private static class Node {

        public boolean isLeaf(){
            return left == null && right == null;
        }
        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public void setData(int data) {
            this.data = data;
        }

        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        public Node(Node left, Node right, int data) {
            this.left = left;
            this.right = right;
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public int getData() {
            return data;
        }

        int data;

        @Override
        public String toString() {
            return "Node{" +
                    "left=" + left +
                    ", right=" + right +
                    ", data=" + data +
                    '}';
        }
    }
}
