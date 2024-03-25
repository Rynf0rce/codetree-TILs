import java.util.*;

public class Main {
    public static final int MAX_LENGTH = 1024;
    public static int[][] table = new int[MAX_LENGTH + 1][MAX_LENGTH + 1];
    public static int[][] preTable = new int[MAX_LENGTH + 1][MAX_LENGTH + 1];

    public static int calSum(int r1, int c1, int r2, int c2){
        return preTable[r2][c2] - preTable[r1 - 1][c2] - preTable[r2][c1 - 1] + preTable[r1 - 1][c1 - 1];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                table[i][j] = sc.nextInt();
            }
        }

        for(int i = 1 ; i <= n ; i++){
            for(int j =  1 ; j <= n ; j++){
                preTable[i][j] = table[i][j] + preTable[i - 1][j] + preTable[i][j - 1] - preTable[i - 1][j - 1];
            }
        }

        
        for(int i = 0 ; i < q ; i++){
            int c1 = sc.nextInt();
            int r1 = sc.nextInt();
            int c2 = sc.nextInt();
            int r2 = sc.nextInt();
            System.out.println(calSum(r1, c1, r2, c2));
        }
    }
}

/*
import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 1024;
    public static int[][] table = new int[MAX_LENGTH + 1][MAX_LENGTH + 1];
    public static int[][] preTable = new int[MAX_LENGTH + 1][MAX_LENGTH + 1];

    public static int calSum(int r1, int c1, int r2, int c2){
        return preTable[r2][c2] - preTable[r1 - 1][c2] - preTable[r2][c1 - 1] + preTable[r1 - 1][c1 - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i <= n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= n ; j++){
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1 ; i <= n ; i++){
            for(int j =  1 ; j <= n ; j++){
                preTable[i][j] = table[i][j] + preTable[i - 1][j] + preTable[i][j - 1] - preTable[i - 1][j - 1];
            }
        }

        
        for(int i = 0 ; i < q ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int c1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            System.out.println(calSum(r1, c1, r2, c2));
        }
    }
}
*/