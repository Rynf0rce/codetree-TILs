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

    public void setPos(int row, int col){
        this.row = row;
        this.col = col;
    }
    public void setDir(int dir){
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
    public static final int ASCII_NUM = 128;
    public static ArrayList<unit> vector = new ArrayList<>();
    public static HashSet<unit> beadPos = new HashSet<>();
    public static int[] arrR = new int[]{-1, 0, 1, 0};
    public static int[] arrC = new int[]{0, 1, 0, -1};
    public static int n;

    public static boolean inRange(int row, int column){
        return (row >= 0 && column >= 0 && row < n && column < n);
    }

    public static void conFnc(){

        for(int i = 0 ; i < vector.size() ; i++){
            unit input = vector.get(i);
            int preRow = input.row + arrR[input.dir];
            int preColumn = input.col + arrC[input.dir];

            if(inRange(preRow, preColumn)){
                input.row = preRow;
                input.col = preColumn;
            }
            else{
                input.dir = (input.dir + 2) % 4;
            }

            if(!beadPos.contains(input)){
                beadPos.add(input);
                vector.get(i).setPos(input.row, input.col);
                vector.get(i).setDir(input.dir);
            }
            else{
                vector.remove(i);
                for(int j = 0 ; j < vector.size() ; j++){
                    if(input.row == vector.get(j).row && input.col == vector.get(j).col){
                        vector.remove(j);
                    }
                }
            }

        }

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
            n = sc.nextInt();
            int M = sc.nextInt();
            vector.clear();
            for(int j = 0 ; j < M ; j++){
                int r = sc.nextInt() - 1;
                int c = sc.nextInt() - 1;
                char spell = sc.next().charAt(0);
                int dir = dirMapper[spell];
                unit bead = new unit(r, c, dir);
                vector.add(bead);
            }

            // conFnc();
            // beadPos.clear();
            // conFnc();

            // for(int j = 0 ; j < vector.size() ; j++){
            //     System.out.println(vector.get(j).row + " " + vector.get(j).col + " " +  vector.get(j).dir);
            // }
            for(int j = 0 ; j < n * n ; j++){
                beadPos.clear();
                conFnc();
            }
            
            System.out.println(vector.size());
        }
    }
}