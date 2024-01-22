import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static final int MAX_INT = 200000;
    public static int[] lineArr = new int[MAX_INT + 1];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int start = MAX_INT;
        int end = 0;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            start = Math.min(x1, start);
            end = Math.max(end, x2);

            lineArr[x1]++;
            lineArr[x2]--;
        }

        int lineNum = 0;
        int maxVal = 0;
        for(int i = start ; i <= end ; i++){
            lineNum += lineArr[i];
            maxVal = Math.max(maxVal, lineNum);
        }
        
        bw.write(maxVal + "");

        br.close();
        bw.close();
    }
}