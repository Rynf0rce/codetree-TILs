import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static int[] placeArr = new int[MAX_LENGTH];
    public static TreeSet<Integer> stationSet = new TreeSet<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            placeArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < m ; i++){
            stationSet.add(Integer.parseInt(st.nextToken()));
        }

        int answer = 0;
        for(int i = 0 ; i < n ; i++){
            if(stationSet.ceiling(placeArr[i]) != null){
                answer = Math.max(answer, stationSet.ceiling(placeArr[i]) - placeArr[i]);
            }

            if(stationSet.floor(placeArr[i]) != null){
                answer = Math.max(answer, placeArr[i] - stationSet.floor(placeArr[i]));
            }
        }

        bw.write(answer + "");

        br.close();
        bw.close();
    }
}