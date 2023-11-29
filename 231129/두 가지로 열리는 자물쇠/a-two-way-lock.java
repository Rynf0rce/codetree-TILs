import java.util.*;

public class Main {
    public static int N;
    public static boolean inRange(int[] arr, int a, int b, int c){
        int[] inputArr = new int[]{a,b,c};
        int cnt = 0;
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = arr[i] - 2 ; j <= arr[i] + 2 ; j++ ){
                int temp = j;
                if(temp <= 0){
                    temp = N + j;
                }
                else if(temp > N){
                    temp -= N;
                }

                if(temp == inputArr[i]){
                    cnt++;
                    break;
                }
            }
        }
        return (cnt == 3);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[] arr = new int[6];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }

        int cnt = 0;
        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= N ; j++){
                for(int h = 1 ; h <= N ; h++){
                    if(inRange(Arrays.copyOfRange(arr, 0 ,3), i,j,h) || inRange(Arrays.copyOfRange(arr, 3 ,arr.length), i,j,h)){
                        cnt++;
                    }
                }
            }
        }
        System.out.print(cnt);
    }
}


/*
// 각자의 값에 있는 것의 절대값의 크기가 2인지만 보면 됨..
import java.util.Scanner;

public class Main {
    public static int n;
    public static int a, b, c;
    public static int a2, b2, c2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        n = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        a2 = sc.nextInt();
        b2 = sc.nextInt();
        c2 = sc.nextInt();
        
        // 모든 조합을 다 만들어 봅니다.
        int cnt = 0;
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++)
                for(int k = 1; k <= n; k++) {
                    // 모든 자리가 주어진 첫 조합과의 거리가 2 이내인지 확인합니다.
                    if((Math.abs(a - i) <= 2 || Math.abs(a - i) >= n - 2) && (Math.abs(b - j) <= 2 || Math.abs(b - j) >= n - 2) && 
                       (Math.abs(c - k) <= 2 || Math.abs(c - k) >= n - 2))
                        cnt++;
                    
                    // 모든 자리가 주어진 두번째 조합과의 거리가 2 이내인지 확인합니다.
                    else if((Math.abs(a2 - i) <= 2 || Math.abs(a2 - i) >= n - 2) && (Math.abs(b2 - j) <= 2 || Math.abs(b2 - j) >= n - 2) && 
                       (Math.abs(c2 - k) <= 2 || Math.abs(c2 - k) >= n - 2))
                        cnt++;
                }
        
        System.out.print(cnt);
    }
}
*/
