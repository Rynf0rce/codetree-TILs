import java.util.*;
import java.io.*;

class schedule implements Comparable<schedule>{
    int start, end;
    public schedule(int start, int end){
        this.start = start;
        this.end = end;
    }
    @Override
    public int compareTo(schedule s){
        if(this.start == s.start){
            return s.end - this.end;
        }
        return this.start - s.start;
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
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[i] = new schedule(start, end);
        }

        Arrays.sort(arr, 0 , n);

        int curTime = arr[0].start;
        int postTime = arr[0].end;

        for(int i = 1 ; i < n ; i++){
            if(postTime <= arr[i].start){
                curTime = arr[i].start;
                postTime = arr[i].end;
            }
            else if(curTime <= arr[i].start && arr[i].end <= postTime){
                continue;
            }
            else{
                System.out.print(-1);
                System.exit(0);
            }
        }

        System.out.print(arr[0].start);
    }
}