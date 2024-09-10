public class FindRotationCount {
    public static void main(String[] args) {

        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Array is rotated at position " + countRotatoins(arr));
    }

//    case 1) find index of pivot, arr[start] - arr[pivot]
//    case 2) where start > start +1, return index

    static int countRotatoins(int[] arr) {
        int pivot = findPivot(arr);
        return pivot + 1;
    }

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
