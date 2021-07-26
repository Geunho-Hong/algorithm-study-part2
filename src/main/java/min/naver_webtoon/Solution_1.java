package min.naver_webtoon;

import java.util.Arrays;

public class Solution_1 {

    public static void main(String[] args) {
        int[] prices = new int[]{13000, 88000, 10000};
        int[] discounts = new int[]{30, 20};
        int result = solution(prices, discounts);
        System.out.println("result = " + result);
    }

    public static int solution(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);

        int priceIdx = prices.length - 1;
        for (int i = discounts.length - 1; i >= 0; i--) {
            prices[priceIdx] -= prices[priceIdx] * (double) discounts[i] / 100;
            priceIdx--;
        }

        return Arrays.stream(prices).sum();
    }

}
