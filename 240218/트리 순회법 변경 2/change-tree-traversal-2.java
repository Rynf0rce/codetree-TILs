import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 100000;
    public static int[] preArr = new int[MAX_NODE + 1];
    public static int[] inArr = new int[MAX_NODE + 1];
    public static int[] postArr = new int[MAX_NODE + 1];
    public static int postIdx = 1;
    public static int n = -1;

    public static void dfs(int preStart, int preEnd, int inStart, int inEnd){
        if(preStart > preEnd){
            return;
        }

        if(preStart == preEnd){
            postArr[postIdx++] = preArr[preStart];
            return;
        }

        int rootIdx = -1;
        for(int i = inStart ; i <= inEnd ; i++){
            if(preArr[preStart] == inArr[i]){
                rootIdx = i;
                break;
            }
        }

        dfs(preStart + 1, preStart + (rootIdx - inStart), inStart, rootIdx - 1);
        dfs(preStart + (rootIdx - inStart) + 1, preEnd, rootIdx + 1, inEnd);
        postArr[postIdx++] = preArr[preStart];

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= n ; i++){
            preArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= n ; i++){
            inArr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, n, 1, n);

        for(int i = 1 ; i <= n ; i++){
            System.out.print(postArr[i] + " ");
        }

    }
}