package org.example.sortAlgorithm.heap;

/**
 * Created by robin on 6/25/24.
 *
 * @author robin
 * @version 6/25/24.
 * @implNote First created
 */
public class HeapSort {

  private void print(int[] arr) {
    for (int value : arr) {
      System.out.print(value + " - ");
    }
    System.out.println();
  }

  /**
   * 배열의 중간부터 시작하는 것이 효율이 좋다.
   * 정렬할 때는 아래쪽부터 올라오면서 배열에 넣는다. (Bottom-Up)
   * @param arr
   */
  void sortAsc(int arr[]) {
    int n = arr.length;

    // 이진트리 생성
    // rootIndex = i
    // 완전 이진 트리에서 전체 노드수 / 2 이후의 노드들은 리프 노드이다.
    // 최초의 힙 생성
    for (int i = (n / 2) - 1 ; i >= 0 ; i--) {
      createMaxBinaryTree(arr, n, i);
      System.out.print("create heap >> ");
      print(arr);
    }

    // 가장 마지막 노드부터 확인
    for (int i = n - 1; i > 0; i--) {
      int temp = arr[0]; // 루트(가장 큰 요소)를 배열 끝으로 이동
      arr[0] = arr[i];
      arr[i] = temp;

      // 정렬에 성공한 노드(루트 노드이자 배열의 마지막으로 옮겨진 값)를 제외하고 다시 힙 조정
      System.out.print("now state >> ");
      print(arr);
      createMaxBinaryTree(arr, i, 0);
    }

  }

  /**
   * 이진트리 생성 (최대힙) Top-Down
   * @param arr
   * @param n 배열 길이
   * @param rootIndex
   */
  void createMaxBinaryTree(int arr[], int n, int rootIndex) {
    int largestIndex = rootIndex; // i가 트리의 위상 (depth)
    int leftChildIndex = 2 * rootIndex + 1; // 왼쪽 자식
    int rightChildIndex = 2 * rootIndex + 2; // 오른쪽 자식

    // 왼쪽 자식이 부모보다 크면, 가장
    if (leftChildIndex < n && arr[leftChildIndex] > arr[largestIndex]) {
      largestIndex = leftChildIndex;
    }

    // 오른쪽 자식이 부모보다 크면 교환
    if (rightChildIndex < n && arr[rightChildIndex] > arr[largestIndex]) {
      largestIndex = rightChildIndex;
    }

    // 가장 큰 요소가 루트가 아니면, 즉 자식 중에 부모보다 큰 값이 있다면 교환
    if (largestIndex != rootIndex) {
      int temp = arr[rootIndex];
      arr[rootIndex] = arr[largestIndex];
      arr[largestIndex] = temp;

      // 교환되었으면 자식노드로 내려가면서 다시 정렬
      createMaxBinaryTree(arr, n, largestIndex);
    }
  }

  /**
   * 배열의 중간부터 시작하는 것이 효율이 좋다.
   * 정렬할 때는 아래쪽부터 올라오면서 배열에 넣는다. (Bottom-Up)
   * @param arr
   */
  void sortDesc(int arr[]) {
    int n = arr.length;

    // 이진트리 생성
    // rootIndex = i
    // 완전 이진 트리에서 전체 노드수 / 2 이후의 노드들은 리프 노드이다.
    // 최초의 힙 생성
    for (int i = (n / 2) - 1 ; i >= 0 ; i--) {
      createMinBinaryTree(arr, n, i);
      System.out.print("create heap >> ");
      print(arr);
    }

    // 가장 마지막 노드부터 확인
    for (int i = n - 1; i > 0; i--) {
      int temp = arr[0]; // 루트(가장 작은 요소)를 배열 끝으로 이동
      arr[0] = arr[i];
      arr[i] = temp;

      // 정렬에 성공한 노드(루트 노드이자 배열의 마지막으로 옮겨진 값)를 제외하고 다시 힙 조정
      System.out.print("now state >> ");
      print(arr);
      createMinBinaryTree(arr, i, 0);
    }

  }

  /**
   * 이진트리 생성 (최소힙) Top-Down
   * @param arr
   * @param n
   * @param i
   */
  void createMinBinaryTree(int arr[], int n, int rootIndex) {
    int smallestIndex = rootIndex; // i가 트리의 위상 (depth)
    int leftChildIndex = 2 * rootIndex + 1; // 왼쪽 자식
    int rightChildIndex = 2 * rootIndex + 2; // 오른쪽 자식

    // 왼쪽 자식이 부모보다 작으면, 루트와 변경
    if (leftChildIndex < n && arr[leftChildIndex] < arr[smallestIndex]) {
      smallestIndex = leftChildIndex;
    }

    // 오른쪽 자식이 부모보다 작으면, 루트와 변경
    if (rightChildIndex < n && arr[rightChildIndex] < arr[smallestIndex]) {
      smallestIndex = rightChildIndex;
    }

    // 가장 작은 요소가 루트가 아니면, 즉 자식 중에 부모보다 작은 값이 있다면 교환
    if (smallestIndex != rootIndex) {
      int temp = arr[rootIndex];
      arr[rootIndex] = arr[smallestIndex];
      arr[smallestIndex] = temp;

      // 교환되었으면 자식노드로 내려가면서 다시 정렬
      createMinBinaryTree(arr, n, smallestIndex);
    }
  }

}
