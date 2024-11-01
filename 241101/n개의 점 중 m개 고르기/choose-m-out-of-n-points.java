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
    public static ArrayList<point> arr = new ArrayList<>();
    public static ArrayList<point> selected = new ArrayList<>();
    public static int n = 0;
    public static int m = 0;
    public static int ans = (int)1e9;

    public static int dist(point p1, point p2){
        return (int)Math.pow(p1.x - p2.x, 2) + (int)Math.pow(p1.y - p2.y, 2);
    }

    public static int cal(){
        int val = 0;
        for(int i = 0 ; i < selected.size() ; i++){
            for(int j = i + 1 ; j < selected.size() ; j++){
                val = Math.max(val, dist(selected.get(i), selected.get(j)));
            }
        }
        return val;
    }

    public static void simulation(int idx, int cnt){
        if(cnt == m){
            ans = Math.min(ans, cal());
            return;
        }

        if(idx >= n){
            return;
        }

        selected.add(arr.get(idx));
        simulation(idx + 1, cnt + 1);
        selected.remove(selected.size() - 1);

        simulation(idx + 1, cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr.add(new point(x, y));
        }

        simulation(0, 0);

        System.out.print(ans);
    }
}