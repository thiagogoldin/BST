package Trees;

public class Tree {
    public Node root;

    public void addNode(int value) {
        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
            return;
        }

        Node current = root;
        Node parent = null;

        while (current != null) {
            parent = current;
            if (value < current.value) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    return;
                }
            } else if (value > current.value) {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    return;
                }
            } else {
                return;
            }
        }
    }

    public void preOrder() {
        if (root == null) return;

        java.util.Stack<Node> stack = new java.util.Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.print(current.value + " ");

            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }

    public void inOrder() {
        java.util.Stack<Node> stack = new java.util.Stack<>();
        Node current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            System.out.print(current.value + " ");
            current = current.right;
        }
    }

    public void postOrder() {
        if (root == null) return;

        java.util.Stack<Node> stack1 = new java.util.Stack<>();
        java.util.Stack<Node> stack2 = new java.util.Stack<>();

        stack1.push(root);

        while (!stack1.isEmpty()) {
            Node current = stack1.pop();
            stack2.push(current);

            if (current.left != null) {
                stack1.push(current.left);
            }
            if (current.right != null) {
                stack1.push(current.right);
            }
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().value + " ");
        }
    }

    public void deleteNode(int value) {
        Node current = root;
        Node parent = null;

        while (current != null && current.value != value) {
            parent = current;
            if (value < current.value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (current == null) return;

        if (current.left == null || current.right == null) {
            Node newChild = (current.left != null) ? current.left : current.right;

            if (current == root) {
                root = newChild;
            } else if (parent.left == current) {
                parent.left = newChild;
            } else {
                parent.right = newChild;
            }
        }
        else {
            Node successorParent = current;
            Node successor = current.right;

            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            current.value = successor.value;

            if (successorParent.left == successor) {
                successorParent.left = successor.right;
            } else {
                successorParent.right = successor.right;
            }
        }
    }
}