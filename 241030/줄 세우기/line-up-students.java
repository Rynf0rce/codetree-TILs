import java.util.*;
import java.io.*;

class info implements Comparable<info>{
    int idx, height, weight;
    public info(int idx, int height, int weight){
        this.idx = idx;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(info i){
        if(this.height == i.height){
            if(this.weight == i.weight){
                return this.idx - i.idx;
            }
            return i.weight - this.weight;
        }
        return i.height - this.height;
    }

    public void print(){
        System.out.println(height + " " + weight + " " + idx);
    }
}

public class Main {
    public static PriorityQueue<info> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 1 ; i <= n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pq.add(new info(i, a, b));
        }

        while(!pq.isEmpty()){
            pq.poll().print();
        }
    }
}