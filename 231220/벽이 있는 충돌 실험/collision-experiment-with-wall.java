import java.util.*;

class unit{
    int row;
    int col;
    int dir;

    unit(int row, int col, int dir){
        this.row = row;
        this.col = col;
        this.dir = dir;
    }

    public void setUnit(int row, int col, int dir){
        this.row = row;
        this.col = col;
        this.dir = dir;
    }

    @Override
    public boolean equals(Object o){
        unit u = (unit) o;
        return (u.row == this.row && u.col == this.col);
    }
}

public class Main {
    public static final int MAX_RANGE = 50;
    public static final int ASCII_NUM = 128;
    public static unit[] beadArr = new unit[MAX_RANGE * MAX_RANGE];
    public static int[] arrR = new int[]{-1, 0, 1, 0};
    public static int[] arrC = new int[]{0, 1, 0, -1};
    public static int range;

    public static boolean inRange(int row, int column){
        return (row >= 0 && column >= 0 && row < range && column < range);
    }
    
    public static int conFnc(int cnt){
        unit[] tempArr = new unit[MAX_RANGE * MAX_RANGE];
        for(int i = 0 ; i < cnt ; i++){
            unit bean = beadArr[i];
            int preRow = bean.row + arrR[bean.dir];
            int preCol = bean.col + arrC[bean.dir];
            if(inRange(preRow, preCol)){
                beadArr[i].setUnit(preRow, preCol, bean.dir);
            }
            else{
                beadArr[i].setUnit(bean.row, bean.col, (bean.dir + 2) % 4);
            }
        }

        int tempIdx = 0;
        for(int i = 0 ; i < cnt ; i++){
            if(inRange(beadArr[i].row, beadArr[i].col)){
                boolean isSame = false;
                for(int j = i + 1 ; j < cnt ; j++){
                    if(beadArr[i].equals(beadArr[j])){
                        beadArr[j].setUnit(-1, -1, -1);
                        isSame = true;
                    }
                }
                if(!isSame){
                    tempArr[tempIdx++] = new unit(beadArr[i].row, beadArr[i].col, beadArr[i].dir);
                }
            }
        }

        for(int i = 0 ; i < tempIdx ; i++){
            beadArr[i] = new unit(tempArr[i].row, tempArr[i].col, tempArr[i].dir);
        }

        return tempIdx;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dirMapper = new int[ASCII_NUM];
        dirMapper['U'] = 0;
        dirMapper['R'] = 1;
        dirMapper['D'] = 2;
        dirMapper['L'] = 3;

        int T = sc.nextInt();

        for(int i = 0 ; i < T ; i++){
            int N = sc.nextInt();
            int M = sc.nextInt();
            range = N;
            for(int j = 0 ; j < M ; j++){
                int r = sc.nextInt() - 1;
                int c = sc.nextInt() - 1;
                char spell = sc.next().charAt(0);
                beadArr[j] = new unit(r, c, dirMapper[spell]);
            }

            for(int j = 0 ; j < 2 * N ; j++){
                M = conFnc(M);
            }

            System.out.println(M);

        }
    }
}