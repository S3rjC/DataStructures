package binary_tree;

/**
 * @author Serj C.
 */
public class MyBinaryTree {
    private static void preorder(BTNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    private static void postorder(BTNode root) {
        if (root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    private static void inorder(BTNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        BTNode root = new BTNode(1);

        root.left = new BTNode(2);
        root.right = new BTNode(3);

        root.left.left = new BTNode(4);
        root.left.right = new BTNode(5);

        root.right.left = new BTNode(6);
        root.right.right = new BTNode(7);

        System.out.println("\n******* BINARY TREE *******");
        System.out.println("\n\t      (" + root.data + ")");
        System.out.println("\t     /   \\");
        System.out.println("\t  (" + root.left.data + ")     ("+ root.right.data +")");
        System.out.println("\t  / \\     / \\");
        System.out.println("\t(" + root.left.left.data + ") (" + root.left.right.data + ") " +
                "(" + root.right.left.data + ") (" + root.right.right.data + ")");
        System.out.println();

        System.out.print("Preorder: ");
        preorder(root);
        System.out.println();

        System.out.print("Postorder: ");
        postorder(root);
        System.out.println();

        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();
    }
}
