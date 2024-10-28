import java.util.*;
import java.io.*;

class point implements Comparable<point>{
    boolean flag;
    int idx;

    public point(boolean flag, int idx){
        this.flag = flag;
        this.idx = idx;
    }

    @Override
    public int compareTo(point p){
        return this.idx - p.idx;
    }
}

public class Main {
    public static final int MAX_LENGTH = 100;
    public static ArrayList<point> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int idx = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);

            if(c == 'G'){
                arr.add(new point(true, idx));
            }
            else{
                arr.add(new point(false, idx));
            }
        }

        Collections.sort(arr);

        int ans = 0;
        for(int i = 0 ; i < arr.size(); i++){
            int gCnt = 0;
            int hCnt = 0;
            point left = arr.get(i);
            for(int j = i ; j < arr.size() ; j++){
                if(arr.get(j).flag){
                    gCnt++;
                }
                else{
                    hCnt++;
                }

                if(gCnt == hCnt){
                    ans = Math.max(arr.get(j).idx - arr.get(i).idx, ans);
                }
            }
        }
        System.out.print(ans);
    }
}