import java.util.*;
import java.io.*;

class info implements Comparable<info>{
    int height, weight, idx;
    public info(int height, int weight, int idx){
        this.height = height;
        this.weight = weight;
        this.idx = idx;
    }

    @Override
    public int compareTo(info i){
        if(this.height == i.height){
            return i.weight - this.weight;
        }
        return this.height - i.height;
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
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            pq.add(new info(height,weight,i));
        }

        while(!pq.isEmpty()){
            pq.poll().print();
        }
    }
}