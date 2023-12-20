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

    @Override
    public int hashCode(){
        return Integer.valueOf(row + col).hashCode();
    }
}

public class Main {
    public static final int MAX_CASE = 100;
    public static final int MAX_RANGE = 50;
    public static final int ASCII_NUM = 128;
    public static unit[][] beadArr = new unit[MAX_CASE][MAX_RANGE * MAX_RANGE];
    public static HashSet<unit> beadPosA = new HashSet<>();
    public static HashSet<unit> beadPosB = new HashSet<>();
    public static int[] arrR = new int[]{-1, 0, 1, 0};
    public static int[] arrC = new int[]{0, 1, 0, -1};
    public static int range;

    public static boolean inRange(int row, int column){
        return (row >= 0 && column >= 0 && row < range && column < range);
    }

    public static int remove(int cnt, int order){
        beadPosA.clear();
        beadPosB.clear();
        for(int i = 0 ; i < cnt ; i++){
            if(!beadPosA.contains(beadArr[order][i])){
                beadPosA.add(beadArr[order][i]);
            }
            else{
                beadPosB.add(beadArr[order][i]);
            }
        }

        beadPosA.removeAll(beadPosB);
        int idx = 0;
        Iterator<unit> iter = beadPosA.iterator();
        for(unit test : beadPosA){
            beadArr[order][idx++] = new unit(test.row, test.col, test.dir);
        }

        return idx;
    }
    
    public static int conFnc(int cnt, int order){
        for(int i = 0 ; i < cnt ; i++){
            unit bean = beadArr[order][i];
            int preRow = bean.row + arrR[bean.dir];
            int preCol = bean.col + arrC[bean.dir];
            if(inRange(preRow, preCol)){
                beadArr[order][i].setUnit(preRow, preCol, bean.dir);
            }
            else{
                beadArr[order][i].setUnit(bean.row, bean.col, (bean.dir + 2) % 4);
            }
        }

        int size = remove(cnt, order);
        return size;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dirMapper = new int[ASCII_NUM];
        dirMapper['U'] = 0;
        dirMapper['R'] = 1;
        dirMapper['D'] = 2;
        dirMapper['L'] = 3;

        int T = sc.nextInt();
        int[] arrN = new int[MAX_CASE];
        int[] arrM = new int[MAX_CASE];

        for(int i = 0 ; i < T ; i++){
            arrN[i] = sc.nextInt();
            arrM[i] = sc.nextInt();
            for(int j = 0 ; j < arrM[i] ; j++){
                int r = sc.nextInt() - 1;
                int c = sc.nextInt() - 1;
                char spell = sc.next().charAt(0);
                beadArr[i][j] = new unit(r, c, dirMapper[spell]);
            }
        }

        int M = 0;

        for(int i = 0 ; i < T ; i++){
            range = arrN[i];
            M = arrM[i];
            int duple = 0;
            for(int j = range * range ; j >= 0 ; j--){
                int ballnum = conFnc(M, i);
                if(j >= 10 && ballnum == M){
                    duple++;
                    j /= duple;
                }
                else{
                    duple = 0;
                }
                M = ballnum;
            }
            System.out.println(M);
        }
    }
}