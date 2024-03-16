import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 10;
    public static int[][] table = new int[MAX_LENGTH][MAX_LENGTH];
    public static int n = -1;
    public static void printTable(){
        int[] arr = new int[n + 1];
        for(int i = 0 ; i < n ; i++){
            int sum = 0;
            for(int j = 0 ; j < n ; j++){
                arr[j] += table[i][j];
                sum += table[i][j];
                System.out.print(table[i][j] + " ");
            }
            arr[n] += sum;
            System.out.println(sum);
        }

        for(int i = 0 ; i < n + 1 ; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < n ; j++){
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        printTable();
    }
}