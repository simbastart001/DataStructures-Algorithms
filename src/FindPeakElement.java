// https://leet-code.com/problems/peak-index-in-a-mountain-array/

public class FindPeakElement {
    public static void main(String[] args) {

    }

    /*
    1) if element[mid] > element[mid+1] => You in the decreasing part of the array
            end = mid   :: because checking the left side
    2) if element[mid] < element[mid+1] => You in the increasing part of the array
            start = mid + 1
    3) When will the loop break?
            when start = end i.e => when both becomes the middle element
     */

    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid + 1]) {
//                you in the decreasing part of the array
//                possibly might be the answer but check on the left side
//                this is why end != mid -1
                end = mid;
            } else {
//                you are in the increasing part of the array
                start = mid + 1; // because we know that mid+1 element > mid[element]

            }
        }

//        in the end, start = end and pointing to the largest number
//        always start & end are trying to find the max element in the above checks
//        hence when they both point to the same element, aha thats the largest number in the array
        return start; // or return end;
    }
}
