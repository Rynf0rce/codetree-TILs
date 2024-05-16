import java.util.*;
import java.io.*;

class jewel implements Comparable<jewel>{
    int weight;
    double perPrice;
    public jewel(int weight, double perPrice){
        this.weight = weight;
        this.perPrice = perPrice;
    }

    @Override
    public int compareTo(jewel j){
        if(this.perPrice == j.perPrice){
            return this.weight - j.weight;
        }

        if(j.perPrice > this.perPrice){
            return 1;
        }
        else{
            return -1;
        }
    }
}

public class Main {
    public static PriorityQueue<jewel> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int weight = Integer.parseInt(st.nextToken());
            double price = Double.parseDouble(st.nextToken()) / weight;
            pq.add(new jewel(weight, price));
        }

        double ans = 0;
        while( !pq.isEmpty()){
            jewel curJewel = pq.poll();
            if(M - curJewel.weight > 0){
                ans += curJewel.weight * curJewel.perPrice;
                M -= curJewel.weight;
            }
            else{
                ans += M * curJewel.perPrice;
                break;
            }
        }
        System.out.printf("%.3f", ans);
    }
}