import java.util.*;

public class Main {
    public static final int MAX_RANGE = 100;
    public static int[] arr = new int[MAX_RANGE + 1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            for(int j = a ; j <= b ; j++){
                arr[j]++;
            }
        }

        boolean output = false;
        for(int i = 1 ; i < arr.length ; i++){
            if(arr[i] == n){
                output = true;
            }
        }
        System.out.println(output ? "Yes" : "No");
    }
}
/*
import java.util.Scanner;

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static int n;
    public static int x1, x2;
    public static int maxX1;
    public static int minX2 = INT_MAX;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        n = sc.nextInt();

        // 시작점 중 가장 뒤에 있는 좌표와 끝점 중 가장 앞에 있는 점의 좌표를 확인합니다.
        for(int i = 0; i < n; i++) {
            x1 = sc.nextInt();
            x2 = sc.nextInt();
            maxX1 = Math.max(maxX1, x1);
            minX2 = Math.min(minX2, x2);
        }
        
        // 만약 어느 한 선분이라도 시작점이 다른 선분의 끝점보다 뒤에 온다면
        // 선분이 전부 겹칠 수 없습니다.
        if(minX2 >= maxX1)
            System.out.print("Yes");
        else
            System.out.print("No");
    }
}
*/
