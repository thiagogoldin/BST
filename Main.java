import Trees.Tree;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();

        System.out.println("Inserindo nós");
        tree.addNode(5);
        tree.addNode(7);
        tree.addNode(3);
        tree.addNode(11);
        tree.addNode(10);
        tree.addNode(6);

        System.out.print("Pré-ordem: ");
        tree.preOrder();
        System.out.println();

        System.out.print("Em-ordem:  ");
        tree.inOrder();
        System.out.println();

        System.out.print("Pós-ordem: ");
        tree.postOrder();
        System.out.println();

        System.out.println("\nRemovendo o nó ");
        tree.deleteNode(7);

        System.out.print("Em-ordem após remoção: ");
        tree.inOrder();
        System.out.println();
    }
}