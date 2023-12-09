import java.util.*;

public class Main {
    public static final int INPUT_RANGE = 100000;
    public static int[] arr = new int[INPUT_RANGE];
    
    
    public static void radixSort(int digit, int size){
        List<Integer>[] sortedArr = new ArrayList[10];
        for(int i = 0 ; i < sortedArr.length ; i++){
            sortedArr[i] = new ArrayList<Integer>();
        }

        for(int i = 0 ; i < size ; i++){
            int currentVal = arr[i];
            if(digit > 0){
                currentVal /= (int)Math.pow(10, digit);
            }
            currentVal %= 10;
            sortedArr[currentVal].add(arr[i]);
        }

        int idx = 0;
        for(int i = 0 ; i < sortedArr.length ; i++){
            for(int j = 0 ; j < sortedArr[i].size() ; j++){
                arr[idx++] = sortedArr[i].get(j);
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = 0 ; i <= 5 ; i++){
            radixSort(i, n);
        }

        for(int i = 0 ; i < n ; i++){
            System.out.print(arr[i] + " ");
        }
        
    }
}