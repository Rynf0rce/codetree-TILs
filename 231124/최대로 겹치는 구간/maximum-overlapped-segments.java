//1차원 직선 상에 n개의 선분이 놓여 있습니다. 가장 많이 겹치는 구간에서는, 몇 개의 선분이 겹치는지를 구하는 프로그램을 작성해보세요.
// 단, 겹치는 구간을 찾는 문제이므로 끝점에서 닿는 경우는 겹치는 것으로 생각하지 않습니다.

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(), maxVal = Integer.MIN_VALUE;
        int[] arr = new int[201];
        for(int i = 0 ; i < num ; i++){
            int a = sc.nextInt() + 100;
            int b = sc.nextInt() + 100;
            for(int j = a ; j < b ; j++){
                arr[j]++;
            }
        }
        for(int i = 1 ; i < arr.length ; i++){
            if(maxVal < arr[i]){
                maxVal = arr[i];
            }
        }
        System.out.print(maxVal);
    }
}