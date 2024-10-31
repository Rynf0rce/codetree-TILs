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
            int mid = 0;
            for(int j = 1 ; j <= m ; j++){
                int num = Integer.parseInt(st.nextToken());
                if(j == 1){
                    mid = num;
                }
                else{
                    if(mid <= num){
                        rightPQ.add(num);
                    }
                    else{
                        leftPQ.add(num * -1);
                    }
                }

                if(leftPQ.size() < rightPQ.size()){
                    leftPQ.add(mid * - 1);
                    mid = rightPQ.poll();
                }
                else if(leftPQ.size() > rightPQ.size()){
                    rightPQ.add(mid);
                    mid = leftPQ.poll() * -1;
                }

                if(j % 2 == 1){
                    System.out.print(mid + " ");
                }
            }
            System.out.println();
        }
    }
}