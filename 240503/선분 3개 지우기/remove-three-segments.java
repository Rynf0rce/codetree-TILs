import java.util.*;
import java.io.*;

class point implements Comparable<point>{
    int a, b;
    public point(int a, int b){
        this.a = a;
        this.b = b;
    }
    @Override
    public int compareTo(point p){
        if(this.a == p.a){
            return p.b - this.a;
        }
        return this.a - p.a;
    }
}

public class Main {
    public static final int MAX_LENGTH = 10;
    public static point[] arr = new point[MAX_LENGTH];

    public static boolean inRange(int idx1, int idx2){
        return !( (arr[idx2].a > arr[idx1].b) || (arr[idx1].a > arr[idx2].b) );
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i] = new point(a, b);
        }
        Arrays.sort(arr, 0, n);
        
        int ans = 0;
        for(int i = 0 ; i < n - 2 ; i++){
            for(int j = i + 1 ; j < n - 1 ; j++){
                for(int k = j + 1 ; k < n ; k++){
                    boolean flag = true;
                    for(int z = 0 ; z < n ; z++){
                        if(z == i || z == j || z == k){
                            continue;
                        }

                        for(int x = z + 1 ; x < n ; x++){
                            if(x == i || x == j || x == k){
                                continue;
                            }

                            if(inRange(z, x)){
                                flag = false;
                                break;
                            }
                        }
                        if(!flag){
                            break;
                        }
                    }

                    if(flag){
                        ans++;
                    }
                }
            }
        }

        System.out.print(ans);

    }
}