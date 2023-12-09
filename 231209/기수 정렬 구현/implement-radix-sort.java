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

/*
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static final int MAX_N = 100000;
    public static final int MAX_K = 6;
    public static final int MAX_DIGIT = 10;
    
    public static int n;
    public static int[] arr = new int[MAX_N];

    public static void radixSort() {
        int p = 1;
        for(int pos = 0; pos < MAX_K; pos++) {
            ArrayList<Integer>[] arrNew = new ArrayList[MAX_DIGIT];
            for(int i = 0; i < MAX_DIGIT; i++)
                arrNew[i] = new ArrayList<>();
            
            for(int i = 0; i < n; i++) {
                int digit = (arr[i] / p) % 10;
                arrNew[digit].add(arr[i]);
            }

            int index = 0;
            for(int i = 0; i < MAX_DIGIT; i++)
                for(int j = 0; j < arrNew[i].size(); j++)
                    arr[index++] = arrNew[i].get(j);
            
            p *= 10;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 입력
        n = sc.nextInt();
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        radixSort();

        for(int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}
*/
