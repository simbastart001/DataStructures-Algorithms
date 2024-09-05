//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int[] arr = {-21, -24, -6, 0, 10, 23, 64, 77, 324, 8141, 1013, 4351};
        int target = 23;
        int ans = basicBinarySearch(arr, target);
        System.out.println("Index of target is " + ans);
    }

    static int basicBinarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
//        find whether array is sorted in Ascending order or Descending order
        boolean isAscending = arr[start] < arr[end];

        while (start <= end) {
//            find the middle element
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            //        for an array sorted in ascending order
            if (isAscending) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

        }

        return -1;
    }
}