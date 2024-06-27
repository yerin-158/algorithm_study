package org.example.dp;

/**
 * Created by robin on 6/26/24.
 *
 * @author robin
 * @version 6/26/24.
 * @implNote First created
 */
public class KnapsackProblem {

  /**
   * 배열 dp는 모든 경우의 수 중 "현재 최대무게"에서의 최대가치값만 저장한다.
   * @param productValue 각 제품의 가치
   * @param productWeight 각 제품의 무게
   * @param maxWeight 배낭의 최대 무게
   * @param productTotalCount 제품의 총 개수
   */
  private int knapsack(int[] productValue, int[] productWeight, int maxWeight, int productTotalCount) {
    // 0인 경우는 0으로 셋팅해서 index와 실제 개수를 혼동하지 않게 처리하므로 +1 씩 해준다.
    int[][] dp = new int[productTotalCount + 1][maxWeight + 1];

    for (int currentItem = 0; currentItem <= productTotalCount; currentItem++) {
      for (int currentLimitWeight = 0; currentLimitWeight <= maxWeight; currentLimitWeight++) {
        //dp 테이블에서 행/열을 +1 씩 했기 때문에, 제공된 제품의 정보는 -1을 해줘야한다.
        int realIndex = currentItem - 1;
        if (currentItem == 0 || currentLimitWeight == 0) {
          // 제품이 없거나, 배낭의 최대 무게가 0인 경우 (기저조건)
          dp[currentItem][currentLimitWeight] = 0;
        } else if (productWeight[realIndex] <= currentLimitWeight) {
          // 현재 배낭의 최대 무게 조건보다 이 상품이 가벼울 때
          // "배낭에 이미 들어있던 것 + 이 상품의 무게 <= 현재 무게 조건"인 모든 경우를 확인해서 가치를 따진다.
          int prevMaxValue = dp[realIndex][currentLimitWeight];
          int remainingWeight = currentLimitWeight - productWeight[realIndex];
          dp[currentItem][currentLimitWeight] =
              Math.max(
                  prevMaxValue, //현재 상품 안들고 가는 경우.
                  productValue[realIndex] + dp[realIndex][remainingWeight] //이미 들어있던 것 + 남은 용량을 채울 수 있는 것 중 가장 가치가 큰 것
              );
        } else {
          dp[currentItem][currentLimitWeight] = dp[realIndex][currentLimitWeight];
        }
      }
    }

    return dp[productTotalCount][maxWeight];
  }

  public void run(int[] productValue, int[] productWeight, int maxWeight) {
    // 최대 가치가 나오려면 어떤 것들을 담아야하는지?
    int productCount = productValue.length;
    int answer = knapsack(productValue, productWeight, maxWeight, productCount);
    System.out.println("value: " + answer);
  }
}
