import java.util.*;
import java.io.*;

class point implements Comparable<point>{
    int row, col, idx;
    public point(int idx, int row, int col){
        this.idx = idx;
        this.row = row;
        this.col = col;
    }

    @Override
    public int compareTo(point p){
        return this.idx - p.idx;
    }
}

public class Main {
    public static ArrayList<point> arr = new ArrayList<>();
    public static ArrayList<Integer> selected = new ArrayList<>();
    public static point startPoint, endPoint;
    public static int ans = (int)1e9;

    public static int cal(){
        int val = 0;
        PriorityQueue<point> pq = new PriorityQueue<>();

        pq.add(startPoint);
        pq.add(endPoint);
        for(int i : selected){
            pq.add(arr.get(i));
        }

        while(pq.size() > 1){
            point p = pq.poll();
            // System.out.println(p.row + " " + p.col + " " + p.idx);
            val += Math.abs(p.row - pq.peek().row) + Math.abs(p.col - pq.peek().col);
            // System.out.println("val : " + val);
        }

        return val;
    }

    public static void simulation(int idx, int cnt){
        if(cnt == 3){
            ans = Math.min(ans, cal());
            return;
        }

        if(idx >= arr.size()){
            return;
        }

        selected.add(idx);
        simulation(idx + 1, cnt + 1);
        selected.remove(selected.size() - 1);

        simulation(idx + 1, cnt);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < str.length() ; j++){
                if('1' <= str.charAt(j) && str.charAt(j) <= '9'){
                    arr.add(new point(str.charAt(j) - '0', i, j));
                }
                else if(str.charAt(j) == 'S'){
                    startPoint = new point(0, i, j);
                }
                else if(str.charAt(j) == 'E'){
                    endPoint = new point(100, i, j);
                }
            }
        }

        Collections.sort(arr);

        simulation(0, 0);

        // selected.add(0);
        // selected.add(1);
        // selected.add(2);

        // System.out.println(cal());

        System.out.print(ans == (int)1e9 ? -1 : ans);
    }
}