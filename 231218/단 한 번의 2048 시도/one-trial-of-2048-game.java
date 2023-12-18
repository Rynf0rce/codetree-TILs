import java.util.*;

public class Main {
    public static final int ASCII_NUM = 128;
    public static final int MAX_N = 4;

    public static int n = 4;

    public static int[][] area = new int[MAX_N][MAX_N];
    public static int[][] tempArea = new int[MAX_N][MAX_N];

    public static void spin(){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                tempArea[i][j] = 0;
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                tempArea[i][j] = area[n - 1 - j][i];
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                area[i][j] = tempArea[i][j];
            }
        }
    }

    public static void drop(){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                tempArea[i][j] = 0;
            }
        }

        for(int i = 0 ; i < n ; i++){
            int idx = n - 1;
            int value = 0;
            for(int j = n - 1 ; j >= 0 ; j--){
                if(area[j][i] != 0){
                    if(value != area[j][i]){
                        value = area[j][i];
                        tempArea[idx--][i] = area[j][i];
                    }
                    else{
                        tempArea[idx + 1][i] = value * 2;
                        value = 0;
                    }
                }
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                area[i][j] = tempArea[i][j];
            }
        }
    }

    public static void gravity(int spinCnt){
        for(int i = 0 ; i < spinCnt ; i++){
            spin();
        }

        drop();

        for(int i = 0 ; i < 4 - spinCnt ; i++){
            spin();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                area[i][j] = sc.nextInt();
            }
        }

        char dir = sc.next().charAt(0);

        int[] dirMapper = new int[ASCII_NUM];
        dirMapper['D'] = 0;
        dirMapper['R'] = 1;
        dirMapper['U'] = 2;
        dirMapper['L'] = 3;

        gravity(dirMapper[dir]);

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                System.out.print(area[i][j] + " ");
            }
            System.out.println();
        }
    }
}