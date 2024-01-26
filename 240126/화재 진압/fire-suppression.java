import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LOCATION = 100000;
    public static final int MAX_INT = 1000000000;
    public static final int MIN_INT = -1000000000;
    public static int[] locationArr = new int[MAX_LOCATION];
    public static int[] stationArr = new int[MAX_LOCATION];
    
    public static boolean inRange(int x, int s1, int s2){
        return s1 <= x && x <= s2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            locationArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= m ; i++){
            stationArr[i] = Integer.parseInt(st.nextToken());
        }
        stationArr[0] = MIN_INT - 1;
        stationArr[m + 1] = MAX_INT + 1;

        Arrays.sort(locationArr, 0, n);
        Arrays.sort(stationArr, 0, m + 2);

        // for(int i = 0 ; i < m + 2 ; i++){
        //     System.out.print(stationArr[i] + " ");
        // }
        // System.out.println();

        int j = -1;
        int maxVal = 0;
        for(int i = 0 ; i < m + 1 ; i++){
            // System.out.println(stationArr[i] + " " + stationArr[i + 1]);
            while(j + 1 < n && inRange(locationArr[j + 1], stationArr[i], stationArr[i + 1])){
                int curMaxVal = 0;
                if(i == 0){
                    curMaxVal = stationArr[i + 1] - locationArr[j + 1];
                    // System.out.println("i == 0 : " + curMaxVal);
                }
                else if(i == m){
                    curMaxVal = locationArr[j + 1] - stationArr[i];
                    // System.out.println("i == m : " + curMaxVal);
                }
                else{
                    curMaxVal = Math.max(locationArr[j + 1] - stationArr[i], stationArr[i + 1] - locationArr[j + 1]);
                    // System.out.println("alse : " + curMaxVal);
                }
                // System.out.println(i + " " + j + " " + curMaxVal);
                maxVal = Math.max(maxVal, curMaxVal);
                j++;
            }
        }

        bw.write(maxVal + "");

        bw.close();
        br.close();
    }
}