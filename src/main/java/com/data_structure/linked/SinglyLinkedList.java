package com.data_structure.linked;

import java.util.NoSuchElementException;

/**
 * SinglyLinkedList는 데이터를 순차적으로 저장하고, 다양한 리스트 조작을 위한 메서드를 제공합니다.
 *
 * @param <T> 리스트에 저장될 데이터의 타입
 */
public class SinglyLinkedList<T> {
    private Node<T> head = null; // 리스트의 첫 번째 노드
    private Node<T> tail = null; // 리스트의 마지막 노드
    private int size = 0; // 리스트에 저장된 요소의 개수

    /**
     * 리스트의 맨 앞에 데이터를 추가합니다.
     * 
     * @param data 추가할 데이터
     */
    public void addFirst(T data) {
        add(0, data);
    }

    /**
     * 리스트의 맨 뒤에 데이터를 추가합니다.
     * 
     * @param data 추가할 데이터
     */
    public void addLast(T data) {
        add(size, data);
    }

    /**
     * 주어진 인덱스 위치에 데이터를 추가합니다.
     * 
     * @param index 데이터를 추가할 위치 (0부터 시작)
     * @param data  추가할 데이터
     */
    public void add(int index, T data) {
        Node<T> node = new Node<>(data);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            indexIsValid(index);

            if (index == 0) {
                node.setNextNode(head);
                head = node;
            } else {
                Node<T> parent = getNode(index - 1);
                Node<T> current = parent.getNextNode();

                parent.setNextNode(node);
                node.setNextNode(current);
                if (current == null) {
                    tail = node;
                }
            }
        }

        size++;
    }

    /**
     * 리스트의 첫 번째 데이터를 제거합니다.
     */
    public void removeFirst() {
        checkNotEmpty();
        remove(0);
    }

    /**
     * 리스트의 마지막 데이터를 제거합니다.
     */
    public void removeLast() {
        checkNotEmpty();
        remove(size - 1);
    }

    /**
     * 주어진 인덱스 위치에 있는 데이터를 제거합니다.
     * 
     * @param index 데이터를 제거할 위치 (0부터 시작)
     */
    public void remove(int index) {
        indexIsValid(index);

        if (index == 0) {
            Node<T> node = head.getNextNode();
            head.setNextNode(null);
            head = node;
        } else {
            Node<T> parent = getNode(index - 1);
            Node<T> current = parent.getNextNode();

            parent.setNextNode(current.getNextNode());
            current.setNextNode(null);

            if (parent.getNextNode() == null) {
                tail = current;
            }
        }

        size--;
        if (isEmpty()) {
            head = null;
            tail = null;
        }
    }

    /**
     * 리스트의 모든 데이터를 제거합니다.
     */
    public void clear() {
        head = null;
        tail = null;
        size = 0;
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
     * 리스트의 크기를 반환합니다.
     * 
     * @return 리스트에 저장된 데이터의 수
     */
    public int size() {
        return size;
    }

    /**
     * 리스트의 첫 번째 데이터를 반환합니다.
     * 
     * @return 리스트의 첫 번째 데이터
     * @throws NoSuchElementException 리스트가 비어 있을 때
     */
    public T getFirst() {
        checkNotEmpty();
        return head.getData();
    }

    /**
     * 리스트의 마지막 데이터를 반환합니다.
     * 
     * @return 리스트의 마지막 데이터
     * @throws NoSuchElementException 리스트가 비어 있을 때
     */
    public T getLast() {
        checkNotEmpty();
        return tail.getData();
    }

    /**
     * 주어진 인덱스 위치에 있는 데이터를 반환합니다.
     * 
     * @param index 데이터의 위치 (0부터 시작)
     * @return 주어진 위치의 데이터
     * @throws IndexOutOfBoundsException 인덱스가 범위를 벗어나면
     */
    public T get(int index) {
        return getNode(index).getData();
    }

    /**
     * 주어진 인덱스에 해당하는 노드를 반환합니다.
     * 
     * @param index 찾고자 하는 노드의 위치 (0부터 시작)
     * @return 주어진 위치에 해당하는 노드
     * @throws IndexOutOfBoundsException 인덱스가 범위를 벗어나면
     */
    private Node<T> getNode(int index) {
        indexIsValid(index);

        Node<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.getNextNode();
        }

        return node;
    }

    /**
     * 리스트가 비어 있는지 확인합니다.
     * 
     * @throws NoSuchElementException 리스트가 비어 있을 때
     */
    private void checkNotEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException("리스트가 비어 있습니다.");
        }
    }

    /**
     * 인덱스가 유효한지 확인합니다.
     * 
     * @param index 확인할 인덱스
     * @throws IndexOutOfBoundsException 인덱스가 범위를 벗어나면
     */
    private void indexIsValid(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("index는 size보다 크거나 0보다 작습니다.");
        }
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
