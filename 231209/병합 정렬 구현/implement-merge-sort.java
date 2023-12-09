import java.util.*;

public class Main {
    public static final int MAX_RANGE = 100000;
    public static int[] arr = new int[MAX_RANGE];
    public static void mergeSort(int start, int end){
        if(start < end){
            int mid = (end + start) / 2;
            mergeSort(start, mid);
            mergeSort(mid+1, end);
            merge(start, mid, end);
        }

    }
    public static void merge(int start, int mid, int end){
        int i = start, j = mid + 1, idx = 0;
        ArrayList<Integer> tempArr = new ArrayList<>();
        while(i <= mid && j <= end){
            if(arr[i] <= arr[j]){
                tempArr.add(arr[i++]);
                idx++;
            }
            else{
                tempArr.add(arr[j++]);
                idx++;
            }
        }

        while(i <= mid){
            tempArr.add(arr[i++]);
            idx++;
        }

        while(j <= end){
            tempArr.add(arr[j++]);
            idx++;
        }

        for(int k = start ; k < start + idx ; k++){
            arr[k] = tempArr.get(k-start);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        mergeSort(0, n - 1);
        for(int i = 0 ; i < n ; i++){
            System.out.print(arr[i] + " ");
        }
    }
}