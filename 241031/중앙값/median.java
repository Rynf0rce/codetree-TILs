import java.util.*;
import java.io.*;

public class Main {
    public static PriorityQueue<Integer> leftPQ = new PriorityQueue<>();
    public static PriorityQueue<Integer> rightPQ = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < t ; i++){
            int m = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            rightPQ.clear();
            leftPQ.clear();
            for(int j = 1 ; j <= m ; j++){
                int num = Integer.parseInt(st.nextToken());
                rightPQ.add(num);

                if(j % 2 == 1){
                    int cnt = j / 2;
                    while(cnt > 0){
                        leftPQ.add(rightPQ.poll());
                        cnt--;
                    }
                    System.out.print(rightPQ.peek() + " ");

                    while(!leftPQ.isEmpty()){
                        rightPQ.add(leftPQ.poll());
                    }
                }
            }
            System.out.println();
        }
    }
}