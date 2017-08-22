//Java implementation to check if given Binary tree
//is a BST or not

import java.util.ArrayList;

/* Class containing left and right child of current
 node and key value*/
class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class IsBinaryTree {
    Node root;

    /* Driver program to test above functions */
    public static void main(String args[]) {
        IsBinaryTree tree = new IsBinaryTree();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);


        if (tree.checkBST(tree.root))
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }


    boolean checkBST(Node root) {
        if (root == null) {
            return true;
        }

        return check(root).bst;
    }

    Result check(Node node) {
        int min = node.data;
        int max = node.data;

        if (node.left != null) {
            Result leftResult = check(node.left);
            if (!leftResult.bst || leftResult.max >= node.data) {
                return new Result(false, 0, 0);
            }
            min = leftResult.min;
        }
        if (node.right != null) {
            Result rightResult = check(node.right);
            if (!rightResult.bst || rightResult.min <= node.data) {
                return new Result(false, 0, 0);
            }
            max = rightResult.max;
        }

        return new Result(true, min, max);
    }


    class Result {
        boolean bst;
        int min;
        int max;

        Result(boolean bst, int min, int max) {
            this.bst = bst;
            this.min = min;
            this.max = max;
        }
    }

}