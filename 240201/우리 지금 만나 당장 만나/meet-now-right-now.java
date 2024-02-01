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

public class Main {
    public static final int MAX_PEOPLE = 100000;
    public static final int MAX_POSITION = 1000000000;
    public static people[] arr = new people[MAX_PEOPLE];
    public static int n;

    public static boolean inTime(float time){
        float boundaryLeft = Math.max(0, arr[0].pos - arr[0].speed * time);
        float boundaryRight = Math.min(MAX_POSITION, arr[0].pos + arr[0].speed * time);

        for(int i = 1 ; i < n ; i++){
            float left = Math.max(0, arr[i].pos - arr[i].speed * time);
            float right = Math.min(MAX_POSITION, arr[i].pos + arr[i].speed * time);

            // System.out.println(boundaryLeft + " " + boundaryRight + " " + left + " " + right);

            if(boundaryLeft <= left && right <= boundaryRight){
                boundaryLeft = left;
                boundaryRight = right;
            }
            else if(left <= boundaryRight && boundaryRight <= right){
                boundaryLeft = left;
            }
            else if(left <= boundaryLeft && boundaryLeft <= right){
                boundaryRight = right;
            }
            else{
                return false;
            }
        }
        return true;
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
        int cnt = 50;
        while(start <= end && cnt-- > 0){
            float mid = (end + start) / 2;
            if(inTime(mid)){
                end = mid - (float)0.00001;
                ans = Math.min(ans, mid);
            }
            else{
                start = mid + (float)0.00001;
            }
            // System.out.println(mid);
        }

        String s = String.format("%.4f", ans);
        bw.write(s + "");

        br.close();
        bw.close(); 
    }
}