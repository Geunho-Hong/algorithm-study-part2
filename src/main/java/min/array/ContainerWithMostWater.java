package min.array;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int result = maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println("result = " + result);
    }

    // max =
    // 0  1  2  3  4  5  6  7  8
    // s                       e
    // 1, 8, 6, 2, 5, 4, 8, 3, 7
    public static int maxArea(int[] height) { // O(n)
        int maxArea = 0; // 최대 면적
        int start = 0; // 시작 포인터
        int end = height.length - 1; // 끝 포인터

        while ((end - start) > 0) { // 시작과 끝 포인터가 만나면 종료
            int x = end - start; // x 축 값
            int y = Math.min(height[start], height[end]); // y 축 값

            int area = x * y; // 현재 면적이 더 크면 최대면적 갱신
            if (maxArea < area) {
                maxArea = area;
            }

            if (height[start] < height[end]) { // 높이가 더 높은 원소의 인덱스를 고정시켜놓고 더 낮은 원소의 인덱스를 변경
                start++;
            } else {
                end--;
            }
        }

        return maxArea;
    }

}
