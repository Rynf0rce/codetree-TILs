import java.util.*;
import java.io.*;

class point{
    int row;
    int col;
    int dir;
    public point(int row, int col, int dir){
        this.row = row;
        this.col = col;
        this.dir = dir;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        point p = (point) o;
        return row == p.row && col == p.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

}

public class Main {
    public static final int MAX_LENGTH = 100;
    public static HashSet<point> pointSet = new HashSet<>();
    public static Queue<point> q = new LinkedList<>();
    public static int[] arrRow = new int[]{-1, 0, 1, 0};
    public static int[] arrCol = new int[]{0, 1, 0, -1};

    public static boolean inRange(int row, int col, int width){
        return row >= 1 && col >= 1 && row <= width && col <= width;
    }

    public static int simulation(int N){
        for(int i = 0 ; i < 2 * N ; i++){
            for(point p : pointSet){
                int preRow = p.row + arrRow[p.dir];
                int preCol = p.col + arrCol[p.dir];
                if(inRange(preRow, preCol, N)){
                    q.add(new point(preRow, preCol, p.dir));
                }
                else{
                    q.add(new point(p.row, p.col, (p.dir + 2) % 4));
                }

                // System.out.println(preRow + " " + preCol);
                
            }
            // System.out.println();
            pointSet.clear();
            
            while(!q.isEmpty()){
                point curPoint = q.poll();
                if(pointSet.contains(curPoint)){
                    pointSet.remove(curPoint);
                }
                else{
                    pointSet.add(curPoint);
                }
            }
        }
        
        int ans = pointSet.size();
        // for(point p : pointSet){
        //     System.out.println(p.row + " " + p.col);
        // }
        pointSet.clear();
        return ans;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < T ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            for(int j = 1 ; j <= M ; j++){
                st = new StringTokenizer(br.readLine(), " ");
                int row = Integer.parseInt(st.nextToken());
                int col = Integer.parseInt(st.nextToken());
                char dir = String.valueOf(st.nextToken()).charAt(0);
                int d = 0;
                if(dir == 'U'){
                    d = 0;
                }
                else if(dir == 'R'){
                    d = 1;
                }
                else if(dir == 'D'){
                    d = 2;
                }
                else{
                    d = 3;
                }
                pointSet.add(new point(row, col, d));
            }

            System.out.println(simulation(N));
        }
        
    }
}