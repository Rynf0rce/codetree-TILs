import java.util.*;
import java.io.*;

class forecast implements Comparable<forecast>{
    String day, week, weather;
    public forecast(String day, String week, String weather){
        this.day = day;
        this.week = week;
        this.weather = weather;
    }

    public void print(){
        System.out.print(day + " " + week + " " + weather);
    }

    @Override
    public int compareTo(forecast f){
        return this.day.compareTo(f.day);
    }
}

public class Main {
    public static PriorityQueue<forecast> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String day = st.nextToken();
            String week = st.nextToken();
            String weather = st.nextToken();
            pq.add(new forecast(day, week, weather));
        }
        
        while(!pq.isEmpty()){
            if(pq.peek().weather.equals("Rain")){
                pq.peek().print();
                System.exit(0);
            }
            pq.poll();
        }
    }
}