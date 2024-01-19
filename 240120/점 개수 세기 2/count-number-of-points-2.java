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
        return this.x - p.x;
    }

}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        HashSet<point> containSet = new HashSet<>();
        TreeSet<point> pointSet_X = new TreeSet<>();
        TreeSet<point> pointSet_Y = new TreeSet<>(new Comparator<point>() {
        @Override
        public int compare(point p1, point p2) {
            return p1.y - p2.y;
        }
    });
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            point inPoint = new point(x, y);
            
            pointSet_X.add(inPoint);
            pointSet_Y.add(inPoint);

        }

        for(int i = 0 ; i < q ; i++){
            containSet.clear();
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int cnt = 0;

            point startPoint = new point(x1, y1);
            point endPoint = new point(x2, y2);
            
            point curPoint = pointSet_X.ceiling(startPoint);
            while(curPoint != pointSet_X.higher(endPoint)){
                containSet.add(curPoint);
                curPoint = pointSet_X.higher(curPoint);
            }

            curPoint = pointSet_Y.ceiling(startPoint);
            while(curPoint != pointSet_Y.higher(endPoint)){
                if(containSet.contains(curPoint)){
                    cnt++;
                }
                curPoint = pointSet_Y.higher(curPoint);
            }
            bw.write(cnt + "\n");
        }
        br.close();
        bw.close();
    }
}