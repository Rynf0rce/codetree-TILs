import java.util.*;
import java.io.*;

class info implements Comparable<info>{
    String str;
    int a, b, c, sum;
    public info(String str, int a, int b, int c){
        this.str = str;
        this.a = a;
        this.b = b;
        this.c = c;
        this.sum = a + b + c;
    }

    @Override
    public int compareTo(info i){
        return this.sum - i.sum;
    }

    public void print(){
        System.out.println(str + " " + a + " " + b + " " + c);
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
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new info(str, a, b, c));
        }

        while(!pq.isEmpty()){
            pq.poll().print();
        }
    }
}