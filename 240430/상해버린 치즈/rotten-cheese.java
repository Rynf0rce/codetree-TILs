import java.util.*;
import java.io.*;

class schedule implements Comparable<schedule>{
    int idx, time, cheeze;
    public schedule(int idx, int time, int cheeze){
        this.idx = idx;
        this.time = time;
        this.cheeze = cheeze;
    }

    @Override
    public int compareTo(schedule s){
        if(this.time == s.time){
            return this.idx - s.idx;
        }

        return this.time - s.time;
    }
}

class infected implements Comparable<infected>{
    int idx, time;
    public infected(int idx, int time){
        this.idx = idx;
        this.time = time;
    }

    @Override
    public int compareTo(infected i){
        if(this.time == i.time){
            return this.idx - i.idx;
        }
        return this.time - i.idx;
    }
}

public class Main {
    public static final int MAX_PEOPLE = 50;
    public static HashSet<Integer>[] eatenSet = new HashSet[MAX_PEOPLE + 1];
    public static HashSet<Integer> suspectSet = new HashSet<>();
    public static HashSet<Integer> checkedSet = new HashSet<>();
    public static PriorityQueue<schedule> eatPQ = new PriorityQueue<>();
    public static PriorityQueue<infected> infectedPQ = new PriorityQueue<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        for(int i = 1 ; i <= N ; i++){
            eatenSet[i] = new HashSet<>();
        }

        for(int i = 0 ; i < D ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int idx = Integer.parseInt(st.nextToken());
            int cheeze = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            eatPQ.add(new schedule(idx, time, cheeze));
        }

        for(int i = 0 ; i < S ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int idx = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            infectedPQ.add(new infected(idx, time));
        }

        while(!infectedPQ.isEmpty()){
            infected i = infectedPQ.poll();

            while(!eatPQ.isEmpty() && eatPQ.peek().time < i.time){
                schedule s = eatPQ.poll();
                eatenSet[s.idx].add(s.cheeze);
            }

            ArrayList<Integer> refinedList = new ArrayList<>();
            for(Integer cheeze : eatenSet[i.idx]){
                if(!checkedSet.contains(cheeze) && !suspectSet.contains(cheeze)){
                    checkedSet.add(cheeze);
                    refinedList.add(cheeze);
                    suspectSet.add(cheeze);
                }
                else if(checkedSet.contains(cheeze) && suspectSet.contains(cheeze)){
                    refinedList.add(cheeze);
                }
            }

            suspectSet.clear();
            for(int cheeze : refinedList){
                suspectSet.add(cheeze);
            }
        }

        while(!eatPQ.isEmpty()){
            schedule s = eatPQ.poll();
            eatenSet[s.idx].add(s.cheeze);
        }

        int ans = 0;
        for(Integer cheeze : suspectSet){
            int cnt = 0;
            for(int i = 1 ; i <= N ; i++){
                if(eatenSet[i].contains(cheeze)){
                    cnt++;
                }
            }
            ans = Math.max(ans, cnt);
        }

        System.out.print(ans);
    }
}