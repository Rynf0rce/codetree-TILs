import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 10000;
    public static int[] preArr = new int[MAX_NODE + 1];
    public static int[] postArr = new int[MAX_NODE + 1];
    public static int postIdx = 1;

    public static void bfs(int start, int end){
        // System.out.println(start + " " + end);
        if(end < start){
            return;
        }

        if(end == start){
            postArr[postIdx++] = preArr[start];
            return;
        }

        int pivot = start;
        for(int i = start + 1 ; i <= end ; i++){
            if(preArr[start] > preArr[i]){
                pivot = i;
            }
        }

        bfs(start + 1, pivot);
        bfs(pivot + 1, end);
        postArr[postIdx++] = preArr[start];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= n ; i++){
            preArr[i] = Integer.parseInt(br.readLine());
        }

        bfs(1, n);

        for(int i = 1 ; i <= n ; i++){
            System.out.println(postArr[i]);
        }
        
    }
}