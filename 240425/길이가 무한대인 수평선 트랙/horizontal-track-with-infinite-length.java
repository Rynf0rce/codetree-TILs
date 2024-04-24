import java.util.*;
import java.io.*;

class info implements Comparable<info>{
    int start;
    long end;
    int speed;

    public info(int start, long end, int speed){
        this.start = start;
        this.end = end;
        this.speed = speed;
    }

    @Override
    public int compareTo(info p) {
        if(this.start == p.start){
            return this.speed - p.speed;
        }
        else{
            return this.start - p.start;
        }
    }
}

public class Main {
    public static TreeSet<info> s = new TreeSet<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            long end = (long)T * speed + start;

            info inputInfo = new info(start, end, speed);
            s.add(inputInfo);
        }

        int ans = 1;
        info curInfo = s.last();
        long curVal = curInfo.end;
        while(curInfo != s.first()){
            curInfo = s.lower(curInfo);
            if(curVal < curInfo.end){
                continue;
            }

            curVal = curInfo.end;
            ans++;
        }

        System.out.print(ans);
    }
}