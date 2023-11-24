// 좌표평면위에 직사각형 A, B를 먼저 붙이고 그 위에 직사각형 M을 붙였습니다.
// 아직 남아있는 (M으로 덮이지 못한) 직사각형 A, B의 넓이의 합을 구하는 프로그램을 작성해보세요.
// 단, 직사각형 A, B는 겹치지 않게 주어진다고 가정해도 좋습니다.
// -> 접근법 : 사각형의 넓이 구간을 2차원 행렬로 정의해서 문제를 품 A와 B를 1로 두고 M으로 정의 된 영역을 0으로 정의해서 품
import java.util.*;



public class Main {
    public static final int MAX_N = 10;
    public static final int MAX_R = 2001;
    public static final int OFFSET = 1000;

    public static void rectArea(int x1, int y1, int x2, int y2, int[][] arr, int num){
        for(int i = x1 ; i < x2 ; i++){
            for(int j = y1 ; j < y2 ; j++){
                arr[i][j] = num;
            }
        }
    }

    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        int num = 3, area = 0;
        int[][] arr = new int[MAX_R][MAX_R];
        for(int i = 1 ; i <= num ; i++){
            int x1 = sc.nextInt(), y1 = sc.nextInt(), x2 = sc.nextInt(), y2 = sc.nextInt();
            x1 += OFFSET;
            y1 += OFFSET;
            x2 += OFFSET;
            y2 += OFFSET;
            rectArea(x1, y1, x2, y2, arr,i);
        }

        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 0 ; j < arr[i].length ; j++){
                if(arr[i][j] == 1 || arr[i][j] == 2){
                    area++;
                }
            }
        }
        System.out.print(area);
    }
}