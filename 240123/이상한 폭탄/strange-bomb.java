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

        for(int i = 0 ; i < N; i++){
            if(!bombMap.containsKey(bombArr[i])){
                bombMap.put(bombArr[i], i);
            }
            else{
                if(i - bombMap.get(bombArr[i]) <= K){
                    maxIdx = Math.max(bombArr[i], maxIdx);
                }

                bombMap.put(bombArr[i], i);
            }
        }
        
        bw.write(maxIdx + "");
        
        br.close();
        bw.close();
    }
}