import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100;
    public static int[] origin = new int[MAX_LENGTH];
    public static int[] target = new int[MAX_LENGTH];
    public static int[] originCnt = new int[MAX_LENGTH + 1];
    public static int[] targetCnt = new int[MAX_LENGTH + 1];
    public static HashSet<Integer> hs = new HashSet<>();
    public static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++){
            origin[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < M ; i++){
            target[i] = Integer.parseInt(st.nextToken());
            targetCnt[target[i]]++;
            hs.add(target[i]);
        }

        ArrayList<Integer> al = new ArrayList<>(hs);

        int ans = 0;
        for(int i = 0 ; i < N  ; i++){

            q.add(origin[i]);
            originCnt[origin[i]]++;
            if(q.size() > M){
                originCnt[q.poll()]--;
            }

            boolean flag = true;
            if(q.size() == M){
                for(Integer al_num : al){
                    if(originCnt[al_num] != targetCnt[al_num]){
                        flag = false;
                        break;
                    }
                }
            }
            else{
                flag = false;
            }

            if(flag){
                ans++;
            }

        }
        System.out.print(ans);
    }
}