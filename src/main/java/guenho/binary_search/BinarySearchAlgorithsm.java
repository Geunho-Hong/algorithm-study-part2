package guenho.binary_search;

import java.util.Arrays;

public class BinarySearchAlgorithsm {
    public static void main(String[] args) {
        int[] arr = {1,3,4,5,2,8,9,10};
        Arrays.sort(arr);
        System.out.println(binarySearch(arr,5));
    }

    private static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            }
        }
        return -1;
    }

}
