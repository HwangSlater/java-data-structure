package com.data_structure;

import com.data_structure.linked.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        list.addLast(1);
        list.addLast(2);
        list.add(2, 6);
        System.out.println(list);
    }
}
