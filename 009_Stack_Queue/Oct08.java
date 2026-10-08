
public class Oct08 {

    // ! ============= LC556. Next Greater Element III =============
    /*
    @ TC --> O(log(N) + log(N) + log(N) + log(N)/2 + log(N))
    @ SC --> O(log(N)) --> we are storing the number in array and that is integer so at max we can store 32 integers so negligible
    */
    public static int nextGreaterElement(int num) {
        int n = (int) Math.log10(num) + 1;
        int[] arr = new int[n];
        int ptr = n - 1;
        int temp = num;
        while (temp > 0) {
            arr[ptr--] = temp % 10;
            temp = temp / 10;
        }
        int i = n - 2;
        while (i >= 0 && arr[i] >= arr[i + 1])
            i--;
        if (i < 0)
            return -1;
        int j = n - 1;
        while (j > 0 && arr[j] <= arr[i])
            j--;
        swap(arr, i, j);
        int start = i + 1;
        int end = n - 1;
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
        long res = 0;
        for (i = 0; i < n; i++)
            res = res * 10 + arr[i];
        if (res > Integer.MAX_VALUE)
            return -1;
        return (int) res;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC556. Next Greater Element III ✅