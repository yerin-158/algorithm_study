package org.example.sortAlgorithm.quick;

/**
 * Created by robin on 6/25/24.
 *
 * @author robin
 * @version 6/25/24.
 * @implNote First created
 */
public class RecursionQuickSort {

  // 재귀적으로 정렬
  private void quickSort(int[] arr, int partitionStartIndex, int partitionLastIndex) {
    if (partitionStartIndex >= partitionLastIndex) {
      return;
    }

    int pivotIndex = partitionSort(arr, partitionStartIndex, partitionLastIndex);

    // pivotIndex는 확실하게 정해진 위치이므로 다음 재귀에서 제거된다.
    quickSort(arr, partitionStartIndex, pivotIndex - 1);
    quickSort(arr, pivotIndex + 1, partitionLastIndex);
  }

  private int partitionSort(int[] arr, int partitionStartIndex, int partitionLastIndex) {
    // pivot은 처음, 중간, 마지막 중 하나를 선택하면 된다.
    int pivotIndex = partitionLastIndex;
    int pivotValue = arr[partitionLastIndex];

    // pivot보다 작거나 같은 요소들의 마지막 인덱스
    int minimumLastIndex = partitionStartIndex - 1;

    for (int nowIndex = partitionStartIndex; nowIndex < pivotIndex; nowIndex++) {
      // pivot 기준 왼쪽 값이 더 작은 경우
      if (arr[nowIndex] <= pivotValue) {
        // pivot을 기준으로 작은 값을 왼쪽에 몰아놓고 마지막에 pivot을 중간 위치에 꽂을 것임
        // 그래서 pivot보다 작은 값은 일단 왼쪽으로 밀어버림
        minimumLastIndex++;

        int temp = arr[minimumLastIndex];
        arr[minimumLastIndex] = arr[nowIndex];
        arr[nowIndex] = temp;
      }
    }

    int newPivotIndex = minimumLastIndex + 1;
    int temp = arr[newPivotIndex]; //pivot보다 작거나 같은 리스트들의 마지막 인덱스 = minimumLastIndex, 그 다음 인덱스에 pivot 꽂는다.
    arr[newPivotIndex] = arr[pivotIndex];
    arr[pivotIndex] = temp;

    return newPivotIndex;
  }

  public void sort(int[] arr) {
    quickSort(arr, 0, arr.length - 1);

    for (int value : arr) {
      System.out.print(value + " -> ");
    }
  }
}
