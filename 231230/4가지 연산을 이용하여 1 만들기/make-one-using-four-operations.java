import java.util.*;

public class Main {
    public static final int MAX_INPUT = 1000000;
    public static final int EDGE = (int)Math.sqrt(MAX_INPUT);
    public static final int NUM_CALCULATION = 4;

    public static Queue<Integer> q = new LinkedList<>();
    public static int[][] table = new int[EDGE][EDGE];
    public static int[][] visited = new int[EDGE][EDGE];
    public static int input;

    public static int calculate(int num, int version){
        switch(version){
            case 0 :
                return num - 1;
            case 1 : 
                return num + 1;
            case 2 :
                if(num % 2 == 0){
                    return num / 2;
                }
                break;
            case 3 :
                if(num % 3 == 0){
                    return num / 3;
                }
                break;
        }
        return num;
    }
    
    public static boolean inRange(int row, int col){
        return (row >= 0 && col >= 0 && row < EDGE && col < EDGE);
    }

    public static boolean canGo(int num){
        int row = (num - 1) / EDGE;
        int col = (num - 1) % EDGE;

        if(num < 1 || num > input * 3 || !inRange(row, col) || visited[row][col] > 0){
            return false;
        }

        return true;
    }

    public static void push(int num, int distance){
        int row = (num - 1) / EDGE;
        int col = (num - 1) % EDGE;
        
        visited[row][col] = distance;
        q.add(num);
    }


    public static int BFS(){

        while(!q.isEmpty()){
            int num = q.poll();
            int numRow = (num - 1) / EDGE;
            int numCol = (num - 1) % EDGE;
            if(num == 1){
                return visited[0][0];
            }

            for(int i = 0 ; i < NUM_CALCULATION ; i++){
                int postNum = calculate(num, i);
                if(canGo(postNum) ){
                    push(postNum, visited[numRow][numCol] + 1);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 0 ; i < EDGE ; i++){
            for(int j = 0 ; j < EDGE ; j++){
                table[i][j] = i * EDGE + j + 1;
            }
        }

        input = sc.nextInt();
        push(input, 1);

        System.out.print(BFS() - 1);
    }
}