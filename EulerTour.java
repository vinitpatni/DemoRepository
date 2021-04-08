import java.util.ArrayList;
import java.util.List;

public class EulerTour {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(2);
        bst.insert(3);
        bst.insert(12);
        bst.insert(1);
        bst.insert(15);
        bst.insert(0);

        BinarySearchTree.Node root = bst.getRoot();

        EulerTour ett = new EulerTour();
        List<Integer> eulerTour = ett.eulerTour(root);
        System.out.println(eulerTour);
    }

    private List<Integer> eulerTour(BinarySearchTree.Node root) {
        List<Integer> result = new ArrayList<Integer>();
        traverseEulerTour(root, result);
        return result;
    }

    private void traverseEulerTour(BinarySearchTree.Node node, List<Integer> eulerList) {
        if (node.isLeaf()) {
            eulerList.add(node.getData());
            return;
        }
        eulerList.add(node.getData());
        if (node.getLeft() != null) {
            traverseEulerTour(node.getLeft(), eulerList);
            eulerList.add(node.getData());
        }
        if (node.getRight() != null) {
            traverseEulerTour(node.getRight(), eulerList);
            eulerList.add(node.getData());
        }
    }


}

