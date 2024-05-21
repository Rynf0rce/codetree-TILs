import java.util.*;
import java.io.*;

class meeting implements Comparable<meeting>{
    int s, e;
    public meeting(int s, int e){
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(meeting m){
        return this.e - m.e;
    }
}

public class Main {
    public static PriorityQueue<meeting> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pq.add(new meeting(s, e));
        }

        int ans = 0;
        int curTime = 0;
        while(!pq.isEmpty()){
            meeting curMeeting = pq.poll();
            if(curTime <= curMeeting.s){
                ans++;
                curTime = curMeeting.s;
            }
        }
        System.out.print(ans);
    }
}