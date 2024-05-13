package sort;

public class SelectionSort {
    
    public static void main(String[] args) {
        
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int min_index = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[min_index] > arr[j]) {
                    min_index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
        }

        // 정렬 후 찍기
        for(int i = 0; i < n; i++) {
            System.out. print(arr[i] + " ");
        }
        
    }
}
