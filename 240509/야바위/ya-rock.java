import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100;
    public static int[] leftArr = new int[MAX_LENGTH];
    public static int[] rightArr = new int[MAX_LENGTH];
    public static int[] chackArr = new int[MAX_LENGTH];
    public static boolean[] locArr = new boolean[4];

    public static void swap(int a, int b){
        boolean temp = locArr[a];
        locArr[a] = locArr[b];
        locArr[b] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            leftArr[i] = Integer.parseInt(st.nextToken());
            rightArr[i] = Integer.parseInt(st.nextToken());
            chackArr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for(int i = 1 ; i <= 3 ; i++){
            for(int e = 1 ; e <= 3 ; e++){
                locArr[e]= false;
            }
            locArr[i] = true;
            int cnt = 0;
            for(int j = 0 ; j < N ; j++){
                swap(leftArr[j], rightArr[j]);
                if(locArr[chackArr[j]]){
                    cnt++;
                }
            }
            ans = Math.max(ans, cnt);
        }
        System.out.print(ans);
    }
}