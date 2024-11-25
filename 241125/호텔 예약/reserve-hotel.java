import java.util.*;
import java.io.*;

class stay implements Comparable<stay>{
    int time;
    int val;
    int idx;

    public stay(int time, int val, int idx){
        this.time = time;
        this.val = val;
        this.idx = idx;
    }

    @Override
    public int compareTo(stay s){
        if(this.time == s.time){
            if(this.val == s.val){
                return this.idx - s.idx;
            }
            else{
                return s.val - this.val;
            }
        }
        else{
            return this.time - s.time;
        }
    }
}

public class Main {
    public static final int MAX_PEOPLE = 100000;
    public static PriorityQueue<Integer> roomQueue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 1 ; i <= MAX_PEOPLE ; i++){
            roomQueue.add(i);
        }

        int n = Integer.parseInt(st.nextToken());
        ArrayList<stay> stayList = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            stayList.add(new stay(s, 1, i));
            stayList.add(new stay(e, -1, i));
        }

        Collections.sort(stayList);
        HashMap<Integer, Integer> asignedMap = new HashMap<>();
        int maxVal = 0;
        for(int i = 0 ; i < stayList.size() ; i++){
            if(stayList.get(i).val == 1){
                int roomNum = roomQueue.poll();
                asignedMap.put(stayList.get(i).idx, roomNum);
                maxVal = Math.max(maxVal, roomNum);
            }
            else{
                roomQueue.add(asignedMap.get(stayList.get(i).idx));
            }
        }

        bw.write(maxVal + "");

        br.close();
        bw.close();
    }
}