package dataStructure;

public class BinarySerachTree {
    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(1);
        bst.insert(4);
        bst.insert(8);
        bst.insert(9);
        bst.insert(10);
        bst.insert(2);

        System.out.println("중위순회:");
        bst.inorderTraversal();
        System.out.println();

        System.out.println("전위순회:");
        bst.preorderTraversal();
        System.out.println();

        System.out.println("후위순회:");
        bst.postorderTraversal();
        System.out.println();

        System.out.println("전위순회 거꾸로");
        bst.reverseInorderTraversal();
        System.out.println();

        int searchValue = 4;
        if (bst.search(searchValue)) {
            System.out.println("\n" + searchValue + " is found.");
        } else {
            System.out.println("\n" + searchValue + " is not found.");
        }
    }
}

class BST {
    private TreeNode root;

    public BST() {
        this.root = null;
    }

    public void insert(int val) {
        root = insertNode(root, val);
    }

    private TreeNode insertNode(TreeNode currentNode, int val) {
        if (currentNode == null) {
            currentNode = new TreeNode(val);
            return currentNode;
        }

        if (val < currentNode.val) {
            currentNode.left = insertNode(currentNode.left, val);
        } else if (val > currentNode.val) {
            currentNode.right = insertNode(currentNode.right, val);
        }

        return currentNode;
    }

    public boolean search(int val) {
        return searchNode(root, val);
    }

    private boolean searchNode(TreeNode currentNode, int val) {
        if (currentNode == null) {
            return false;
        }

        if (currentNode.val == val) {
            return true;
        } else if (val < currentNode.val) {
            return searchNode(currentNode.left, val);
        } else {
            return searchNode(currentNode.right, val);
        }
    }

    // 중위 순회 -> 중위를 반대로 하면 reverse가 가능하다
    public void inorderTraversal() {
        inorder(root);
    }

    private void inorder(TreeNode currentNode) {
        if (currentNode != null) {
            inorder(currentNode.left);
            System.out.print(currentNode.val + " ");
            inorder(currentNode.right);
        }
    }

    public void reverseInorderTraversal() {
        reverseInorder(root);
    }

    private void reverseInorder(TreeNode currentNode) {
        if(currentNode != null) {
            reverseInorder(currentNode.right);
            System.out.print(currentNode.val + " ");
            reverseInorder(currentNode.left);
        }
    }

    // 전위순회
    public void preorderTraversal() {
        preorder(root);
    }

    private void preorder(TreeNode currentNode) {
        if (currentNode != null) {
            System.out.print(currentNode.val + " ");
            preorder(currentNode.left);
            preorder(currentNode.right);
        }
    }

    // 후위순회
    public void postorderTraversal() {
        postorder(root);
        System.out.println();
    }

    private void postorder(TreeNode currentNode) {
        if (currentNode != null) {
            postorder(currentNode.left);
            postorder(currentNode.right);
            System.out.print(currentNode.val + " ");
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}