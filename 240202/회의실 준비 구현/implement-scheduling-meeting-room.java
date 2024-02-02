import java.util.*;

class timeline implements Comparable<timeline>{
    int start;
    int end;

    public timeline(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(timeline t){
        return this.end - t.end;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<timeline> pq = new PriorityQueue<>();
        for(int i = 0 ; i < n ; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            pq.add(new timeline(start, end));
        }

        int curTime = -1;
        int ans = 0;
        while(!pq.isEmpty()){
            timeline curLine = pq.poll();
            if(curTime > curLine.start){
                continue;
            }

            curTime = curLine.end;
            ans++;
        }

        System.out.print(ans);

        
    }
}