import java.util.*;

public class Main {
    public static boolean judgeplay(int x_edge, int y_edge, int x, int y){
        if(x >= 1 && x <= x_edge && y >= 1 && y <= y_edge){
            return true;
        }
        else{
            return false;
        }
    }
    public static void conFnc(int[][] arr2D, int row, int column, int time, char direction){
        int temRow = row;
        int temColumn = column;
        int[] arrRow = new int[]{-1,0,1,0};
        int[] arrColumn = new int[]{0,1,0,-1};
        int idx = 0;
        switch(direction){
            case 'U':
                idx = 0;
                break;
            case 'R' : 
                idx = 1;
                break;
            case 'D' :
                idx = 2;
                break;
            case 'L' :
                idx = 3;
                break;
        }

        for(int i = 0 ; i < time ; i++){
            temRow = row + arrRow[idx]; // x와 y 이 좌표값이 아닌 행렬이기 때문.
            temColumn = column + arrColumn[idx];
            // System.out.println("temp" + temRow + " " + temColumn);
            if(judgeplay(arr2D.length, arr2D[0].length, temColumn,temRow)){
                row = temRow;
                column = temColumn;
            }
            else{
                idx = (idx + 2) % 4;
            }
            // System.out.println("moto" + row + " " + column);
        }
        System.out.println(row + " " + column);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int edge = sc.nextInt(), time = sc.nextInt(), row = sc.nextInt(), column = sc.nextInt();
        char direction = sc.next().charAt(0);

        //test
        // edge = 26;
        // time = 41;
        // row = 8;
        // column = 3;
        // direction = 'D';

        int[][] arr2D = new int[edge][edge];
        conFnc(arr2D, row, column, time, direction);
    }
}