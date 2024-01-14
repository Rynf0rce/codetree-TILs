import java.util.*;

class info implements Comparable<info>{
    int idx;
    int arrived;
    int time;

    public info(int idx, int arrived, int time){
        this.idx = idx;
        this.arrived = arrived;
        this.time = time;
    }

    @Override
    public int compareTo(info w){
        if(this.arrived == w.arrived){
            return this.idx - w.idx;
        }
        else{
            return this.arrived - w.arrived;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PriorityQueue<info> infoPQ = new PriorityQueue<>();
        PriorityQueue<info> waitingPQ = new PriorityQueue<>(new Comparator<info>() {
                                                    @Override
                                                    public int compare(info o1, info o2) {
                                                        return o1.idx - o2.idx;
                                                    };
                                                });

        int n = sc.nextInt();
        for(int i = 1 ; i <= n ; i++){
            int arrived = sc.nextInt();
            int time = sc.nextInt();
            infoPQ.add(new info(i, arrived, time));
        }

        info watcher = infoPQ.poll();
        int curTime = watcher.arrived + watcher.time;
        int output = 0;

        while(!infoPQ.isEmpty()){
            if(infoPQ.peek().arrived < curTime){
                waitingPQ.add(infoPQ.poll());
            }
            else if(waitingPQ.isEmpty()){
                watcher = infoPQ.poll();
                curTime = watcher.arrived + watcher.time;
            }
            else{
                watcher = waitingPQ.poll();
                output = Math.max(output, curTime - watcher.arrived);
                curTime += watcher.time;
            }
            // System.out.println(infoPQ.size() + " " + waitingPQ.size() + " " + curTime);
        }

        while(!waitingPQ.isEmpty()){
            watcher = waitingPQ.poll();
            output = Math.max(output, curTime - watcher.arrived);
            curTime += watcher.time;
        }

        System.out.println(output);
        
    }
}