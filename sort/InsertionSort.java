package sort;

public class InsertionSort {
    
    public static void main(String[] args) {
        // 가장 맨 앞놈은 정렬 되어있다고 치고
        int[] arr = {0, 9, 1, 8, 2, 7, 3, 6, 4, 5};
        for(int i = 1 ; i < arr.length; i++) {
            for(int j = i; j > 0; j--) {
                if(arr[j] < arr[j-1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                } else break; // 큰 경우 만나면 멈추기
            }
        }

        // 정렬 후 찍기
        for(int i = 0; i < arr.length; i++) {
            System.out. print(arr[i] + " ");
        }
    }
}
