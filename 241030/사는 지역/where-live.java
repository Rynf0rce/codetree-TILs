import java.util.*;
import java.io.*;

class info implements Comparable<info>{
    String name, num, loc;
    public info(String name, String num, String loc){
        this.name = name;
        this.num = num;
        this.loc = loc;
    }
    
    public void print(){
        System.out.println("name " + name);
        System.out.println("addr " + num);
        System.out.println("city " + loc);
    }

    @Override
    public int compareTo(info i){
        return i.name.compareTo(this.name);
    }
}

public class Main {
    public static PriorityQueue<info> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String a = st.nextToken();
            String b = st.nextToken();
            String c = st.nextToken();
            pq.add(new info(a, b, c));
        }
        
        pq.peek().print();
    }
}