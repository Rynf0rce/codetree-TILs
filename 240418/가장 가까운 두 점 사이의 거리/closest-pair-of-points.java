import java.util.*;
import java.io.*;

class point{
    int x, y;
    public point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    public static final int MAX_LENGTH = 100;
    public static final int MAX_INT = (int)1e9;
    public static point[] arr = new point[MAX_LENGTH];
    public static int length(point p1, point p2){
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new point(x, y);
        }

        int ans = MAX_INT;
        for(int i = 0 ; i < n - 1; i++){
            for(int j = i + 1 ; j < n ; j++){
                ans = Math.min(ans, length(arr[i], arr[j]));
            }
        }
        System.out.print(ans);
    }
}