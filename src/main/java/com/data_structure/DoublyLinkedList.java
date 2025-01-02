package com.data_structure;

public class DoublyLinkedList<T> {
    Node<T> head;
    Node<T> tail;
    int size = 0;

    public void add(T data) {
        add(size, data);
    }

    public void add(int index, T data) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException("인덱스가 잘못되었습니다.");
        }

        Node<T> node = new Node<>(data);

        if (index == 0) { // 첫 번째 위치에 삽입할 때
            if (head == null) {
                head = node;
                tail = node;
            } else {
                node.setNextNode(head);
                head.setPrevNode(node);
                head = node;
            }
        } else if (index == size) { // 마지막 위치에 삽입할 때
            if (tail == null) {
                head = node;
                tail = node;
            } else {
                tail.setNextNode(node);
                node.setPrevNode(tail);
                tail = node;
            }
        } else { // 중간 위치에 삽입할 때
            Node<T> current = getNode(index); // 삽입 위치의 노드 찾기
            node.setNextNode(current);
            node.setPrevNode(current.getPrevNode());
            current.getPrevNode().setNextNode(node);
            current.setPrevNode(node);
        }

        size++;
    }

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

    public T get(int index) {
        return getNode(index).getData();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        head = null;
        tail = null;
    }

    public int size() {
        return size;
    }

    private Node<T> getNode(int index) {
        if (index > size || index < 0) {
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
