import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static int[] arrA = new int[MAX_LENGTH];
    public static int[] arrB = new int[MAX_LENGTH];

    public static boolean isSubsequence(int n, int m){
        int i = 0;
        for(int j = 0 ; j < m ; j++){
            while(i < n && arrA[i] != arrB[j]){
                i++;

                if(i > n){
                    return false;
                }   
            }
            i++;
        }
        return true;
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

        bw.write( (isSubsequence(n, m) ? "Yes" : "No") + "");

        br.close();
        bw.close();
    }
}