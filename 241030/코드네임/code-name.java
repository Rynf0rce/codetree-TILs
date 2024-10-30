import java.util.*;
import java.io.*;

class agent implements Comparable<agent>{
    char c;
    int point;
    public agent(char c, int point){
        this.c = c;
        this.point = point;
    }

    @Override
    public int compareTo(agent a){
        return this.point - a.point;
    }
}
public class Main {
    public static PriorityQueue<agent> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0 ; i < 5 ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            char c = st.nextToken().charAt(0);
            int point = Integer.parseInt(st.nextToken());
            pq.add(new agent(c, point));
        }
        System.out.print(pq.peek().c + " " + pq.peek().point);
    }
}