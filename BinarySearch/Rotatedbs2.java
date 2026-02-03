package BinarySearch;

/* Rotated binary search when start=end=middle i.e
 if the normal array is arr=[2,2,2,2,9,2] and after 
 rotating it twice the array will be [2,9,2,2,2] so the start=mid=end 
 to overcome this situation we'll increase start by 1 and decrease end by 1 i.e
    { start=start+1;
 end=end-1;
}
 */
public class Rotatedbs2 {
    public static void main(String[] args) {
        int[] arr = { 2, 9, 2, 2, 2 };
        System.out.println(findpivotwithduplicates(arr));
    }

    static int findpivotwithduplicates(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            // 4 cases
            int mid = start + (end - start) / 2;
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            } else if (arr[start] == arr[mid] && arr[mid] == arr[end]) {
                // check if start is pivot
                if (arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;
                // check whether end is pivot or not
                if (arr[end - 1] > arr[end - 1])
                    return end - 1;
                end--;
            }
            // left side is sorted so pivot will be in right
            else if (arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
