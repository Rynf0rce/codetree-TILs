import java.util.*;
import java.io.*;

public class Main {
    public static ArrayList<Integer> upArr = new ArrayList<>();
    public static ArrayList<Integer> downArr = new ArrayList<>();
    public static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            upArr.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < m ; i++){
            downArr.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(upArr);
        Collections.sort(downArr);

        for(int i = 0 ; i < upArr.size() ; i++){
            for(int j = 0 ; j < downArr.size() ; j++){
                if(pq.size() < k){
                    pq.add(upArr.get(i) + downArr.get(j));
                }
                else if(pq.peek() >= upArr.get(i) + downArr.get(j)){
                    pq.add(upArr.get(i) + downArr.get(j));
                    pq.poll();
                }
                else{
                    break;
                }
            }

            if(pq.size() == k && upArr.get(i) > pq.peek()){
                break;
            }
        }
        System.out.print(pq.poll());
    }
}