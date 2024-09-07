public class FisrtAndLastPosition {
    public static void main(String[] args) {

        int[] nums = {2, 3, 4, 4, 5, 6, 9, 9, 9, 22};
        int target = 9;
    }

    public int[] searchRange(int[] nums, int target) {

        int[] ans = {-1, 1};
//        check for first occurence if target exists
        ans[0] = searchit(nums, target, true);
        if (ans[0] != -1) {
            ans[1] = searchit(nums, target, false);
        }

        return ans;
    }

    //    function that returns the index value of a target
    int searchit(int[] nums, int target, boolean findStartIndex) {
        int ans = -1;

        int start = 0;
        int end = nums.length - 1;
//        find whether array is sorted in Ascending order or Descending order
        boolean isAscending = nums[start] < nums[end];

        while (start <= end) {
//            find the middle element
            int mid = start + (end - start) / 2;

            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                ans = mid;
                if (findStartIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            //        for an array sorted in ascending order
//            if (isAscending) {
//                if (target < nums[mid]) {
//                    end = mid - 1;
//                } else {
//                    start = mid + 1;
//                }
//            } else {
//                if (target > nums[mid]) {
//                    end = mid - 1;
//                } else {
//                    start = mid + 1;
//                }
//            }
        }

        return ans;
    }
}
