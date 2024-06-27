package org.example.sortAlgorithm.quick;

import java.util.Stack;

/**
 * Created by robin on 6/26/24.
 *
 * @author robin
 * @version 6/26/24.
 * @implNote First created
 */
public class StackQuickSort {

  public void quickSort(int[] arr, int partitionStartIndex, int partitionLastIndex) {
    Stack<Integer> stack = new Stack<>();

    // 초기 범위(인덱스)를 푸시
    stack.push(partitionStartIndex);
    stack.push(partitionLastIndex);

    while (!stack.isEmpty()) {
      // 무조건 작은 배열의 시작인덱스, 마지막인덱스 쌍으로 들어갈 것이라서 두개씩 pop하면 됨
      partitionLastIndex = stack.pop();
      partitionStartIndex = stack.pop();

      // 피벗 찾기
      int pivotIndex = partitionSort(arr, partitionStartIndex, partitionLastIndex);

      // 피벗 좌측에 놓을 데이터가 있으면 (피벗보다 작은 값이 있으면 pivotIndex가 startIndex보다 클 것임)
      // 피벗 자리는 고정이기 때문에 빠져야함
      if (pivotIndex - 1 > partitionStartIndex) {
        stack.push(partitionStartIndex);
        stack.push(pivotIndex - 1);
        //partitionStartIndex ~ pivotIndex - 1 가 현재 피봇보다 작은 값들의 배열 시작과 끝
      }

      if (pivotIndex + 1 < partitionLastIndex) {
        stack.push(pivotIndex + 1);
        stack.push(partitionLastIndex);
      }
    }
  }

  public int partitionSort(int[] arr, int partitionStartIndex, int partitionLastIndex) {
    int pivotValue = arr[partitionLastIndex];
    int minimumLastIndex = partitionStartIndex - 1;

    for (int nowIndex = partitionStartIndex; nowIndex < partitionLastIndex; nowIndex++) {
      if (arr[nowIndex] <= pivotValue) {
        minimumLastIndex++;

        int temp = arr[nowIndex];
        arr[nowIndex] = arr[minimumLastIndex];
        arr[minimumLastIndex] = temp;
      }
    }

    int newPivotIndex = minimumLastIndex + 1;
    int temp = arr[newPivotIndex];
    arr[newPivotIndex] = arr[partitionLastIndex];
    arr[partitionLastIndex] = temp;

    return newPivotIndex;
  }

  public void sort(int[] arr) {
    quickSort(arr, 0, arr.length - 1);

    for (int value : arr) {
      System.out.print(value + " -> ");
    }
  }

}
