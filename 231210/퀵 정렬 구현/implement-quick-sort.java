import java.util.*;

public class Main {
    public static final int INPUT_RANGE = 100000;
    public static int[] arr = new int[INPUT_RANGE];
    public static int n;
    public static int setPivot(int start, int end){
        int mid = ( end + start ) / 2;
        if(end - start <= 3){
            return end;
        }
        else{
             if( (arr[start] >= arr[mid] && arr[mid] >= arr[end]) || (arr[end] >= arr[mid] && arr[mid] >= arr[start]) ){
                return mid;
             }
             else if( (arr[start] >= arr[end] && arr[end] >= arr[mid]) || (arr[mid] >= arr[end] && arr[end] >= arr[start]) ){
                return end;
             }
             else{
                return start;
             }
        }
    }
    
    public static int partitionFnc(int start, int end){
        int pivotIdx = setPivot(start, end);
        int temp = arr[end];
        arr[end] = arr[pivotIdx];
        arr[pivotIdx] = temp;

        int partition = -1;

        for(int i = start ; i < end ; i++){
            if(arr[i] < arr[end]){
                partition++;
                temp = arr[partition];
                arr[partition] = arr[i];
                arr[i] = temp;
            }
        }

        temp = arr[partition + 1];
        arr[partition + 1] = arr[end];
        arr[end] = temp;

        return partition + 1;
    }

    public static void quick_sort(int start, int end){
        if(start < end){
            int partition = partitionFnc(start, end);
            quick_sort(start, partition - 1);
            quick_sort(partition + 1, end);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }

        quick_sort(0, n-1);

        for(int i = 0 ; i < n ; i++){
            System.out.print(arr[i] + " ");
        }   
    }
}

/*

function partition(arr[], low, high)
  set pivot = select_pivot(arr, low, high)
  set i = low - 1
  
  for j = low ... j <= high - 1
    if arr[j] < pivot
      i += 1
      swap (arr[i], arr[j])
      
  swap (arr[i + 1], arr[high])
  return i + 1

function quick_sort(arr[], low, high)
  if low < high
    pos = partition(arr, low, high)
    
    quick_sort(arr, low, pos - 1)
    quick_sort(arr, pos + 1, high)
*/