package sujung.array;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int maxArea = 0;

        while (left < right) {
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            if (currentArea > maxArea) maxArea = currentArea;

            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
