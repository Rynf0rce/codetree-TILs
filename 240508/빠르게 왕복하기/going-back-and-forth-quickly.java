import java.util.*;
import java.io.*;

class route implements Comparable<route>{
    int ost, dst;
    public route(int ost, int dst){
        this.ost = ost;
        this.dst = dst;
    }
    @Override
    public int compareTo(route r){
        if(this.ost == r.ost){
            return this.dst - r.dst;
        }
        return this.ost - r.ost;
    }
}

public class Main {
    public static PriorityQueue<route> leftPQ = new PriorityQueue<>();
    public static PriorityQueue<Integer> rightPQ = new PriorityQueue<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            leftPQ.add(new route(a, b));
        }

        int curTime = 0;
        route leftRoute = leftPQ.poll();
        int rightVal = 0;

        while(leftRoute.ost > 0 || !leftPQ.isEmpty()){
            if(rightPQ.isEmpty()){
                curTime += leftRoute.ost;
                rightPQ.add(leftRoute.dst);
                leftRoute.ost = 0;
                continue;
            }

            if(leftRoute.ost == 0){
                leftRoute = leftPQ.poll();
            }

            if(rightVal == 0){
                rightVal = rightPQ.poll();
            }
            // System.out.println(leftRoute.ost + " " + rightVal + " " + curTime);

            if(leftRoute.ost < rightVal){
                curTime += leftRoute.ost;
                rightVal -= leftRoute.ost;
                rightPQ.add(leftRoute.dst);
                leftRoute.ost = 0;
                continue;
            }
            else if(leftRoute.ost == rightVal){
                curTime += leftRoute.ost;
                rightVal = 0;
                leftRoute.ost = 0;
            }
            else{
                curTime += rightVal;
                leftRoute.ost -= rightVal;
                rightVal = 0;
            }
        }

        curTime += rightVal;
        while(!rightPQ.isEmpty()){
            curTime += rightPQ.poll();
        }

        System.out.print(curTime);
    }
}