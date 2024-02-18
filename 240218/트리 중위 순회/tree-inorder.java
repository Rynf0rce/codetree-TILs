import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_DEPTH = 10;
    public static final int MAX_NODE = (int)Math.pow(2, 10) - 1;
    public static int[] arr = new int[MAX_NODE + 1];
    public static int[] BinaryTree = new int[MAX_NODE + 1];
    public static int n = -1;
    public static int point = 0;

    public static void inOrder(int idx){
        if(idx >= Math.pow(2, n)){
            return;
        }

        inOrder(idx * 2);
        BinaryTree[idx] = arr[point++];
        inOrder(idx * 2 + 1);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < (int)Math.pow(2, n) - 1 ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        inOrder(1);
        for(int i = 1 ; i <= n ; i++){
            for(int j = (int)Math.pow(2, i - 1) ; j < (int)Math.pow(2, i) ; j++){
                System.out.print(BinaryTree[j] + " ");
            }
            System.out.println();
        }
    }
}