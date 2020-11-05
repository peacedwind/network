package base.tree;

import base.队列.SimpleQueue;

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

    public int getN() {
        return N;
    }



    public void put(K key, V value){

        this.root  = put(root,key,value);

    }

    private Node<K,V> put(Node<K,V> node, K key, V value) {
        if (node == null){
            N++;
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
    public List<Node<K,V>> middleShow(){
        if (root == null){
            return new ArrayList<>();
        }

        return middleShow(root);

    }

    private List<Node<K,V>> middleShow(Node<K,V> root) {
        Node left = root.getLeft();
        Node right = root.getRight();
        ArrayList<Node<K,V>> result = new ArrayList<>();
        //先遍历左子树
        if (left != null){
            List listLeft = middleShow(left);
            result.addAll(listLeft);
        }

        result.add(root);
        if (right != null){
            List listRight = middleShow(right);
            result.addAll(listRight);
        }

        return result;

    }

    /**
     * @Description 前序遍历
     * @Date 2020/11/5 8:43
     * @Param
     * @return
     */
    public List<Node<K,V>> beforeShow(){
        if (root == null){
            return new ArrayList();
        }

        return beforeShow(root);
    }

    private List<Node<K,V>> beforeShow(Node<K,V> root) {
        //先便利自己
        List<Node<K, V>> result = new ArrayList<>();
        result.add(root);
        //左子树
        Node left = root.getLeft();
        if (left != null){
            result.addAll(beforeShow(left));
        }

        Node right = root.getRight();

        if (right != null){
            result.addAll(beforeShow(right));
        }

        return result;
    }

    /**
     * @Description
     * @Date 2020/11/5 8:51
     * @Param
     * @return
     */
    public List<Node<K,V>>  afterShow(){
        if (root == null){
            return new ArrayList<>();
        }

        return afterShow(root);

    }

    private List<Node<K, V>> afterShow(Node<K, V> root) {


        //先便利自己
        List<Node<K, V>> result = new ArrayList<>();
        //左子树
        Node left = root.getLeft();
        if (left != null){
            result.addAll(beforeShow(left));
        }

        Node right = root.getRight();

        if (right != null){
            result.addAll(beforeShow(right));
        }

        result.add(root);

        return result;

    }

    /**
     * @Description 层序遍历 需要借助队列实现 暂时放下 等写好队列的api了来实现
     * @Date 2020/11/5 8:52
     * @Param
     * @return
     */

    public List<Node<K,V>> tierShow(){
        if (root == null){
            return new ArrayList<>();
        }

        return tierShow(root);
        //return  null;

    }

    private List<Node<K, V>> tierShow(Node<K, V> root) {
        List<Node<K, V>> result = new ArrayList<>();

        SimpleQueue<Node> nodes = new SimpleQueue<>();
        nodes.enQueue(root);
        while (!nodes.isEmpty()){
            Node node = nodes.deQueue();
            //获取左子树
            Node left = node.getLeft();
            if (left != null){
                nodes.enQueue(left);
            }
            //获取右字数
            Node right = node.getRight();
            if (right != null){
                nodes.enQueue(right);
            }

            result.add(node);
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
        binaryTree.put(8,8);

        List<Node<Integer, Integer>> nodes = binaryTree.tierShow();

        System.out.println(nodes);


    }


}
