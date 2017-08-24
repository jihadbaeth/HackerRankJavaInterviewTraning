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
        tree.root.left.right.left = new Node(1);
        tree.root.left.right.right = new Node(4);
        int[] allData = tree.convertToIntArray(tree.root);
        System.out.println(tree.checkDuplicates(allData));
        ;

        if (tree.checkBST(tree.root))
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }

    int[] convertToIntArray(Node root) {
        ArrayList<Node> tree = new ArrayList<Node>();
        if (root != null) {
            tree.add(root);
            if (root.left != null && root.right != null) {
                convertToIntArray(root.right);
                convertToIntArray(root.left);
            }
        }


        int[] allData = new int[tree.size()];
        for (int n = 0; n < tree.size(); n++) {
            allData[n] = tree.get(n).data;
            System.out.println(allData[n]);

        }


        return allData;
    }

    boolean checkDuplicates(int[] allData) {

        for (int i = 0; i < allData.length; i++) {

            for (int x = i + 1; x < allData.length; x++) {
                System.out.println("Testing " + allData[i] + " Against " + allData[x]);

                if (allData[i] == allData[x]) {
                    System.out.println("Duplicate Found!");
                    return true;

                }
            }
        }
        return false;
    }


    boolean checkTree(Node root) {

        if (root != null) {
            if (root.left != null && root.right != null) {
                if (root.left.data < root.data && root.right.data > root.data) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return (checkBST(root.left) && checkBST(root.right));

    }

    boolean checkBST(Node root) {

        if (root != null) {
            return checkTree(root);
        } else {
            return false;
        }


    }
}

