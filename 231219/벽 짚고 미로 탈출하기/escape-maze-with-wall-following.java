import java.util.*;

public class Main {
    public static final int MAX_RANGE = 100;
    public static char[][] arr2D = new char[MAX_RANGE][MAX_RANGE];
    public static int[] arrR = new int[]{0, 1, 0, -1};
    public static int[] arrC = new int[]{1, 0, -1, 0};
    public static int[] handOrder = new int[]{1, 2, 3, 0};
    public static int range;
    public static int direction = 0;

    public static boolean inRange(int row, int column){
        return (row >= 0 && row < range && column >= 0 && column < range);
    }

    public static boolean frontwall(int row, int column){
        int chackRow = row + arrR[direction];
        int chackColumn = column + arrC[direction];
        return (inRange(chackRow, chackColumn) && arr2D[chackRow][chackColumn] == '#');
    }

    public static boolean chackWall(int row, int column){
        int rightHand = handOrder[direction];

        row += arrR[rightHand];
        column += arrC[rightHand];
        if(inRange(row, column) && arr2D[row][column] == '#'){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), r = sc.nextInt() - 1, c = sc.nextInt() - 1;
        range = n;

        for(int i = 0 ; i < n ; i++){
            String str = sc.next();
            for(int j = 0 ; j < n ; j++){
                arr2D[i][j] = str.charAt(j);
            }
        }

        int tempR = r, tempC = c, cnt = 0;
        while(true){
            if(frontwall(tempR, tempC)){
                direction--;
                if(direction < 0){
                    direction = 3;
                }
                continue;
            }

            if(!chackWall(tempR, tempC)){
                direction = (direction + 1) % 4;
            }

            tempR += arrR[direction];
            tempC += arrC[direction];
            cnt++;
            if(tempR == r && tempC == c){
                System.out.println(-1);
                break;
            }
            else if(!inRange(tempR, tempC)){
                System.out.println(cnt);
                break;
            }
        }
    }
}