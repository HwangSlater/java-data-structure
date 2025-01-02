package com.data_structure.linkedlist;

/**
 * DoublyLinkedList는 양쪽 끝과 중간에서 데이터를 추가하거나 제거할 수 있습니다.
 *
 * @param <T> 이 리스트에 저장될 데이터 타입
 */

public class DoublyLinkedList<T> {
    private Node<T> head; // 리스트의 첫 번째 노드
    private Node<T> tail; // 리스트의 마지막 노드
    private int size = 0; // 리스트에 저장된 요소의 개수

    /**
     * 리스트의 끝에 데이터를 추가합니다.
     * 
     * @param data 리스트에 추가할 데이터
     */
    public void add(T data) {
        add(size, data);
    }

    /**
     * 지정된 인덱스 위치에 데이터를 추가합니다.
     * 
     * @param index 데이터를 추가할 위치
     * @param data  리스트에 추가할 데이터
     * @throws IllegalArgumentException 인덱스가 잘못되었을 경우 발생
     */
    public void add(int index, T data) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException("인덱스가 잘못되었습니다.");
        }

        Node<T> node = new Node<>(data);

        if (index == 0) { // 첫 번째 위치에 삽입할 때
            if (head == null) { // 리스트가 비어 있을 경우
                head = node;
                tail = node;
            } else { // 리스트에 요소가 있을 경우
                node.setNextNode(head);
                head.setPrevNode(node);
                head = node;
            }
        } else if (index == size) { // 마지막 위치에 삽입할 때
            if (tail == null) { // 리스트가 비어 있을 경우
                head = node;
                tail = node;
            } else { // 리스트에 요소가 있을 경우
                tail.setNextNode(node);
                node.setPrevNode(tail);
                tail = node;
            }
        } else { // 중간 위치에 삽입할 때
            Node<T> current = getNode(index);
            node.setNextNode(current);
            node.setPrevNode(current.getPrevNode());
            current.getPrevNode().setNextNode(node);
            current.setPrevNode(node);
        }

        size++;
    }

    /**
     * 지정된 인덱스의 데이터를 삭제합니다.
     * 
     * @param index 삭제할 데이터의 인덱스
     * @throws NullPointerException 삭제할 노드가 없을 경우 발생
     */
    public void remove(int index) {
        Node<T> current = getNode(index);

        if (current == null) {
            throw new NullPointerException("삭제할 노드가 존재하지 않습니다.");
        }

        // 이전 노드와 다음 노드를 연결
        if (current.getPrevNode() != null) {
            current.getPrevNode().setNextNode(current.getNextNode());
        } else {
            // head인 경우, head 갱신
            head = current.getNextNode();
        }

        if (current.getNextNode() != null) {
            current.getNextNode().setPrevNode(current.getPrevNode());
        } else {
            // tail인 경우, tail 갱신
            tail = current.getPrevNode();
        }

        size--;
    }

    /**
     * 지정된 인덱스에 있는 데이터를 반환합니다.
     * 
     * @param index 데이터를 가져올 인덱스
     * @return 지정된 인덱스의 데이터
     * @throws IllegalArgumentException 인덱스가 잘못되었을 경우 발생
     */
    public T get(int index) {
        return getNode(index).getData();
    }

    /**
     * 리스트가 비어 있는지 확인합니다.
     * 
     * @return 리스트가 비어 있으면 true, 그렇지 않으면 false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 리스트의 모든 데이터를 삭제하고 리스트를 비웁니다.
     * head와 tail을 null로 설정합니다.
     */
    public void clear() {
        head = null;
        tail = null;
    }

    /**
     * 리스트에 저장된 요소의 개수를 반환합니다.
     * 
     * @return 리스트에 저장된 요소의 개수
     */
    public int size() {
        return size;
    }

    /**
     * 지정된 인덱스의 노드를 반환합니다.
     * 
     * @param index 노드를 찾을 인덱스
     * @return 지정된 인덱스의 노드
     * @throws IllegalArgumentException 인덱스가 잘못되었을 경우 발생
     */
    private Node<T> getNode(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("index가 size보다 크거나 0보다 작습니다.");
        }

        Node<T> current;
        if (index > size / 2) {
            // index가 리스트 후반에 있을 경우 tail에서부터 탐색
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.getPrevNode();
            }
        } else {
            // index가 리스트 앞부분에 있을 경우 head에서부터 탐색
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNextNode();
            }
        }

        return current;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.getData());

            if (current.getNextNode() != null) {
                sb.append(", ");
            }
            current = current.getNextNode();
        }
        sb.append("]");

        return sb.toString();
    }
}
