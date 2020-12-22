public class BinarySearchTreeImplementation {
    public class TreeNode {
        int value;
        TreeNode leftChild, rightChild;

        public TreeNode(int key) {
            value = key;
            leftChild = rightChild = null;
        }
    }
    TreeNode root;

    public BinarySearchTreeImplementation(int value) {
        this.root = new TreeNode(value);
    }

    public void insertInBst(int value) {
        root = insertRecursively(root, value);

    }

    TreeNode insertRecursively(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }
        if (value < root.value) {
            root.leftChild = insertRecursively(root.leftChild, value);
        } else if (value > root.value) {
            root.rightChild = insertRecursively(root.rightChild, value);
        }
        return root;
    }

    public void inOrder() {
        inOrderRecursively(root);
    }

    void inOrderRecursively(TreeNode root) {
        if (root != null) {
            inOrderRecursively(root.leftChild);
            System.out.println(root.value);
            inOrderRecursively(root.rightChild);
        }
    }
    public void postOrder(){
        inOrderRecursively(root);
    }
    void postOrderRecursively(TreeNode root){
        if (root != null) {
            inOrderRecursively(root.leftChild);
            inOrderRecursively(root.rightChild);
            System.out.println(root.value);
        }
    }
    public void preOrder(){
        preOrderRecursively(root);
    }
    void preOrderRecursively(TreeNode root){
        if (root != null) {
            System.out.println(root.value);
            inOrderRecursively(root.leftChild);
            inOrderRecursively(root.rightChild);

        }
    }
    public static void main(String args[]) {
        BinarySearchTreeImplementation bst = new BinarySearchTreeImplementation(6);
        bst.insertInBst(3);
        bst.insertInBst(1);
        bst.insertInBst(90);
        bst.inOrder();
        bst.postOrder();
        bst.preOrder();
    }
}
