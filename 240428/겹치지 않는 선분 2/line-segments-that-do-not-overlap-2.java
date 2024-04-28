import java.util.*;
import java.io.*;

class point implements Comparable<point>{
    int x1, x2;
    public point(int x1, int x2){
        this.x1 = x1;
        this.x2 = x2;
    }

    @Override
    public int compareTo(point p){
        return this.x1 - p.x1;
    }
}

public class Main {
    public static final int MAX_LENGTH = 100;
    public static final int MIN_VAL = (int)-1e9;
    public static final int MAX_VAL = (int) 1e9;
    public static point[] arr = new point[MAX_LENGTH + 2];
    public static int[] right = new int[MAX_LENGTH + 2];
    public static int[] left = new int[MAX_LENGTH + 2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 1 ; i <= n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            arr[i] = new point(x1, x2);
        }
        Arrays.sort(arr, 1, n + 1);

        right[0] = MIN_VAL;
        for(int i = 1 ; i <= n ; i++){
            right[i] = Math.max(right[i - 1], arr[i].x2);
        }

        left[n + 1] = MAX_VAL;
        for(int i = n ; i >= 1 ; i--){
            left[i] = Math.min(left[i + 1], arr[i].x2);
        }


        // for(int i = 1 ; i <= n ; i++){
        //     System.out.print(right[i] + " ");
        // }
        // System.out.println();

        // for(int i = 1 ; i <= n ; i++){
        //     System.out.print(arr[i].x2 + " ");
        // }
        // System.out.println();

        // for(int i = 1 ; i <= n ; i++){
        //     System.out.print(left[i] + " ");
        // }

        int ans = 0;
        for(int i = 1 ; i <= n ; i++){
            if(right[i] <= arr[i].x2 && arr[i].x2 <= left[i]){
                ans++;
            }
        }
        System.out.println(ans);
    }
}