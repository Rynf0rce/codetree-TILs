import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static long[] placeArr = new long[MAX_LENGTH];
    public static TreeSet<Long> stationSet = new TreeSet<>();

    public static long max(long num1, long num2){
        if(num1 >= num2){
            return num1;
        }
        else{
            return num2;
        }
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            placeArr[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < m ; i++){
            stationSet.add(Long.parseLong(st.nextToken()));
        }

        long answer = 0;
        for(int i = 0 ; i < n ; i++){
            if(stationSet.ceiling(placeArr[i]) != null){
                answer = max(answer, stationSet.ceiling(placeArr[i]) - placeArr[i] );
            }

            if(stationSet.floor(placeArr[i]) != null){
                answer = max(answer, placeArr[i] - stationSet.floor(placeArr[i]));
            }
        }

        bw.write(answer + "");

        br.close();
        bw.close();
    }
}