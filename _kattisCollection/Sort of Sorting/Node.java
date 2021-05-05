public class Node implements Comparable<Node> {

    private final String data;
    private final String firstTwoChars;
    private final Node parentNode;
    private Node rightChildNode;
    private Node leftChildNode;

    public Node(String data, Node parentNode) {
        this.data = data;
        this.firstTwoChars = "" + data.charAt(0) + data.charAt(1);
        this.parentNode = parentNode;
    }

    public String getData() {
        return data;
    }

    public String getFirstTwoChars() {
        return firstTwoChars;
    }

    public Node getParentNode() {
        return parentNode;
    }

    public Node getRightChildNode() {
        return rightChildNode;
    }

    public void setRightChildNode(Node rightChildNode) {
        this.rightChildNode = rightChildNode;
    }

    public Node getLeftChildNode() {
        return leftChildNode;
    }

    public void setLeftChildNode(Node leftChildNode) {
        this.leftChildNode = leftChildNode;
    }

    @Override
    public String toString() {
        return data;
    }

    @Override
    public int compareTo(Node other) {
        return this.firstTwoChars.compareToIgnoreCase(other.firstTwoChars);
    }
}
