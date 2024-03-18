import java.util.*;
import java.io.*;

class tuple implements Comparable<tuple>{
    String name;
    int point;
    public tuple(String name, int point){
        this.name = name;
        this.point = point;
    }

    @Override
    public int compareTo(tuple t){
        return this.point - t.point;
    }
}

public class Main {
    public static HashMap<String, Integer> infoMap = new HashMap<>();
    public static String[] nameArr = new String[]{"Bessie", "Elsie", "Daisy", "Gertie", "Annabelle", "Maggie", "Henrietta"};
    public static PriorityQueue<tuple> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0 ; i < nameArr.length ; i++){
            infoMap.put(nameArr[i], 0);
        }

        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String name = String.valueOf(st.nextToken());
            int point = Integer.parseInt(st.nextToken());
            infoMap.put(name, infoMap.get(name) + point);
        }

        int idx = 0;
        for(Map.Entry<String, Integer> element : infoMap.entrySet() ){
            pq.add(new tuple(element.getKey(), element.getValue()));
        }

        tuple minTuple = pq.poll();
        boolean flag = false;
        boolean trigger = false;
        while(!pq.isEmpty()){
            tuple curTuple = pq.poll();
            if(!trigger){
                if(minTuple.point == curTuple.point){
                    continue;
                }
                else{
                    trigger = true;
                    flag = true;
                    minTuple = curTuple;
                }
            }
            else{
                if(minTuple.point == curTuple.point){
                    flag = false;
                }
                break;
            }
        }

        System.out.print(flag ? minTuple.name : "Tie");
    }
}