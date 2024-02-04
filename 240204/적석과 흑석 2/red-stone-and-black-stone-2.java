import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_ROCK = 100000;
    public static TreeSet<Integer> redSet = new TreeSet<>();
    public static int[] arr_B = new int[MAX_ROCK];
    public static HashMap<Integer, TreeSet> blackMap = new HashMap<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < C ; i++){
            int T = Integer.parseInt(br.readLine());
            redSet.add(T);
        }

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            arr_B[i] = B;

            if(!blackMap.containsKey(B)){
                blackMap.put(B, new TreeSet<Integer>());
            }

            TreeSet inSet = blackMap.get(B);
            inSet.add(A);
            blackMap.put(B, inSet);
        }

        Arrays.sort(arr_B, 0, N);

        for(int i = 0 ; i < N ; i++){
            TreeSet<Integer> inSet = blackMap.get(arr_B[i]);
            while(!inSet.isEmpty() && !redSet.isEmpty()){
                int A = inSet.last();
                if(redSet.ceiling(A) != null && redSet.ceiling(A) <= arr_B[i]){
                    redSet.remove(redSet.ceiling(A));
                }
                inSet.remove(A);
            }
        }

        System.out.print(C - redSet.size());

    }
}