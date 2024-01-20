import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_QUESTION = 100000;
    public static int[] start = new int[MAX_QUESTION];
    public static int[] end = new int[MAX_QUESTION];
    public static boolean[] pointPos = new boolean[MAX_QUESTION + 1];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        TreeSet<Integer> numSet = new TreeSet<>();
        HashSet<Integer> pointSet = new HashSet<>();
        HashMap<Integer, Integer> numMap = new HashMap<>();

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            numSet.add(num);
            pointSet.add(num);
        }

        for(int i = 0 ; i < q ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            start[i] = Integer.parseInt(st.nextToken());
            end[i] = Integer.parseInt(st.nextToken());
            numSet.add(start[i]);
            numSet.add(end[i]);
        }


        int idx = 0;
        for(Integer num : numSet){
            if(pointSet.contains(num)){
                idx++;
            }
            numMap.put(num, idx);
            // System.out.println(num + " " + idx);
        }

        for(int i = 0 ; i < q ; i++){
            if(numMap.get(start[i]) == 0){
                bw.write(numMap.get(end[i]) + "\n");
            }
            else{
                bw.write(numMap.get(end[i]) - numMap.get(numSet.lower(start[i])) + "\n");
            }
        }

        br.close();
        bw.close();
    }
}