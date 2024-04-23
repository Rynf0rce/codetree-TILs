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
    public static final int MAX_POINT = 100;
    public static point[] arr = new point[MAX_POINT];

    public static int calArea(point p1, point p2, point p3){
        return Math.abs(p1.x - p2.x) * Math.abs(p2.y - p3.y);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new point(x, y);
        }

        int ans = 0;
        for(int i = 0 ; i < n - 2 ; i++){
            for(int j = i + 1 ; j < n - 1 ; j++){
                for(int k = j + 1 ; k < n ; k++){
                    if(arr[i].y == arr[j].y || arr[j].x == arr[k].x){
                        ans = Math.max(ans, calArea(arr[i], arr[j], arr[k]));
                    }
                }
            }
        }
        System.out.print(ans);
    }
}