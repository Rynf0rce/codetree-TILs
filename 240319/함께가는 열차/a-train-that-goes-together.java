import java.util.*;
import java.io.*;

class info implements Comparable<info>{
    long loc, vel;
    public info(long loc, long vel){
        this.loc = loc;
        this.vel = vel;
    }

    @Override
    public int compareTo(info i){
        if(this.loc > i.loc){
            return 1;
        }
        else if(this.loc == i.loc){
            return 0;
        }
        else{
            return -1;
        }
    }
}

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static info[] arr = new info[MAX_LENGTH];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            long loc = Long.parseLong(st.nextToken());
            long vel = Long.parseLong(st.nextToken());
            arr[i] = new info(loc, vel);
        }

        Arrays.sort(arr, 0 , N);

        long minVel = -1;
        int cnt = 0;
        for(int i = N - 1 ; i >= 0 ; i--){
            if(i == N - 1 || minVel >= arr[i].vel){
                minVel = arr[i].vel;
                cnt++;
            }
        }

        System.out.print(cnt);
    }
}