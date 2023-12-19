import java.util.*;

public class Main {
    public static final int MAX_RANGE = 100;
    public static final int ASCII_NUM = 128;
    public static int[][] arr2D = new int[MAX_RANGE][MAX_RANGE];
    public static int[][] dice = new int[][]{{0, 5, 0}, {4, 1, 3}, {0, 2, 0}};
    public static int[] arrR = new int[]{0, 0, -1, 1};
    public static int[] arrC = new int[]{-1, 1, 0, 0};

    public static boolean inRange(int row, int column, int range){
        return (row >= 0 && column >= 0 && row < range && column < range);
    }

    public static void rollDice(char dir){
        switch(dir){
            case 'L' :
                for(int i = 0 ; i <= 1 ; i++){
                    dice[1][i] = dice[1][i+1];
                }
                dice[1][2] = 7 - dice[1][0];
                break;
            case 'R' :
                for(int i = 2 ; i >= 1 ; i--){
                    dice[1][i] = dice[1][i-1];
                }
                dice[1][0] = 7 - dice[1][2];
                break;
            case 'U' :
                for(int i = 0 ; i <= 1 ; i++){
                    dice[i][1] = dice[i+1][1];
                }
                dice[2][1] = 7 - dice[0][1];
                break;
            case 'D' :
                for(int i = 2 ; i >= 1 ; i--){
                    dice[i][1] = dice[i-1][1];
                }
                dice[0][1] = 7 - dice[2][1];
                break;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), r = sc.nextInt() - 1, c = sc.nextInt() - 1;
        int[] dirMapper = new int[ASCII_NUM];
        dirMapper['L'] = 0;
        dirMapper['R'] = 1;
        dirMapper['U'] = 2;
        dirMapper['D'] = 3;

        arr2D[r][c] = 7 - dice[1][1];

        for(int i = 0 ; i < m ; i++){
            char spell = sc.next().charAt(0);
            if(inRange(r + arrR[dirMapper[spell]], c + arrC[dirMapper[spell]], n)){
                rollDice(spell);

                // for(int j = 0 ; j < 3 ; j++){
                //     for(int k = 0 ; k < 3 ; k++){
                //         System.out.print(dice[j][k] + " ");
                //     }
                //     System.out.println();
                // }
                // System.out.println();




                r += arrR[dirMapper[spell]];
                c += arrC[dirMapper[spell]];
                arr2D[r][c] = 7 - dice[1][1];
            }
        }

        int output = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                // System.out.print(arr2D[i][j] + " ");
                output += arr2D[i][j];
            }
            // System.out.println();
        }
        System.out.println(output);
    }
}