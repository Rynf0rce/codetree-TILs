import java.util.*;
import java.io.*;

public class Main {
    public static final long MAX_LONG = 1000000000L;
    public static ArrayList<Long> rockList = new ArrayList<>();
    
    public static boolean allRemove(long mid, int bomb){
        PriorityQueue<Long> rockQueue = new PriorityQueue<>();
        rockQueue.addAll(rockList);

        while(bomb-- > 0){
            if(rockQueue.isEmpty()){
                break;
            }

            long start = rockQueue.poll();
            long end = start + mid * 2;

            while(!rockQueue.isEmpty() && start <= rockQueue.peek() && rockQueue.peek() <= end){
                rockQueue.poll();
            }
        }

        return rockQueue.isEmpty();
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < N ; i++){
            long num = Long.parseLong(br.readLine());
            rockList.add(num);
        }

        long start = 0;
        long end = MAX_LONG;
        long ans = MAX_LONG;
        while(start <= end){
            long mid = (end + start) / 2;
            if(allRemove(mid, K)){
                end = mid - 1;
                ans = Math.min(ans, mid);
            }
            else{
                start = mid + 1;
            }
        }

        bw.write(ans + "");

        br.close();
        bw.close();
    }
}