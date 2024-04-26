import java.util.*;
import java.io.*;

class line implements Comparable<line>{
    int x1, x2;
    public line(int x1, int x2){
        this.x1 = x1;
        this.x2 = x2;
    }

    @Override
    public int compareTo(line l){
        return this.x1 - l.x1;
    }
}

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static final int MIN_POINT = -10000000;
    public static final int MAX_POINT = 10000000;
    public static final int INVALID = (int)1e9;
    public static line[] arr = new line[MAX_LENGTH + 2];
    public static int[] left = new int[MAX_LENGTH + 2];
    public static int[] right = new int[MAX_LENGTH + 2];
    public static boolean[] removed = new boolean[MAX_LENGTH];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 1 ; i <= n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            arr[i] = new line(x1, x2);
        }

        Arrays.sort(arr, 1, n + 1);

        left[0] = MIN_POINT;
        for(int i = 1 ; i <= n ; i++){
            left[i] = Math.max(left[i - 1], arr[i].x2);
        }

        right[n + 1] = MAX_POINT;
        for(int i = n ; i >= 1 ; i--){
            right[i] = Math.min(right[i + 1], arr[i].x2);
        }

        int ans = 0;
        for(int i = 1 ; i <= n ; i++){
            if(left[i] <= arr[i].x2 && arr[i].x2 <= right[i]){
                ans++;
            }
        }
        System.out.println(ans);
    }
}