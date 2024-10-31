import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static HashSet<Integer>[] hsArr = new HashSet[MAX_LENGTH + 1];
    public static int[] arr = new int[MAX_LENGTH + 1];
    public static int[] leftArr = new int[MAX_LENGTH];
    public static int[] rightArr = new int[MAX_LENGTH];

    public static void swap(int left, int right){
        hsArr[arr[left]].add(right);
        hsArr[arr[right]].add(left);

        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;    
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        for(int i = 1 ; i <= n ; i++){
            arr[i] = i;
            hsArr[i] = new HashSet<>();
            hsArr[i].add(i);
        }

        for(int i = 0 ; i < k ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            leftArr[i] = Integer.parseInt(st.nextToken());
            rightArr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < k ; j++){
                swap(leftArr[j], rightArr[j]);
            }
        }

        for(int i = 1 ; i <= n ;i++){
            System.out.println(hsArr[i].size());
        }
    }
}