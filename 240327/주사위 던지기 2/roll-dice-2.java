import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_CNT = 8;
    public static int[] arr = new int[MAX_CNT];
    public static int N = -1;
    public static int M = -1;
    public static ArrayList<Integer> ansList = new ArrayList<>();

    public static void findAns(int sum, int cnt){
        if(cnt == N){
            if(sum == M){
                for(int i = 0 ; i < N ; i++){
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }
            return;
        }

        for(int i = 1 ; i <= 6 ; i++){
            arr[cnt] = i;
            findAns(sum + i, cnt + 1);
            arr[cnt] = -1;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        findAns(0, 0);
    }
}