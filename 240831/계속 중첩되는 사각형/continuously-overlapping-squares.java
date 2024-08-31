import java.util.*;

public class Main {
    public static void rectArea(int x1, int y1, int x2, int y2, int[][] arr, int color){
        for(int i = x1 ; i < x2 ; i++){
            for(int j = y1 ; j < y2 ; j++){
                arr[i][j] = color;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(), area = 0;
        int[][] arr = new int[201][201];
        for(int i = 0 ; i < num ; i++){
            int x1 = sc.nextInt(), y1 = sc.nextInt(), x2 = sc.nextInt(), y2 = sc.nextInt(), color = i % 2;
            x1 += 100;
            y1 += 100;
            x2 += 100;
            y2 += 100;
            rectArea(x1, y1, x2, y2, arr, color);
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