import java.util.*;
import java.io.*;

public class Main {
    public static PriorityQueue<String> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            pq.add(br.readLine());
        }
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }
}