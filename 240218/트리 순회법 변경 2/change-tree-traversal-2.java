import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 100000;
    public static int[] preArr = new int[MAX_NODE + 1];
    public static int[] inArr = new int[MAX_NODE + 1];
    public static int[] left = new int[MAX_NODE + 1];
    public static int[] right = new int[MAX_NODE + 1];
    public static int point = 1;
    public static int n = -1;

    public static int findroot(int start, int end){
        if(start > end || start < 1 || end > n){
            return -1;
        }

        int inIdx = -1;
        for(int i = start ; i <= end ; i++){
            if(inArr[i] == preArr[point]){
                inIdx = i;
                point++;
                break;
            }
        }

        left[inArr[inIdx]] = findroot(start, inIdx - 1);
        right[inArr[inIdx]] = findroot(inIdx + 1, end);

        return inArr[inIdx];
    }

    public static void postOrder(int num){
        if(num == -1){
            return;
        }

        postOrder(left[num]);
        postOrder(right[num]);
        System.out.print(num + " ");
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

        int root = findroot(1, n);

        postOrder(root);

    }
}