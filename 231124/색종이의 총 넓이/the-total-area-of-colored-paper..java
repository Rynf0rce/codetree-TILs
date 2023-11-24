// 좌표평면위에 가로세로 길이가 8이고 넓이가 64인 색종이가 N장 주어집니다.
//  이 N장 색종이의 각 좌측하단의 꼭지점이 주어졌을 때 모든 색종이가 붙여진 이후의 총 넓이를 구하는 프로그램을 작성해보세요.
// 단, 모든 색종이는 좌표평면위에서 (-100, -100)을 좌측하단으로 (100, 100)을 우측상단으로 하는 정사각형 범위를 벗어나지 않는다고 가정해도 좋습니다.
// 또한 겹치는 영역은 단 한번만 넓이에 포함시킵니다.
// -> 접근법 : 사각형의 넓이 구간을 2차원 행렬로 정의해서 문제를 품
import java.util.*;

public class Main {
    public static void rectArea(int x1, int y1, int x2, int y2, int[][] arr){
        for(int i = x1 ; i < x2 ; i++){
            for(int j = y1 ; j < y2 ; j++){
                arr[i][j] = 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(), area = 0;
        int[][] arr = new int[201][201];
        for(int i = 0 ; i < num ; i++){
            int x1 = sc.nextInt(), y1 = sc.nextInt();
            x1 += 100;
            y1 += 100;
            int x2 = x1 + 8;
            int y2 = y1 + 8;
            rectArea(x1, y1, x2, y2, arr);
        }

        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 0 ; j < arr[i].length ; j++){
                if(arr[i][j] == 1){
                    area++;
                }
            }
        }
        System.out.print(area);
    }
}