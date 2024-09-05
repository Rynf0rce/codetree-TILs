import java.util.*;
import java.io.*;

class point implements Comparable<point>{
    int x;
    int val;
    int idx;

    public point(int x, int val, int idx){
        this.x = x;
        this.val = val;
        this.idx = idx;
    }

    @Override
    public int compareTo(point p){
        if(this.x == p.x){
            if(this.val == p.val){
                return this.idx - p.idx;
            }
            else{
                return this.val - p.val;
            }
        }
        return this.x - p.x;
    }
}

public class Main {
    public static final int INVALUED = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        ArrayList<point> pointList = new ArrayList<>();

        int pos = 0;
        for(int i = 0 ; i < K ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int length = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);

            if(dir == 'R'){
                pointList.add(new point(pos, 1, i));
                pos += length;
                pointList.add(new point(pos, -1, i));
            }
            else{
                pointList.add(new point(pos, -1, i));
                pos -= length;
                pointList.add(new point(pos, 1, i));
                
            }
        }

        Collections.sort(pointList);

        // for(int i = 0 ; i < pointList.size() ; i++){
        //     System.out.println(pointList.get(i).x + " " + pointList.get(i).val + " " + pointList.get(i).idx);
        // }

        HashSet<Integer> containSet = new HashSet<>();

        int totalLength = 0;
        int startX = INVALUED;
        for(int i = 0 ; i < pointList.size() ; i++){
            int x = pointList.get(i).x;
            int val = pointList.get(i).val;
            int idx = pointList.get(i).idx;

            if(val == 1){
                containSet.add(idx);
            }
            else{
                containSet.remove(idx);
            }

            if(startX != INVALUED && containSet.size() < N){
                totalLength += Math.abs(x - startX);
                startX = INVALUED;
                
            }
            else if(containSet.size() >= N && startX == INVALUED){
                startX = x;
            }
        }

        bw.write(totalLength + "");

        bw.close();
        br.close();
        
    }
}