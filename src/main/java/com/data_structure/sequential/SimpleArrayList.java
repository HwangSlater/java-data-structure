package com.data_structure.sequential;

import java.util.Arrays;

/**
 * SimpleArrayList는 요소 추가, 삭제, 가져오기 및 필요에 따라 내부 배열 크기 조정 등의 기본 작업을 제공합니다.
 *
 * @param <T> 이 리스트에 저장되는 요소의 타입
 */
public class SimpleArrayList<T> {
    // 요소를 저장할 내부 배열
    private Object[] arrayList = new Object[10];

    // 리스트에 현재 저장된 요소의 개수
    private int size = 0;

    /**
     * 리스트의 끝에 지정된 데이터를 추가합니다.
     * 
     * @param data 리스트에 추가할 데이터
     */
    public void add(T data) {
        add(size, data);
    }

    /**
     * 지정된 인덱스에 데이터를 추가합니다.
     * 
     * @param index 데이터를 추가할 위치
     * @param data  리스트에 추가할 데이터
     * @throws IllegalArgumentException 인덱스가 유효하지 않으면 발생
     */
    public void add(int index, T data) {
        indexIsValid(index);

        // 배열이 꽉 찼으면 크기를 두 배로 확장
        if (arrayList.length == size) {
            arrayList = Arrays.copyOf(arrayList, arrayList.length * 2);
        }

        // 배열의 요소들을 오른쪽으로 밀기 (index부터 size까지)
        System.arraycopy(arrayList, index, arrayList, index + 1, size - index);
        // 새 데이터를 해당 인덱스에 삽입
        arrayList[index] = data;

        size++;
    }

    /**
     * 지정된 인덱스의 데이터를 삭제합니다.
     * 
     * @param index 삭제할 데이터의 인덱스
     * @throws IllegalArgumentException 인덱스가 유효하지 않으면 발생
     */
    public void remove(int index) {
        indexIsValid(index);

        // 해당 인덱스의 데이터를 삭제하고 나머지 데이터를 한 칸씩 왼쪽으로 밀기
        System.arraycopy(arrayList, index + 1, arrayList, index, size - index - 1);

        // 배열 크기를 절반으로 줄이되, 최소 크기는 10으로 유지
        if (size > 10 && size > arrayList.length / 2) {
            arrayList = Arrays.copyOf(arrayList, arrayList.length / 2);
        }

        size--;
    }

    /**
     * 지정된 인덱스에 있는 데이터를 반환합니다.
     * 
     * @param index 데이터를 가져올 인덱스
     * @return 지정된 인덱스의 데이터
     * @throws IllegalArgumentException 인덱스가 유효하지 않으면 발생
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) arrayList[index];
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
     * 리스트에 저장된 요소의 개수를 반환합니다.
     * 
     * @return 리스트에 저장된 요소의 개수
     */
    public int size() {
        return size;
    }

    /**
     * 리스트의 모든 요소를 삭제하고 초기화합니다.
     * 배열은 기본 크기 10으로 설정됩니다.
     */
    public void clear() {
        arrayList = new Object[10];
        size = 0;
    }

    /**
     * 인덱스가 유효한지 체크하는 메서드.
     * 
     * @param index 체크할 인덱스
     * @throws IllegalArgumentException 유효하지 않은 인덱스일 경우 발생
     */
    private void indexIsValid(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index는 0보다 작거나 사이즈보다 큽니다.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(arrayList[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");

        return sb.toString();
    }
}
