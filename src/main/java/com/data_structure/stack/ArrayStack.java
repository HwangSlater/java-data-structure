package com.data_structure.stack;

import com.data_structure.exceptions.StackOverflowException;
import com.data_structure.exceptions.StackUnderflowException;

/**
 * ArrayStack 클래스는 배열을 사용하여 스택을 구현한 클래스입니다.
 * 
 * @param <T> 스택에 저장할 요소의 타입
 */
public class ArrayStack<T> {
    private static final int DEFAULT_CAPACITY = 5; // 기본 스택 용량
    private Object[] stack; // 스택을 저장할 배열
    private int size = 0; // 스택에 현재 저장된 데이터 수

    /**
     * 기본 생성자 (기본 용량으로 스택을 생성)
     * 기본 용량은 5로 설정
     */
    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 사용자 지정 용량으로 스택을 생성하는 생성자
     * 
     * @param capacity 스택의 초기 용량
     * @throws IllegalArgumentException capacity가 1보다 작은 경우 예외를 던짐
     */
    public ArrayStack(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("capacity는 0보다 커야합니다.");
        }
        this.stack = new Object[capacity];
    }

    /**
     * 스택의 가장 위에 데이터를 추가합니다.
     * 
     * @param data 스택에 추가할 데이터
     * @throws StackOverflowException 스택이 가득 차면 예외를 던짐
     */
    public void push(T data) {
        if (stack.length == size) {
            throw new StackOverflowException("스택이 가득 찼습니다.");
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
