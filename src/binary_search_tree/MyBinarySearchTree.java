package binary_search_tree;

/**
 * @author Serj C.
 */
public class MyBinarySearchTree {
    private static BSTNode insert(int data, BSTNode root) {
        if (root == null) {
            root = new BSTNode(data);
        } else if (data <= root.data) {
            root.left = insert(data, root.left);
        } else {
            root.right = insert(data, root.right);
        }

        return root;
    }

    private static BSTNode search(int data, BSTNode root) {
        if (root.data == data) {
            return root;
        } else if (data < root.data) {
            return search(data, root.left);
        } else {
            return search(data, root.right);
        }
    }

    private static void inorder(BSTNode root) {
        if (root == null) {
            return;
        } else {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    private static BSTNode delete(BSTNode root, int data) {
        if (root == null) {
            return root;
        }

        if (data < root.data) {
            root.left = delete(root.left, data);
        } else if (data > root.data) {
            root.right = delete(root.right, data);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.data = min(root.right);
            root.right = delete(root.right, root.data);
        }

        return root;
    }

    private static int min(BSTNode root) {
        int min = root.data;
        while (root.left != null) {
            min = root.left.data;
            root = root.left;
        }

        return min;
    }

    public static void main(String[] args) {
        BSTNode root = null;

        root = insert(50, root);
        root = insert(30, root);
        root = insert(20, root);
        root = insert(20, root);
        root = insert(70, root);
        root = insert(60, root);
        root = insert(80, root);

        System.out.println("\n******* BINARY SEARCH TREE *******");
        System.out.println("\n\t       (" + root.data + ")");
        System.out.println("\t      /    \\");
        System.out.println("\t    (" + root.left.data + ")   (" + root.right.data + ")");
        System.out.println("\t    /      /  \\");
        System.out.println("\t  (" + root.left.left.data + ")   (" + root.right.left.data + ")(" + root.right.right.data + ")");
        System.out.println("\t  /");
        System.out.println("\t(" + root.left.left.left.data + ")");
        System.out.println();

        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();

        System.out.println("\nDelete Node: 50\n");
        root = delete(root, 50);

        System.out.println("New root: " + root.data);

        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();

        BSTNode foundNode = search(30, root);
        if (foundNode == null) {
            System.out.println("\nNode not found");
        } else {
            System.out.println("\nNode found: " + foundNode.data);
        }
    }
}
