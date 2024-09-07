public class SmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        char[] letters = {'a', 'b', 'i', 'm', 's'};
//        char[] letters = {'a', 'b', 'c', 'd', 'e'};
        char target = 'i';
        System.out.println("Found character is " + nextGreatestLetter(letters, target));
    }

    static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;

        while (start <= end) {
//            find the mid-element
            int mid = start + (end - start) / 2;

            if (target < letters[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return letters[start % letters.length];
    }
}
