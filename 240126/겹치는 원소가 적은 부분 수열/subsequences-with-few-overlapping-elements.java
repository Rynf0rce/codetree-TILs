import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static long[] arr = new long[MAX_LENGTH];
    public static HashMap<Integer, Integer> elementMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        int j = -1;
        int output = 0;
        for(int i = 0 ; i < n ; i++){
            while(j + 1 < n && elementMap.getOrDefault(arr[j + 1], 0) < 2){
                elementMap.put(arr[j + 1], elementMap.getOrDefault(arr[j + 1], 0) + 1);
                j++;
            }
            
            output = Math.max(output, j - i + 1);
            // System.out.println(j + " " + i);
            elementMap.put(arr[i], elementMap.get(arr[i]) - 1);
        }

        bw.write(output + "");

        br.close();
        bw.close();
    }
}