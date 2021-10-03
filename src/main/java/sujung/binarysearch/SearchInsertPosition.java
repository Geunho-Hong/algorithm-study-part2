package sujung.binarysearch;

public class SearchInsertPosition {

    /**
     * target이 배열 내 존재하면 해당 위치, 없으면 삽입되어야 하는 위치 반환
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
