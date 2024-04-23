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
        return ((p1.x * p2.y + p2.x * p3.y + p3.x * p1.y) - (p2.x * p1.y + p3.x * p2.y + p1.x * p3.y));
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
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n; j++){
                for(int k = 0 ; k < n ; k++){
                    if(i == j || j == k || k == i){
                        continue;
                    }
                    if(arr[i].y == arr[j].y && (arr[i].x == arr[k].x || arr[j].x == arr[k].x)){
                        ans = Math.max(ans, calArea(arr[i], arr[j], arr[k]));
                    }
                }
            }
        }
        System.out.print(ans);
    }
}