// 1번 칸부터 N번째 칸까지 순서대로 총 N개의 칸이 있습니다.
// 이 중 Ai​번째 칸부터 Bi​번째 칸까지 각각 블럭을 1씩 쌓으라는 명령이 총 K번 주어집니다. (1≤i≤K)
// 명령을 다 수행한 이후 1번 칸부터 N번 칸까지 쌓인 블럭의 수 중 최댓값을 출력하는 프로그램을 작성해보세요.

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), num = sc.nextInt();
        int[] arr = new int[101];
        int maxVal = Integer.MIN_VALUE;
        for(int i = 0 ; i < num ; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            for(int j = a ; j <= b ; j++){
                arr[j]++;
            }
        }

        for(int i = 1 ; i <= N ; i++){
            if(maxVal < arr[i]){
                maxVal = arr[i];
            }
        }
        System.out.print(maxVal);
    }
}