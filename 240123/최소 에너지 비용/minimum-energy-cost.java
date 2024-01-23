import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_GAS_STATION = 100000;
    public static final int MAX_COST = 1000000;
    public static int[] costArr = new int[MAX_GAS_STATION + 1];
    public static long[] stationArr = new long[MAX_GAS_STATION + 1];
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n - 1 ; i++){
            costArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        stationArr[0] = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i < n ; i++){
            int prize = Integer.parseInt(st.nextToken());
            stationArr[i] = Math.min(stationArr[i - 1], prize);
        }

        long ans = 0;
        for(int i = 0 ; i < n - 1; i++){
            ans += costArr[i] * stationArr[i];
        }

        bw.write(ans + "");

        bw.close();
        br.close();
    }
}