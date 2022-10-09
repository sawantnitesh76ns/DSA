package BST;



public class BST {
    
    public class Node {
        int key;
        Node right , left;
        Node(int val) {
            key = val;
            left = right = null;
        }
    }

    int getSuccesor(Node _node) {

        Node node = _node;

        while(node.left != null) {
            node = node.left;
        }
        return node.key;
    }

    Node root;

    BST() {
        root = null;
    }

    void insert(int key) {
        root = insertKey(root, key);
    }

    Node insertKey(Node root,  int val) {
        if(root == null) {
            root = new Node(val);   
            return root;
        }

        if(val < root.key) {
            root.left = insertKey(root.left , val);
        } else if(val > root.key) {
            root.right = insertKey(root.right, val);
        } 
        return root;
    }

    void inOrder() {
        inOrderTravel(root);
    }

    void inOrderTravel(Node root) {
        if(root != null) {
            inOrderTravel(root.left);
            System.out.println("Node --->" + root.key);
            inOrderTravel(root.right);
        }
    }

    void delete(int key) {
        root = deleteNode(root , key);
    }

    Node deleteNode(Node root, int key) {
        if(root == null) {
            return root;
        }

        if(key < root.key) {
            root.left = deleteNode(root.left, key);
        } else if(key > root.key) {
            root.right = deleteNode(root.right, key);
        } else {
            if(root.left == null) {
                return root.right;
            }
            else if(root.right == null) {
                return root.left;
            }

            root.key = minValue(root.right);

            root.right = deleteNode(root.right, root.key);

        }

        return root;
    }

    int minValue(Node root) {
        int minV = root.key;
        while(root.left != null) {
            minV = root.left.key;
            root = root.left;
        }
        return minV;
    }

    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(8);
        bst.insert(1);
        bst.insert(3);
        bst.insert(9);
        bst.insert(11);
        bst.insert(13);

        bst.inOrder();

        bst.delete(9);
        bst.inOrder();

    }

}
