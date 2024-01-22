import java.util.*;
import java.io.*;

class point implements Comparable<point>{
    int x;
    int y;
    int val;
    int idx;

    public point(int x, int y, int val, int idx){
        this.x = x;
        this.y = y;
        this.val = val;
        this.idx = idx;
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
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        ArrayList<point> pointList = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            pointList.add(new point(x1, y, 1, i));
            pointList.add(new point(x2, y, -1, i));
        }

        Collections.sort(pointList);
        TreeSet<Integer> colorSet = new TreeSet<>();
        HashSet<Integer> seenColorSet = new HashSet<>();
        int output = 0;

        for(int i = 0 ; i < pointList.size() ; i++){
            int x = pointList.get(i).x;
            int y = pointList.get(i).y;
            int val = pointList.get(i).val;
            int idx = pointList.get(i).idx;

            if(val == 1){
                colorSet.add(y);
                if(colorSet.first() == y){
                    seenColorSet.add(idx);
                }
            }
            else{
                if(colorSet.first() == y && colorSet.higher(y) != null){
                    seenColorSet.add(idx);
                }
                colorSet.remove(y);
            }
        }

        bw.write(seenColorSet.size() + "");

        br.close();
        bw.close();
    }
}