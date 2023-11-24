// 첫 번째 직사각형이 먼저 놓여 있고, 두 번째 직사각형이 그 다음 놓아졌을 때 
// 그 이후에 남아있는 첫 번째 직사각형의 잔해물을 덮기 위한 최소 직사각형의 넓이를 구하는 프로그램을 작성해보세요.
// -> 접근법 : 사각형의 넓이 구간을 2차원 행렬로 정의해서 문제를 품
import java.util.*;

public class Main {
    public static void rectArea(int x1, int y1, int x2, int y2, int[][] arr, int idx){
        for(int i = x1 ; i < x2 ; i++){
            for(int j = y1 ; j < y2 ; j++){
                arr[i][j] = idx;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 2;
        int[][] arr = new int[2001][2001];
        for(int i = 0 ; i < num ; i++){
            int x1 = sc.nextInt(), y1 = sc.nextInt(), x2 = sc.nextInt(), y2 = sc.nextInt();
            x1 += 1000;
            y1 += 1000;
            x2 += 1000;
            y2 += 1000;
            rectArea(x1, y1, x2, y2, arr, i+1);
        }

        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 0 ; j < arr[i].length ; j++){
                if(arr[i][j] == 1){
                    if(minX > i){
                        minX = i;
                    }
                    if(minY > j){
                        minY = j;
                    }
                    if(maxX < i){
                        maxX = i;
                    }
                    if(maxY < j){
                        maxY = j;
                    }
                }
            }
        }
        /* System.out.println(maxX);
        System.out.println(minX);
        System.out.println(maxY);
        System.out.println(minY); */
        if(minX == Integer.MAX_VALUE){
            System.out.print(0);
        }
        else{
            System.out.print((maxX - minX + 1) * (maxY - minY + 1));
        }
        
    }
}