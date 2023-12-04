// 이전에는 각영역에 위치되어 있는 값을 2차원 배열에 기록해서 중복 여부 파악
// 이번에는 기하학적으로 접근해서 문제 풀이하는 방법.

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr2D = new int[2][4];
        for(int i = 0 ; i < arr2D.length ; i++){
            for(int j = 0 ; j < arr2D[i].length ; j++){
                arr2D[i][j] = sc.nextInt();
            }
        }

        if(arr2D[0][2] < arr2D[1][0] || arr2D[0][3] < arr2D[1][1] || arr2D[1][2] < arr2D[0][0] || arr2D[1][3] < arr2D[0][1]){
            System.out.println("nonoverlapping");
        }
        else{
            System.out.println("overlapping");
        }
        
    }
}