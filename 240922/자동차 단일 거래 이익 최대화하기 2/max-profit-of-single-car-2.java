import java.util.*;
import java.io.*;

class time implements Comparable<time>{
    long price;
    int idx;

    public time(long price, int idx){
        this.price = price;
        this.idx = idx;
    }

    @Override
    public int compareTo(time t){
        if(this.price == t.price){
            return this.idx - t.idx;
        }
        else if(this.price > t.price){
            return 1;
        }
        else{
            return -1;
        }
    }
}

public class Main{
    public static final int MAX_STOCK_TIME = 100000;
    public static long[] arr = new long[MAX_STOCK_TIME];
    public static TreeSet<time> timeSet = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            arr[i] = Long.parseLong(st.nextToken());
            timeSet.add(new time(arr[i], i));
        }

        long ans = 0;
        long minVal = arr[0];
        for(int i = 1 ; i < n ; i++){
            long profit = arr[i] - minVal;
            if(ans < profit){
                ans = profit;
            }

            if(minVal > arr[i]){
                minVal = arr[i];
            }
        }

        bw.write(ans + "");
        
        bw.close();
        br.close();
        
    }
}

/*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            arr[i] = Long.parseLong(st.nextToken());
            timeSet.add(new time(arr[i], i));
        }

        long ans = 0;

        for(int i = 0 ; i < n - 1 ; i++){
            timeSet.remove(new time(arr[i], i));
            ans = Math.max(ans, timeSet.last().price - arr[i]);
        }

        bw.write(ans + "");
        
        bw.close();
        br.close();
        
*/