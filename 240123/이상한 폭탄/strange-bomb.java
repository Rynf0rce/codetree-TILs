import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_BOMB = 200000;
    public static HashMap<Integer, Integer> bombMap = new HashMap<>();
    public static int[] bombArr = new int[MAX_BOMB];
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < N ; i++){
            bombArr[i] = Integer.parseInt(br.readLine());
        }

        int maxIdx = -1;
        HashMap<Integer, Integer> bombMap = new HashMap<>();
        for(int i = 0 ; i < K ; i++){
            bombMap.put(bombArr[i], bombMap.getOrDefault(bombArr[i], 0) + 1);
            if(bombMap.get(bombArr[i]) >= 2){
                maxIdx = Math.max(maxIdx, bombArr[i]);
            }
        }

        for(int i = 0 ; i < N - K; i++){
            int delIdx = i - K - 1;
            int addIdx = i + K;
            if(delIdx >= 0){
                bombMap.put(bombArr[delIdx], bombMap.get(bombArr[delIdx]) - 1);
            }

            if(addIdx < N){
                bombMap.put(bombArr[addIdx], bombMap.getOrDefault(bombArr[addIdx], 0) + 1);
            }

            if(bombMap.get(bombArr[i]) >= 2){
                maxIdx = Math.max(maxIdx, bombArr[i]);
            }
        }
        
        bw.write(maxIdx + "");
        
        br.close();
        bw.close();
    }
}