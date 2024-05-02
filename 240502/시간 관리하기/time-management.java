import java.util.*;
import java.io.*;

class schedule implements Comparable<schedule>{
    int time, end;
    public schedule(int time, int end){
        this.time = time;
        this.end = end;
    }
    @Override
    public int compareTo(schedule s){
        if(this.end == s.end){
            return s.time - this.time;
        }
        return s.end - this.end;
    }
}

public class Main {
    public static final int MAX_LENGTH = 1000;
    public static schedule[] arr = new schedule[MAX_LENGTH];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int time = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[i] = new schedule(time, end);
        }

        Arrays.sort(arr, 0 , n);

        int curTime = 0;
        for(int i = 0 ; i < n ; i++){
            if(i == 0){
                curTime = arr[i].end;
            }
            else if(curTime >= 0){
                curTime = Math.min(curTime, arr[i].end);
            }
            else{
                System.out.print(-1);
                System.exit(0);
            }

            curTime -= arr[i].time;
        }
        System.out.print(curTime >= 0 ? curTime : -1);
    }
}