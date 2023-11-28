import java.util.*;

public class Main {
    public static char[][] arr2D;
    public static boolean inRange(int row, int column){
        if(row >= 0 && column >= 0 && row < arr2D.length && column < arr2D[0].length){
            return true;
        }
        else{
            return false;
        }
    }
    public static int conFnc(int row, int column){
        int[] arrRow = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
        int[] arrColumn = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
        int cnt = 0, total = 0;
        for(int i = 0 ; i < arrRow.length ; i++){
            int tempRow = row;
            int tempColumn = column;
            cnt = 0;
            while(true){
                tempRow += arrRow[i];
                tempColumn += arrColumn[i];
                if(inRange(tempRow, tempColumn)){
                    if(arr2D[tempRow][tempColumn] == 'E'){
                        cnt++;
                    }
                    else{
                        break;
                    }
                }
                else{
                    break;
                }
            }
            if(cnt>=2){
                total++;
            }
        }
        return total;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt(), cnt = 0;
        arr2D = new char[N][M];
        for(int i = 0 ; i < arr2D.length ; i++){
            String str = sc.next();
            for(int j = 0 ; j < arr2D[i].length ; j++){
                arr2D[i][j] = str.charAt(j);
            }
        }

        for(int i = 0 ; i < arr2D.length ; i++){
            for(int j = 0  ; j < arr2D[i].length ; j++){
                if(arr2D[i][j] == 'L'){
                    cnt += conFnc(i,j);
                    //  System.out.println(i + " " + j + " " + cnt);
                }
            }
        }
        System.out.print(cnt);
    }
}