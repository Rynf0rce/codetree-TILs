import java.util.*;

public class Main {
    public static int conFnc(int[] arr){
        int n = 2, product = 1;
        boolean triger = false;
        boolean behaviour = true;
        while(behaviour){
            behaviour = false;
            for(int i = 0 ; i < arr.length ; i++){
                if(arr[i] % n == 0){
                    arr[i] /= n;
                    triger = true;
                }
                if(arr[i] > n){
                    behaviour = true;
                }
            }
            if(triger){
                return conFnc(arr) * n;
            }
            n++;
        }
        for(int i = 0; i < arr.length ; i++){
            product *= arr[i];
        }
        return product;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print(conFnc(arr));
    }
}

/*
import java.util.Scanner;

public class Main {
    public static final int MAX_N = 10;
    
    public static int n;
    public static int[] arr = new int[MAX_N + 1];
    
    // 두 수간의 최소공배수를 구하여 반환합니다.
    public static int lcm(int a, int b) {
        int gcd = 1;
        for(int i = 1; i <= Math.min(a, b); i++) {
            if(a % i == 0 && b % i == 0)
                gcd = i;
        }
    
        return a * b / gcd;
    }
    
    // index번째 까지 인덱스의 숫자 중에 가장 큰 값을 반환합니다.
    public static int getLCMAll(int index) {
        // 남은 원소가 1개라면 그 자신이 답이 됩니다.
        if(index == 1)
            return arr[1];
    
        // 1번째 ~ index - 1번째 원소의 최소공배수를 구한 결과와
        // 현재 index 원소의 최소공배수를 구하여 반환합니다.
        return lcm(getLCMAll(index - 1), arr[index]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 변수 선언 및 입력:
        n = sc.nextInt();
        for(int i = 1; i <= n; i++)
            arr[i] = sc.nextInt();

        // 모든 수의 최소공배수를 구합니다.
        System.out.print(getLCMAll(n));
    }
}
*/