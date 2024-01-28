import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static int[] arrA = new int[MAX_LENGTH];
    public static int[] arrB = new int[MAX_LENGTH];

    public static boolean canSubsequence(int exceptIdx, int n, int m){
        // System.out.println("exceptIdx : " + exceptIdx);
        int[] tempSequence = new int[m - 1];
        int inIdx = 0;
        int referIdx = 0;
        while(inIdx < m - 1){
            if(referIdx == exceptIdx){
                referIdx++;
            }
            tempSequence[inIdx++] = arrB[referIdx++];
        }

        int j = 0;
        int cnt = 0;
        for(int i = 0 ; i < m - 1 ; i++){
            while(j < n && arrA[j] != tempSequence[i]){
                j++;
            }

            if(j >= n){
                break;
            }

            cnt++;

            // System.out.println(i + " " + j + " " + cnt);
            
        }

        if(cnt == m - 1){
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < m ; i++){
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for(int i = 0 ; i < m ; i++){
            if(canSubsequence(i, n, m)){
                ans++;
            }
        }

        bw.write(ans + "");

        br.close();
        bw.close();
    }
}