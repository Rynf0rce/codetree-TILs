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
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            pointList.add(new point(x1, 1));
            pointList.add(new point(x2, -1));
        }

        Collections.sort(pointList);

        int cnt = 0;
        int maxVal = 0;
        for(int i = 0 ; i < pointList.size() ; i++){
            cnt += pointList.get(i).val;
            maxVal = Math.max(maxVal, cnt);
        }

        bw.write(maxVal + "");

        br.close();
        bw.close();
    }
}