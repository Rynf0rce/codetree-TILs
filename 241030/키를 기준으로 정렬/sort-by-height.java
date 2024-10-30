import java.util.*;
import java.io.*;

class info implements Comparable<info>{
    String name;
    int height, weight;
    public info(String name, int height, int weight){
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(info i){
        return this.height - i.height;
    }

    public void print(){
        System.out.println(name + " " + height + " " + weight);
    }
}

public class Main {
    public static PriorityQueue<info> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            pq.add(new info(str, height, weight));
        }

        while(!pq.isEmpty()){
            pq.poll().print();
        }
    }
}