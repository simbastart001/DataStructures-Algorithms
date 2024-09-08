// https://leet-code.com/problems/search-in-rotated-sorteed-array

public class RotatedSortedArray {
    public static void main(String[] args) {

        int[] arr = {3, 4, 5, 6, 6, 7, 7, 0, 1, 2};
        int thePivot = findPivot(arr);
        System.out.println("The pivot is: " + arr[thePivot]);

        int target = 6;
        System.out.println("Using binarySearch, the element is at position " + search(arr, target));
    }
//    pivot in a RotateSortedArray is the largest number in that array
//    eg 3,4,5,6,7,0,1,2

//    1) Find the pivot
//    2) Search in the first half of the pivot => bS (start, pivot)
//    3) else Search in the second half => bS (pivot +1, end)

    static int search(int[] nums, int target) {
//        int pivot = findPivot(nums);
        int pivot = findPivotWithDuplicates(nums);

//        if pivot not found, it means array is not rotated
        if (pivot == -1) {
//            perform normal binarySearch
            return binarySearch(nums, target, 0, nums.length - 1);
        }
//        if pivot is found, you have 2 ascending sorted arrays
        if (nums[pivot] == target) {
            return pivot;
        }

//        case 2:
        if (target >= nums[0]) {
//            look on the left side, where larger numbers reside
            return binarySearch(nums, target, 0, pivot - 1);
        }

//        case 3:
        return binarySearch(nums, target, pivot + 1, nums.length - 1);
    }

// TODO:    HOW TO FIND PIVOT
//    1) when mid > mid+1 = pivot
//    2)


    static int findPivot(int[] arr) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
//            case1:
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
//            case2:
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
//            case3:
            if (arr[mid] <= start) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
//            case4:
        }

        return Integer.MAX_VALUE;
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
//            find the mid-element
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
//                answer found
                return mid;
            }
        }
        return -1;
    }

    static int findPivotWithDuplicates(int[] arr) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
//            case1:
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
//            case2:
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
//            case3:
//            if elements at start, middle and end are equal :: skip the duplicates
            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
//                skip the duplicates

//     todo:           NB: what if the duplicates are the pivots!!!
//                check if start is not pivot
                if (arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;

//                check if end is not pivot
                if (arr[end] > arr[end - 1]) {
                    return end;
                }
                end--;
            }
//            left side is sorted, pivot should be on the right side
            else if (arr[start] < arr[mid] || arr[start] == arr[mid] && arr[mid] > arr[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return Integer.MAX_VALUE;
    }
}
