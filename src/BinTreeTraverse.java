import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by chenwenping on 17/3/6.
 */
public class BinTreeTraverse {
    /**
     *
     */
    private static int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    private static List<Node> nodeList = null;


    /**
     *
     */
    private static class Node {
        Node leftChild;
        Node rightChild;
        int data;

        Node(int newData) {
            leftChild = null;
            rightChild = null;
            data = newData;
        }
    }

    /**
     * @param v
     * @param rootNode
     */
    static void insert(int v, Node rootNode) {
        if (v != rootNode.data) {
            if (v < rootNode.data) {
                if (rootNode.leftChild == null) {
                    rootNode.leftChild = new Node(v);
                } else {
                    insert(v, rootNode.leftChild);
                }
            } else {
                if (rootNode.rightChild == null) {
                    rootNode.rightChild = new Node(v);
                } else {
                    insert(v, rootNode.rightChild);
                }
            }
        }
    }

    /**
     *
     */
    public void createBinTree() {
        nodeList = new LinkedList<Node>();
        // 将一个数组的值依次转换为Node节点
        for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
            nodeList.add(new Node(array[nodeIndex]));
        }
        // 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            // 左孩子
            nodeList.get(parentIndex).leftChild = nodeList
                    .get(parentIndex * 2 + 1);
            // 右孩子
            nodeList.get(parentIndex).rightChild = nodeList
                    .get(parentIndex * 2 + 2);
        }
        // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
        int lastParentIndex = array.length / 2 - 1;
        // 左孩子
        nodeList.get(lastParentIndex).leftChild = nodeList
                .get(lastParentIndex * 2 + 1);
        // 右孩子,如果数组的长度为奇数才建立右孩子
        if (array.length % 2 == 1) {
            nodeList.get(lastParentIndex).rightChild = nodeList
                    .get(lastParentIndex * 2 + 2);
        }
    }


    /**
     * @param node
     */
    public static void preOrderTraverse(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrderTraverse(node.leftChild);
        preOrderTraverse(node.rightChild);
    }


    /**
     * @param node
     */
    public static void inOrderTraverse(Node node) {
        if (node == null)
            return;
        inOrderTraverse(node.leftChild);
        System.out.print(node.data + " ");
        inOrderTraverse(node.rightChild);
    }


    /**
     * @param node
     */
    public static void postOrderTraverse(Node node) {
        if (node == null)
            return;
        postOrderTraverse(node.leftChild);
        postOrderTraverse(node.rightChild);
        System.out.print(node.data + " ");
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
/*        BinTreeTraverse binTree = new BinTreeTraverse();
        binTree.createBinTree();
        // nodeList中第0个索引处的值即为根节点
        Node root = nodeList.get(0);*/

       /* Node root = null;
        int n = 0;
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            n = in.nextInt();
            int v = in.nextInt();
            root = new Node(v);
            n--;
            while (n > 0) {
                v = in.nextInt();
                insert(v, root);
                n--;
            }
        }*/

       Node root = new Node(array[0]);

        for (int i = 0; i < array.length; i++) {
            insert(array[i], root);
        }


        System.out.println("先序遍历：");
        preOrderTraverse(root);
        System.out.println();

        System.out.println("中序遍历：");
        inOrderTraverse(root);
        System.out.println();

        System.out.println("后序遍历：");
        postOrderTraverse(root);
    }

}
