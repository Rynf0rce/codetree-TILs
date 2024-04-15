import java.util.*;
import java.io.*;

class point{
    int row;
    int col;
    public point(int row, int col){
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        point p = (point) o;
        return this.row == p.row && this.col == p.col;
    }
}

public class Main {
    public static final int MAX_LENGTH = 20;
    public static Stack<Integer>[][] table = new Stack[MAX_LENGTH + 1][MAX_LENGTH + 1];
    public static Stack<Integer> moveStack = new Stack<>();
    public static point[] locArr = new point[MAX_LENGTH * MAX_LENGTH + 1];
    public static int n = -1;

    public static boolean inRange(int row, int col){
        return row >= 1 && col >= 1 && row <= n && col <= n;
    }

    public static boolean inArea(int cenRow, int cenCol, int row, int col){
        return cenRow - 1 <= row && row <= cenRow + 1 && cenCol - 1 <= col && col <= cenCol + 1 && !(cenRow == row && cenCol == col);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i <= n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= n ; j++){
                table[i][j] = new Stack<Integer>();
                int num = Integer.parseInt(st.nextToken());
                table[i][j].push(num);
                locArr[num] = new point(i, j);
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < m ; i++){
            int num = Integer.parseInt(st.nextToken());
            point curPoint  = locArr[num];
            point postPoint = locArr[num];

            for(int j = n * n ; j > 0 ; j--){
                point p = locArr[j];
                if(inArea(curPoint.row, curPoint.col, p.row, p.col)){
                    postPoint = new point(p.row, p.col);
                    break;
                }
            }

            if(curPoint == postPoint){
                continue;
            }

            while(table[curPoint.row][curPoint.col].peek() != num){
                moveStack.push(table[curPoint.row][curPoint.col].pop());
            }
            moveStack.push(table[curPoint.row][curPoint.col].pop());

            while(!moveStack.isEmpty()){
                int element = moveStack.pop();
                locArr[element] = postPoint;
                table[postPoint.row][postPoint.col].push(element);
            }
        }

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1; j <= n ; j++){
                if(table[i][j].isEmpty()){
                    System.out.print("None");
                }
                else{
                    while(!table[i][j].isEmpty()){
                        System.out.print(table[i][j].pop() + " ");
                    }
                }
                System.out.println();
            }
        }
    }
}