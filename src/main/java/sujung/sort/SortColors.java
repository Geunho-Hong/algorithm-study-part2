package sujung.sort;

public class SortColors {

    /**
     * 배열(원소 0, 1, 2로 구성)을 정렬한다.
     * @param nums
     */
    public void sortColors(int[] nums) {
        int index0 = 0;
        int index2 = nums.length - 1;
        int i = 0;
        while(i <= index2) {
            if(nums[i] == 0) {
                swap(nums, index0, i);
                index0++;
                i++;
            } else if(nums[i] == 2) {
                swap(nums, index2, i);
                index2--;
                // 뒤에 있던 값(아직 보지 않은 값)이 현재 인덱스로 오므로 증가할 필요 없음
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
