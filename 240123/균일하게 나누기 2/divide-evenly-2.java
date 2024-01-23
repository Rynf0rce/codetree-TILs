import java.util.*;
import java.io.*;

class point implements Comparable<point>{
    int x;
    int y; 
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
    public static final int MAX_INT = 1000;
    public static final int MAX_POINT = 1000;
    public static point[] pointArr = new point[MAX_POINT];
    public static int[] quadrantArr = new int[5];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());

        int xAvg = 0;
        int yAvg = 0;


        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            xAvg += x;
            yAvg += y;
            pointArr[i] = new point(x, y);
        }

        xAvg /= N;
        yAvg /= N;

        for(int i = 0 ; i < N ; i++){
            pointArr[i] = new point(pointArr[i].x - xAvg, pointArr[i].y - yAvg);
            
        }
        
        Arrays.sort(pointArr, 0 , N);

        for(int i = 0 ; i < N ; i++){
            if(pointArr[i].x >= 0 && pointArr[i].y >= 0){
                quadrantArr[1]++;
            }
            else if(pointArr[i].x > 0 && pointArr[i].y < 0){
                quadrantArr[4]++;
            }
            else if(pointArr[i].x < 0 && pointArr[i].y > 0){
                quadrantArr[2]++;
            }
            else{
                quadrantArr[3]++;
            }
        }

        int ans = 0;
        for(int i = 1 ; i <= 4 ; i++){
            ans = Math.max(ans, quadrantArr[i]);
        }

        bw.write(ans + "");
        
        br.close();
        bw.close();
    }
}