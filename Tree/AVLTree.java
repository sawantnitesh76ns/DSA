package Tree;

class Node {
    int key;
    Node left;
    Node right;
    int height;

    Node(int _key) {
        key = _key;
        left = right = null;
        height = 1;
    }
}

public class AVLTree {
    Node root;
    
    AVLTree() {
        root = null;
    }

    int height(Node N){
        if (N == null) {
            return 0;
        }
        return N.height;
    }

    int max(int a , int b) {
        return a > b? a :b;
    }

    int bf(Node node) {
        if(node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.left =y;
        y.left = T2;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left) , height(y.right)) + 1;
        return x;
    }

    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left) , height(y.right)) + 1;
        return y;
    }

    Node insertNode(Node  root , int key ) {
        if(root == null) {
            return new Node(key);
        }
        if(key < root.key) {
            root.left = insertNode(root.left, key);
        } else if(key > root.key) {
            root.right = insertNode(root.right, key);
        } else {
            return root;
        }

        // Update height of node
        root.height = max(height(root.left), height(root.right)) + 1;
        // Get balanace factor
        int bf = bf(root);

        if(bf > 1) {
            if(key < root.left.key) {
                return rightRotate(root);
            } else if(key > root.left.key) {
                root.left = leftRotate(root.left);
                return rightRotate(root);
            }
        }

        if(bf < -1) {
            if(key > root.right.key) {
                return leftRotate(root);
            } else if(key < root.right.key) {
                root.right = rightRotate(root.right);
                return leftRotate(root);
            }
        }

        return root;
    }

    Node getSuccessor(Node root) {
        Node current = root;
        while(current.left != null) {
            current = current.left;
        }
        return current;
    }

    Node deleteNode(Node root , int key) {
        if(root == null) {
            return root;
        }

        if(key < root.key) {
            root.left = deleteNode(root.left, key);
        }
        else if(key > root.key) {
            root.right = deleteNode(root.right, key);
        } else {
            if(root.left == null || root.right == null) {
                Node temp = null;
                if(root.left == temp) {
                    temp = root.right;
                } else if(temp == root.right) {
                    temp = root.left;
                }

                if(temp == null) {
                    temp = root;
                    root = null;
                } else {
                    root = temp;
                }
            } else {
                Node temp = getSuccessor(root.right);
                root.key = temp.key;
                root.right = deleteNode(root.right, temp.key);
            }
        }

        if(root == null) {
            return null;
        }

        // Update balance factor
        root.height = max(height(root.left), height(root.right));
        int bf = bf(root);

        if(bf > 1) {
            if(key < root.left.key) {
                return rightRotate(root);
            } else if(key > root.left.key) {
                root.left = leftRotate(root.left);
                return rightRotate(root);
            }
        }

        if(bf < -1) {
            if(key > root.right.key) {
                return leftRotate(root);
            } else if(key < root.right.key) {
                root.right = rightRotate(root.right);
                return leftRotate(root);
            }
        }

        return root;
    }

    private void printAvlTree(Node currPointer , String indent, boolean last) {
        if(currPointer != null) {
            System.out.print(indent);
            if(last) {
                System.out.print("R-----");
                indent += " ";
            } else {
                System.out.print("L-----");
                indent+= "| ";
            }

            System.out.println(currPointer.key);
            printAvlTree(currPointer.left, indent, false);
            printAvlTree(currPointer.right, indent, true);
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.root = tree.insertNode(tree.root, 33);
        tree.root = tree.insertNode(tree.root, 13);
        tree.root = tree.insertNode(tree.root, 53);
        tree.root = tree.insertNode(tree.root, 9);
        tree.root = tree.insertNode(tree.root, 21);
        tree.root = tree.insertNode(tree.root, 61);
        tree.root = tree.insertNode(tree.root, 8);
        tree.root = tree.insertNode(tree.root, 11);

        tree.printAvlTree(tree.root, "", true);
        tree.root = tree.deleteNode(tree.root, 13);
        System.out.println("After Deletion: ");
        tree.printAvlTree(tree.root, "", true);
    }


}
