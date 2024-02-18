import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 100000;
    public static int[] preArr = new int[MAX_NODE + 1];
    public static int[] inArr = new int[MAX_NODE + 1];
    public static int[] postArr = new int[MAX_NODE + 1];
    public static int n = -1;
    public static int point = -1;

    public static void dfs(int postStart, int postEnd, int inStart, int inEnd){
        // System.out.println(postStart + " " + postEnd + " " + inStart + " " + inEnd);
        if(postEnd < postStart){
            return;
        }

        if(postStart == postEnd){
            preArr[point--] = postArr[postEnd];
            return;
        }

        int rootIdx = -1;
        for(int i = inStart ; i <= inEnd ; i++){
            if(postArr[postEnd] == inArr[i]){
                rootIdx = i;
                break;
            }
        }

        int left = rootIdx - inStart;
        int right = inEnd - rootIdx;

        dfs(postEnd - right, postEnd - 1, rootIdx + 1, inEnd);
        dfs(postStart, postEnd - right - 1, inStart , rootIdx - 1);

        preArr[point--] = postArr[postEnd];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        point = n;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= n ; i++){
            inArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= n ; i++){
            postArr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, n, 1, n);

        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i <= n ; i++){
            sb.append(preArr[i] + " ");
        }

        System.out.print(sb.toString());
    }
}