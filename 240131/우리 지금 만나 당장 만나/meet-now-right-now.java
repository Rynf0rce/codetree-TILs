import java.util.*;
import java.io.*;

class people{
    int pos;
    int speed;

    public people(int pos, int speed){
        this.pos = pos;
        this.speed = speed;
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }
}

class schedule implements Comparable<schedule>{
    float pos;
    int val;
    int idx;

    public schedule(float pos, int val, int idx){
        this.pos = pos;
        this.val = val;
        this.idx = idx;
    }

    @Override
    public int compareTo(schedule s){
        if(this.pos == s.pos){
            if(this.val == s.val){
                return this.idx - s.idx;
            }
            else{
                return s.val - this.val;
            }
        }
        else if(this.pos > s.pos){
            return 1;
        }
        else{
            return -1;
        }
    }
}

public class Main {
    public static final int MAX_PEOPLE = 100000;
    public static final int MAX_POSITION = 1000000000;
    public static people[] arr = new people[MAX_PEOPLE];
    public static int n;

    public static boolean inTime(float time){
        ArrayList<schedule> lineList = new ArrayList<>();
        HashSet<Integer> idxSet = new HashSet<>();

        for(int i = 0 ; i < n ; i++){
            lineList.add(new schedule(Math.max(0, arr[i].pos - arr[i].speed * time), 1, i));
            lineList.add(new schedule(Math.min(MAX_POSITION, arr[i].pos + arr[i].speed * time), -1, i));
        }

        Collections.sort(lineList);

        for(int i = 0 ; i < lineList.size() ; i++){
            schedule curSchedule = lineList.get(i);
            int val = curSchedule.val;
            int idx = curSchedule.idx;

            if(val == 1){
                idxSet.add(idx);
            }
            else{
                idxSet.remove(idx);
            }

            if(idxSet.size() == n){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            int pos = Integer.parseInt(st.nextToken());
            arr[i] = new people(pos, 0);
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            int speed = Integer.parseInt(st.nextToken());
            arr[i].setSpeed(speed);
        }

        float start = 0;
        float end = MAX_POSITION;
        float ans = MAX_POSITION;
        while(start <= end){
            float mid = (end + start) / 2;
            if(inTime(mid)){
                end = mid - (float)0.0001;
                ans = Math.min(ans, mid);
            }
            else{
                start = mid + (float)0.0001;
            }
            // System.out.println(mid);
        }

        String s = String.format("%.4f", ans);
        bw.write(s + "");

        br.close();
        bw.close();
    }
}