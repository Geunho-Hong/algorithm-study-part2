package guenho.codility;

public class CyclicRotation {
    public static void main(String[] args) {
        //int[] arr = {3, 8, 9, 7, 6};
        int[] arr = {1,2,3,4};

        solution(arr, 4);
    }

    private static int[] solution(int[] arr, int K) {

        if(arr.length == 0) {
            return arr;
        }

        for (int i = 0; i < 4; i++) {
            int[] tempArr = arr.clone();
            int lastNum = arr[arr.length -1];
            for (int j = 0; j < arr.length - 1; j++) {
                arr[j + 1] = tempArr[j];
            }
            arr[0] = lastNum;
        }

        return arr;
    }
}
