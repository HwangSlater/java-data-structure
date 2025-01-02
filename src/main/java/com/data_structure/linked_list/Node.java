package com.data_structure.linked_list;

/**
 * Node는 데이터를 저장하고, 이전 노드와 다음 노드에 대한 참조를 가집니다.
 *
 * @param <T> 노드가 저장할 데이터의 타입
 */
public class Node<T> {
    private Node<T> prevNode = null; // 이전 노드에 대한 참조
    private Node<T> nextNode = null; // 다음 노드에 대한 참조
    private T data; // 노드가 저장할 데이터

    /**
     * 데이터를 저장하는 노드를 생성합니다.
     * 
     * @param data 이 노드가 저장할 데이터
     */
    public Node(T data) {
        this.data = data;
    }

    /**
     * 이 노드에 저장된 데이터를 반환합니다.
     * 
     * @return 이 노드에 저장된 데이터
     */
    public T getData() {
        return data;
    }

    /**
     * 이 노드에 저장된 데이터를 설정합니다.
     * 
     * @param data 설정할 데이터
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * 이 노드의 이전 노드를 반환합니다.
     * 
     * @return 이전 노드
     */
    public Node<T> getPrevNode() {
        return prevNode;
    }

    /**
     * 이 노드의 이전 노드를 설정합니다.
     * 
     * @param prevNode 이전 노드
     */
    public void setPrevNode(Node<T> prevNode) {
        this.prevNode = prevNode;
    }

    /**
     * 이 노드의 다음 노드를 반환합니다.
     * 
     * @return 다음 노드
     */
    public Node<T> getNextNode() {
        return nextNode;
    }

    /**
     * 이 노드의 다음 노드를 설정합니다.
     * 
     * @param nextNode 다음 노드
     */
    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }
}
