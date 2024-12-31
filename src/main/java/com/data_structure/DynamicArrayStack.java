package com.data_structure;

import java.util.Arrays;

import com.data_structure.exceptions.StackOverflowException;
import com.data_structure.exceptions.StackUnderflowException;

/**
 * 동적 배열 기반 스택 클래스입니다. 이 클래스는 스택의 크기가 고정되어 있지 않으며,
 * 스택이 가득 차면 내부 배열 크기를 자동으로 확장하여 데이터를 저장합니다.
 * 
 * @param <T> 스택에 저장될 데이터의 타입
 */
public class DynamicArrayStack<T> {
    private Object[] stack = new Object[10]; // 스택을 저장할 배열
    private int size = 0; // 스택에 현재 저장된 데이터 수

    /**
     * 스택의 가장 위에 데이터를 추가합니다.
     * 
     * @param data 스택에 추가할 데이터
     * @throws StackOverflowException 스택이 가득 차면 예외를 던짐
     */
    public void push(T data) {
        if (size == stack.length) {
            stack = Arrays.copyOf(stack, size * 2);
        }

        stack[size++] = data;
    }

    /**
     * 스택에서 가장 위의 데이터를 제거하고 반환합니다.
     * 
     * @return 스택에서 가장 위에 있던 데이터
     * @throws StackUnderflowException 스택이 비어있을 때 예외를 던짐
     */
    @SuppressWarnings("unchecked")
    public T pop() {
        if (size == 0) {
            throw new StackUnderflowException("스택이 비어있습니다.");
        }

        return (T) stack[--size];
    }

    /**
     * 스택의 가장 위에 있는 데이터를 확인하지만, 제거하지 않습니다.
     * 
     * @return 스택의 가장 위에 있는 데이터
     * @throws StackUnderflowException 스택이 비어있을 경우 예외를 던짐
     */
    @SuppressWarnings("unchecked")
    public T peek() {
        if (size == 0) {
            throw new StackUnderflowException("스택이 비어있습니다.");
        }

        return (T) stack[size - 1];
    }

    /**
     * 스택이 비어 있는지 확인합니다.
     * 
     * @return 스택이 비어 있으면 true, 아니면 false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 스택에 저장된 데이터의 개수를 반환합니다.
     * 
     * @return 스택에 저장된 데이터의 수
     */
    public int size() {
        return size;
    }

    /**
     * 스택에 저장된 모든 데이터를 제거합니다.
     */
    public void clear() {
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(stack[i]);

            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");

        return sb.toString();
    }
}
