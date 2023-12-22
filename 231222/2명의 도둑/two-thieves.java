import java.util.*;

public class Main {
    public static final int MAX_RANGE = 10;
    public static final int MAX_ROW_RANGE = 5;
    public static int[][] room = new int[MAX_RANGE][MAX_RANGE];
    public static ArrayList<Integer> posList = new ArrayList<>();
    public static int N; // 변 길이.
    public static int M; // 훔칠 수 있는 길이.
    public static int C; // 무게량.
    public static int maxVal = Integer.MIN_VALUE;

    public static boolean inRange(int row, int col){
        return (row >= 0 && col >= 0 && row < N && col < N);
    }

    public static boolean possible(int r1, int c1, int r2, int c2){
        if(inRange(r1, c1) && inRange(r1, c1 + M - 1) && inRange(r2, c2) && inRange(r2, c2 + M - 1)){
            if((r1 == r2) && (c1 + M - 1 > c2 || c2 + M - 1 > c1)){
                return false;
            }
            return true;
        }
        return false;
    }

    public static int calculationValue(int r1, int c1, int r2, int c2){
        int value = 0;
        int robberA = 0;
        for(int i = c1 ; i < c1 + M ; i++){
            if(robberA + room[r1][i] > C){
                continue;
            }
            robberA += room[r1][i];
            value += (int)Math.pow(room[r1][i], 2);
        }

        int robberB = 0;
        for(int i = c2 ; i < c2 + M ; i++){
            if(robberB + room[r2][i]> C){
                continue;
            }
            robberB += room[r2][i];
            value += (int)Math.pow(room[r2][i], 2);
        }

        return value;
    }

    public static void conFnc(int num){
        if(num > N * N){
            return;
        }

        if(posList.size() >= 2){
            int rowA = posList.get(0) / N;
            int colA = posList.get(0) % N;
            int rowB = posList.get(1) / N;
            int colB = posList.get(1) % N;
            // System.out.println(rowA + " " + colA + " " + rowB + " " + colB);
            if(possible(rowA, colA, rowB, colB)){
                maxVal = Math.max(maxVal, calculationValue(rowA, colA, rowB, colB));
            }
            return;
        }

        for(int i = 0 ; i < N * N ; i++){
            posList.add(num);
            conFnc(num + i);
            posList.remove(posList.size() - 1);
        }

        conFnc(num + 1);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        C = sc.nextInt();

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                room[i][j] = sc.nextInt();
            }
        }

        conFnc(0);
        System.out.print(maxVal);
    }
}