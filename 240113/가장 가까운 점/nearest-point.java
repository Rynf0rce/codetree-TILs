import java.util.*;

class point implements Comparable<point>{
    int x;
    int y;
    int length;

    public point(int x, int y){
        this.x = x;
        this.y = y;
        this.length = Math.abs(x) + Math.abs(y);
    }

    @Override
    public int compareTo(point p){
        if(this.length == p.length){
            if(this.x == p.x){
                return this.y - p.y;
            }
            else{
                return this.x - p.x;
            }
        }
        else{
            return this.length - p.length;
        }
        
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<point> pq = new PriorityQueue<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        for(int i = 0 ; i < n ; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            pq.add(new point(x, y));
        }

        for(int i = 0 ; i < m ; i++){
            point closedPoint = pq.poll();
            pq.add(new point(closedPoint.x + 2, closedPoint.y + 2));
        }

        point answer = pq.poll();
        System.out.println(answer.x + " " + answer.y);
    }
}