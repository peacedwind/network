package tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * BInaryTree
 *  2叉查找树
 * @author: cyx_jay
 * @date: 2020/11/4 14:03
 */
public class BinaryTree<K extends Comparable,V> {

    private Node<K,V> root;

    private int N;

    public Node<K, V> getRoot() {
        return root;
    }

    public void setRoot(Node<K, V> root) {
        this.root = root;
    }

    public int getN() {
        return N;
    }

    public void setN(int n) {
        N = n;
    }

    public void put(K key, V value){

        this.root  = put(root,key,value);

    }

    private Node<K,V> put(Node<K,V> node, K key, V value) {
        if (node == null){
            return new Node<>(key,value);
        }
        //左子树
        Node left = node.getLeft();
        //右子树
        Node right = node.getRight();
        //当前node比要插入的大
        if (node.getKey().compareTo(key) >0){
            //放在左边
            Node nodeLeft = put(left, key, value);
            node.setLeft(nodeLeft);
        }

        if (node.getKey().compareTo(key) < 0){
            //放在右边年
            Node nodeRight = put(right,key,value);
            node.setRight(nodeRight);
        }

        if (node.getKey().compareTo(key) == 0){
            node.setValue(value);
        }

        return node;


    }

    /**
     * @Description 中序遍历
     * @Date 2020/11/4 14:33
     * @Param
     * @return
     */
    public List<V> middleShow(){
        if (root == null){
            return new ArrayList<>();
        }

        //先遍历左子树
        return middleShow(root);


    }

    private List<V> middleShow(Node<K,V> root) {
        Node left = root.getLeft();
        Node right = root.getRight();
        ArrayList<V> result = new ArrayList<>();
        //先遍历左子树
        if (left != null){
            List listLeft = middleShow(left);
            result.addAll(listLeft);
        }

        result.add(root.getValue());
        if (right != null){
            List listRight = middleShow(right);
            result.addAll(listRight);
        }

        return result;

    }


    public static void main(String[] args) {
        BinaryTree<Integer, Integer> binaryTree = new BinaryTree<>();
        binaryTree.put(15,15);
        binaryTree.put(9,9);
        binaryTree.put(7,7);
        binaryTree.put(18,18);
        binaryTree.put(20,20);
        binaryTree.put(8,8);

        List<Integer> integers = binaryTree.middleShow();
        for (Integer integer : integers) {

            System.out.println(integer);
        }


    }


}
