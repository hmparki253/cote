package sort;

public class QuickSort {
    
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        QuickSort qs = new QuickSort();
        qs.quickSort(arr, 0, n-1);

        System.out.println("정렬된 배열:");
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 피벗을 정하고, 피벗을 기준으로 배열을 두 부분으로 분할합니다.
            int pi = partition(arr, low, high);

            // 피벗을 제외한 왼쪽 부분을 재귀적으로 정렬합니다.
            quickSort(arr, low, pi - 1);

            // 피벗을 제외한 오른쪽 부분을 재귀적으로 정렬합니다.
            quickSort(arr, pi + 1, high);
        }
    }

    int partition(int[] arr, int low, int high) {
        // 피벗 (이 경우에는 배열의 마지막 요소)
        int pivot = arr[high];

        // 작은 요소의 인덱스
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            // 현재 요소가 피벗보다 작으면,
            if (arr[j] < pivot) {
                i++;

                // 요소를 교환합니다.
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // 피벗을 올바른 위치로 교환합니다.
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
