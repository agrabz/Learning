public class BinarySearchTree {

    Node root;

    public void insertData(String newData) {
        if (root == null) {
            root = new Node(newData, null);
            return;
        }
        insertData(newData, root);
    }

    private void insertData(String newData, Node node) {
        String firstTwoChars = "" + newData.charAt(0) + newData.charAt(1);
        if (node.getFirstTwoChars().compareTo(firstTwoChars) <= 0) {
            //goes right (equal too)
            if (node.getRightChildNode() == null) {
                node.setRightChildNode(new Node(newData, node));
                return;
            }
            insertData(newData, node.getRightChildNode());
        } else {
            //goes left
            if (node.getLeftChildNode() == null) {
                node.setLeftChildNode(new Node(newData, node));
                return;
            }
            insertData(newData, node.getLeftChildNode());
        }
    }

    public void traverse() {
        if (root == null) {
            return;
        }
        traverse(root);
    }

    private void traverse(Node node) {
        if (node.getLeftChildNode() != null) {
            traverse(node.getLeftChildNode());
        }
        System.out.println(node);
        if (node.getRightChildNode() != null) {
            traverse(node.getRightChildNode());
        }
    }

}
