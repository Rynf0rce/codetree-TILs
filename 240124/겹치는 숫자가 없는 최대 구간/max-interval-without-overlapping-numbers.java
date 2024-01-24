import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static int[] arr = new int[MAX_LENGTH];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Integer, Integer> cntMap = new HashMap<>();

        int j = -1;
        int maxLength = 0;
        for(int i = 0 ; i < n ; i++){

            while(j + 1 < n && cntMap.getOrDefault(arr[j + 1], 0) < 1){
                cntMap.put(arr[j + 1], cntMap.getOrDefault(arr[j + 1] , 0) + 1);
                j++;
            }

            maxLength = Math.max(maxLength, j - i + 1);
            cntMap.put(arr[i], cntMap.getOrDefault(arr[i], 0) - 1);
        }

        bw.write(maxLength + "");

        br.close();
        bw.close();
    }
}