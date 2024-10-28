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
    public static final int MAX_LENGTH = 100;
    public static final int INVALID = (int)1e9;
    public static ArrayList<point> arr = new ArrayList<>();
    
    public static int calArea(){
        int maxX = 0;
        int maxY = 0;
        int minX = INVALID;
        int minY = INVALID;

        for(point p : arr){
            maxX = Math.max(maxX, p.x);
            maxY = Math.max(maxY, p.y);
            minX = Math.min(minX, p.x);
            minY = Math.min(minY, p.y);
        }
        return (maxX - minX) * (maxY - minY);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr.add(new point(x,y));
        }


        int ans = INVALID;
        for(int i = 0 ; i < arr.size() ; i++){
            point p = arr.get(0);
            arr.remove(0);
            
            ans = Math.min(ans, calArea());
            arr.add(p);
        }
        
        System.out.print(ans);
        
    }
}