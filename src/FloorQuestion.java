public class FloorQuestion {
    public static void main(String[] args) {

        int[] arr = {-21, -24, -6, 0, 10, 23, 64, 77, 324, 1013, 4351};
        int target = 25;
        int ans = floor(arr, target);
        System.out.println("Floor index is " + ans);
    }

    //    return the index of smallest no <= target
    static int floor(int[] arr, int target) {
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
        return end;
    }
}
