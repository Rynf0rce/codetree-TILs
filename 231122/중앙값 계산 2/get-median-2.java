import java.util.*;

public class Main {
    public static void median(int[] arr, int length){
        int[] currentArr = Arrays.copyOf(arr, length);
        Arrays.sort(currentArr);
        System.out.print(currentArr[length / 2] + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(), input = 0;
        int[] arr = new int[num];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
            if((i+1) % 2 == 1){
                median(arr, i+1);
            }
        }
    }
}

/*
public class Main {
    public static final int MAX_N = 100;
    
    // 변수 선언
    public static int n;
    public static int[] arr = new int[MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        // 홀수 번째 수를 지날때마다 정렬을 진행한 후 가운데 값을 출력합니다.
        for(int i = 0; i < n; i++) {
            if(i % 2 == 0) {
                // 오름차순 정렬을 진행합니다.
                Arrays.sort(arr, 0, i + 1);
                // 가운데 값을 출력합니다.
                System.out.print(arr[i / 2] + " ");
            }
        }
    }
}
*/