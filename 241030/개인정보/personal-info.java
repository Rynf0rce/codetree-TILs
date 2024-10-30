import java.util.*;
import java.io.*;

class info implements Comparable<info>{
    String name;
    double height, weight;
    public info(String name, double height, double weight){
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(info i){
        return this.name.compareTo(i.name);
    }

    public void print(){
        System.out.println(name + " " + String.format("%.0f", height) + " " + String.format("%.1f", weight));
    }
}


class info2 implements Comparable<info2>{
    String name;
    double height, weight;
    public info2(String name, double height, double weight){
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(info2 i){
        return (int)(i.height - this.height);
    }

    public void print(){
        System.out.println(name + " " + String.format("%.0f", height) + " " + String.format("%.1f", weight));
    }
}

public class Main {
    public static PriorityQueue<info> pq = new PriorityQueue<>();
    public static PriorityQueue<info2> pq2 = new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0 ; i < 5 ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String str = st.nextToken();
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            pq.add(new info(str, a, b));
            pq2.add(new info2(str, a, b));
        }

        System.out.println("name");
        while(!pq.isEmpty()){
            pq.poll().print();
        }
        System.out.println();
        System.out.println("height");
        while(!pq2.isEmpty()){
            pq2.poll().print();
        }
    }
}