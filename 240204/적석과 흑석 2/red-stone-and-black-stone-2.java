import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_ROCK = 100000;
    public static int[] redArr = new int[MAX_ROCK];
    public static TreeSet<Integer> leftBlackSet = new TreeSet<>();
    public static HashMap<Integer, TreeSet> blackMap = new HashMap<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < C ; i++){
            redArr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(redArr, 0, C);
        
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            leftBlackSet.add(A);
            if(!blackMap.containsKey(A)){
                blackMap.put(A, new TreeSet<Integer>());
            }

            TreeSet inSet = blackMap.get(A);
            inSet.add(B);
            blackMap.put(A, inSet);
        }

        int cnt = 0;
        for(int i = 0 ; i < C ; i++){
            if(leftBlackSet.floor(redArr[i]) == null){
                continue;
            }

            int leftIdx = leftBlackSet.floor(redArr[i]);
            
            while(true){
                TreeSet inSet = blackMap.get(leftIdx);

                if(inSet.ceiling(redArr[i]) == null){
                    if(leftBlackSet.lower(leftIdx) == null){
                        break;
                    }
                    else{
                        leftIdx = leftBlackSet.lower(leftIdx);
                    }
                    continue;
                }
                else{
                    cnt++;
                    inSet.remove(inSet.ceiling(leftIdx));
                    // System.out.println(redIdx + " " + closedA);
                    if(inSet.isEmpty()){
                        blackMap.remove(leftIdx);
                        leftBlackSet.remove(leftIdx);
                    }
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}