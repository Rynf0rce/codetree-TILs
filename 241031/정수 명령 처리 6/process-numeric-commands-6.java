import java.util.*;
import java.io.*;

public class Main {
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String str = st.nextToken();
            int num = 0;
            switch(str){
                case "push" :
                    num = Integer.parseInt(st.nextToken());
                    pq.add(num * -1);
                break;
                case "pop" :
                    System.out.println(pq.poll() * -1);
                break;
                case "size" :
                    System.out.println(pq.size());
                break;
                case "empty" :
                    System.out.println(pq.isEmpty() ? 1 : 0);
                break;
                case "top" :
                    System.out.println(pq.peek() * -1);
                break;
            }
        }
    }
}