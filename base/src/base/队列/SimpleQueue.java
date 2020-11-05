package base.队列;

import java.util.Iterator;

/**
 * SimpleQuene
 * 简单的队列
 * @author: cyx_jay
 * @date: 2020/11/5 9:00
 */
public class SimpleQueue<T> implements Iterable<T> {
    private Node root;
    private int N;

    /**
     * @Description 遍历方法
     * @Date 2020/11/5 9:05
     * @Param
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T>{
        private Node node;
        private MyIterator(){
            node = root;
        }

        @Override
        public boolean hasNext() {
            node = node.next;
            return node != null;
        }

        @Override
        public T next() {
            return node.t;
        }
    }


    private class Node{
        private T t;
        private Node next;

        public Node(T t, Node next) {
            this.t = t;
            this.next = next;
        }
    }

    public SimpleQueue() {
        this.root =  new Node(null,null);
        this.N = 0;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    /**
     * @Description 入队
     * @Date 2020/11/5 9:04
     * @Param
     * @return
     */
    public void enQueue(T t){
        Node crr = root;
        while (crr.next != null){
            crr =crr.next;
        }
        crr.next = new Node(t,null);
        N++;

    }

    //删除
    public T deQueue(){
        if (isEmpty()){
            return null;
        }
        Node node = root.next;
        root.next = root.next.next;
        N--;
        return node.t;
    }


}
