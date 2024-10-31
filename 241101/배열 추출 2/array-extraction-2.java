import java.util.*;
import java.io.*;

class point implements Comparable<point>{
    int num;
    public point(int num){
        this.num = num;
    }

    @Override
    public int compareTo(point p){
        if(Math.abs(this.num) == Math.abs(p.num)){
            return this.num - p.num;
        }
        return Math.abs(this.num) - Math.abs(p.num);
    }
}

public class Main {
    public static PriorityQueue<point> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                if(pq.isEmpty()){
                    System.out.println(0);
                }
                else{
                    System.out.println(pq.poll().num);
                }
            }
            else{
                pq.add(new point(num));
            }
        }
    }
}