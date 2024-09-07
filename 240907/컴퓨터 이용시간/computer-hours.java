import java.util.*;
import java.io.*;

class tuple implements Comparable<tuple>{
    int x;
    int val;
    int idx;

    public tuple(int x, int val, int idx){
        this.x = x;
        this.val = val;
        this.idx = idx;
    }

    @Override
    public int compareTo(tuple t){
        return this.x - t.x;
    }
}

public class Main {
    public static final int MAX_PEOPLE = 100000;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        ArrayList<tuple> timeList = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            timeList.add(new tuple(p, 1, i));
            timeList.add(new tuple(q, -1, i));
        }

        Collections.sort(timeList);
        
        PriorityQueue<Integer> comQueue = new PriorityQueue<>();
        for(int i = 1 ; i <= MAX_PEOPLE ; i++){
            comQueue.add(i);
        }

        HashMap<Integer, Integer> userMap = new HashMap<>();

        for(int i = 0 ; i < timeList.size() ; i++){
            int x = timeList.get(i).x;
            int val = timeList.get(i).val;
            int idx = timeList.get(i).idx;
            
            if(val == 1){
                userMap.put(idx, comQueue.poll());
            }
            else{
                // System.out.println(x + " " + userMap.get(idx));
                comQueue.add(userMap.get(idx));
            }
        }

        for(int i = 0 ; i < n ; i++){
            bw.write(userMap.get(i) + " ");
        }

        br.close();
        bw.close();
    }
}