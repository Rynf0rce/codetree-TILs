import java.util.*;

class time implements Comparable<time>{
    int start;
    int end;

    public time(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(time t){
        if(this.end == t.end){
            return this.start - t.start;
        }
        else{
            return this.end - t.end;
        }
    }
}

public class Main {
    public static PriorityQueue<time> timeQueue = new PriorityQueue<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0 ; i < n ; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            timeQueue.add(new time(start, end));
        }

        int cnt = 0;
        while(!timeQueue.isEmpty()){
            time curTime = timeQueue.poll();
            while(!timeQueue.isEmpty() && timeQueue.peek().start < curTime.end){
                timeQueue.poll();
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}