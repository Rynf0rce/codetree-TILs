import java.util.*;
import java.io.*;

class point implements Comparable<point>{
    int x;
    int val;

    public point(int x, int val){
        this.x = x;
        this.val = val;
    }

    @Override
    public int compareTo(point p){
        return this.x - p.x;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int n = Integer.parseInt(st.nextToken());
        ArrayList<point> pointList = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            pointList.add(new point(a, 1));
            pointList.add(new point(b, -1));
        }

        Collections.sort(pointList);

        int start = 0;
        int end = 0;
        int cnt = 0;
        int maxVal = 0;

        for(int i = 0 ; i < pointList.size() ; i++){
            int x = pointList.get(i).x;
            int val = pointList.get(i).val;
            if(val == 1){
                if(cnt == 0){
                    start = x;
                }
                cnt++;
            }
            else{
                cnt--;
                if(cnt == 0){
                    end = x;
                    maxVal = Math.max(maxVal, end - start);
                }
            }
        }

        bw.write(maxVal + " ");

        br.close();
        bw.close();
    }
}