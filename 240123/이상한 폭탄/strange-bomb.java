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
        for(int i = 0 ; i < N ; i++){
            int bombIdx = bombArr[i];
            if(i > 2 * K + 1){
                bombMap.put(bombIdx, bombMap.get(bombIdx) - 1);
            }
            bombMap.put(bombIdx, bombMap.getOrDefault(bombIdx, 0) + 1);
            if(bombMap.get(bombIdx) >= 2){
                maxIdx = Math.max(maxIdx, bombIdx);
            }
        }
        
        bw.write(maxIdx + "");
        
        br.close();
        bw.close();
    }
}