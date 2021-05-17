package min.array;

import java.util.Arrays;

public class SearchInsertPosition {

    public static void main(String[] args) {
        int result = searchInsert(new int[]{1, 3, 5, 7}, 9);
        System.out.println("result = " + result);
    }

    public static int searchInsert(int[] nums, int target) {
        // 배열 nums 는 정렬되어있는 집합(중복 x) -> 이진 검색 사용 가능
        // O(log N)의 시간복잡도
        int i = Arrays.binarySearch(nums, target);

        if (i < 0) // Arrays.binarySearch() 는 검색할 값이 없으면 들어가야할 인덱스를 음수로 반환
            i = Math.abs(i + 1); // 음수를 절대 값으로 변환

        return i;
    }

}
