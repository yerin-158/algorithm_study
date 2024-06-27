package org.example.searchAlgorithm.dfs;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by robin on 6/23/24.
 *
 * @author robin
 * @version 6/23/24.
 * @implNote First created
 */
// 숫자 내림차순으로 검색하게 됨
public class DfsStack {
  Boolean[] visited;
  Stack<Integer> stack = new Stack<>();

  public void findAnswer(Integer[][] nodes, Integer answer) {
    visited = new Boolean[nodes.length];
    Arrays.fill(visited, false);

    stack.push(1); //시작
    while (!stack.empty()) {
      Integer now = stack.pop();

      if (!visited[now - 1]) {
        visited[now - 1] = true;
        System.out.println("첫 방문 : " + now);

        if (answer == now) {
          System.out.println("발견! : " + now);
          return;
        }

        // 연결된 노드를 스택에 추가 (역순으로 추가하여 왼쪽부터 탐색)
        // 오름차순으로 정렬되어있다고 가정할 때, 낮은 수부터 볼 수 있게 됨.
        Integer[] connect = nodes[now - 1];
        for (int i = connect.length - 1; i >= 0; i--) {
          if (!visited[connect[i] - 1]) {
            stack.push(connect[i]);
          }
        }
      }

    };
  }

}
