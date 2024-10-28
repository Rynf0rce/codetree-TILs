import java.util.*;
import java.io.*;

class point implements Comparable<point>{
    int x, y;
    public point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(point p){
        if(this.x == p.x){
            return this.y - p.y;
        }
        else{
            return this.x - p.x;
        }
    }
}

public class Main {
    public static final int INVAILD = (int)1e9;
    public static ArrayList<point> arr = new ArrayList<>();
    

    public static double dist(point p1, point p2){
        return Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr.add(new point(x, y));
        }
        
        Collections.sort(arr);

        double ans = INVAILD;
        for(int i = 1 ; i < arr.size() ; i++){
            ans = Math.min(ans, dist(arr.get(i - 1), arr.get(i)));
        }

        Collections.sort(arr, new Comparator<point>(){
            @Override
            public int compare(point p1, point p2){
                if(p1.y == p2.y){
                    return p1.x - p2.x;
                }
                else{
                    return p1.y - p2.y;
                }
            }
        } );

        for(int i = 1 ; i < arr.size() ; i++){
            ans = Math.min(ans, dist(arr.get(i - 1), arr.get(i)));
        }

        System.out.printf(String.format("%.0f", ans));
    }
}