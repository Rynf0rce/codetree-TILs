import java.util.*;

public class Main {
    public static int[] arrA;
    public static int[] arrB;

    public static boolean contain(int idx){
        int[] tempArrB = arrB.clone();
        int cnt = 0;
        for(int i = 0 ; i < tempArrB.length ; i++){
            if(arrA[idx] == tempArrB[i]){
                tempArrB[i] = -1;
                i = -1;
                idx++;
                cnt++;
                if(cnt >= tempArrB.length){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        arrA = new int[N];
        arrB = new int[M];
        for(int i = 0 ; i < arrA.length ; i++){
            arrA[i] = sc.nextInt();
        }
        for(int i = 0 ; i < arrB.length ; i++){
            arrB[i] = sc.nextInt();
        }
        
        int output = 0;
        for(int i = 0 ; i < arrA.length - arrB.length + 1 ; i++){
            if(contain(i)){
                output++;
            }
        }
        System.out.println(output);
    }
}

/* 각 부분을 비교 할 배열의 크기 만큼 짤라서 정렬 시켜서 비교하면 순서 상관없이 비교가 가능하다

    import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static final int MAX_N = 100;
    
    public static int n, m;
    public static int[] arr1 = new int[MAX_N];
    public static int[] arr2 = new int[MAX_N];
    public static int[] tmp = new int[MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++)
            arr1[i] = sc.nextInt();
        for(int i = 0; i < m; i++)
            arr2[i] = sc.nextInt();
        
        Arrays.sort(arr2, 0, m);
        
        // 모든 구간의 시작점을 잡아봅니다.
        int cnt = 0;
        for(int i = 0; i <= n - m; i++) {
            for(int j = 0; j < m; j++)
                tmp[j] = arr1[i + j];
            Arrays.sort(tmp, 0, m);
            
            boolean issame = true;
            for(int j = 0; j < m; j++)
                if(tmp[j] != arr2[j]) {
                    issame = false;
                    break;
                }
            
            if(issame)
                cnt++;
        }
                            
        System.out.print(cnt);
    }
}

*/
