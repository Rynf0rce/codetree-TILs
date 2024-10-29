import java.util.*;
import java.io.*;

class point {
    int left, right;
    point(int left, int right){
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        point p = (point) obj;
        return this.left == p.left && this.right == p.right;
    }

    @Override
    public int hashCode(){
        return Objects.hash(left, right);
    }
}

public class Main {
    public static HashSet<point> originHS = new HashSet<>();
    public static HashSet<point> targetHS = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < K ; i++){
            ArrayList<Integer> arr = new ArrayList<>();
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++){
                arr.add(Integer.parseInt(st.nextToken()));
            }

            for(int j = 0 ; j < arr.size() - 1 ; j++){
                for(int k = j + 1 ; k < arr.size() ; k++){
                    point p = new point(arr.get(j), arr.get(k));
                    originHS.add(p);
                }
            }
        }

        int cnt = 0;
        for(point p : originHS){
            if(!originHS.contains(new point(p.right, p.left))){
                cnt++;
            }
        }
        System.out.print(cnt);
    }
}