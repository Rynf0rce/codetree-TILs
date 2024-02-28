import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 999;
    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static int[] panIn = new int[MAX_NODE + 1];

    public static PriorityQueue<Integer> rePQ = new PriorityQueue<>(Collections.reverseOrder());
    public static int[] rePanIn = new int[MAX_NODE + 1];
    public static int[] reAns = new int[MAX_NODE + 1];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= n ; i++){
            nodeList[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1 ; i < n ; i++){
            char c = st.nextToken().charAt(0);
            if(c == '<'){
                nodeList[i].add(i + 1);
                panIn[i + 1]++;
                rePanIn[i + 1]++;
            }
            else{
                nodeList[i + 1].add(i);
                panIn[i]++;
                rePanIn[i]++;
            }
        }

        for(int i = 1 ; i <= n ; i++){
            if(panIn[i] == 0){
                pq.add(i);
                rePQ.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            int curIdx = pq.poll();

            String s = String.valueOf(curIdx);
            if(s.length() == 3){
                sb.append(s);
            }
            else if(s.length() == 2){
                sb.append("0" + s);
            }
            else{
                sb.append("00" + s);
            }

            for(int i = 0 ; i < nodeList[curIdx].size() ; i++){
                int postIdx = nodeList[curIdx].get(i);
                panIn[postIdx]--;
                if(panIn[postIdx] == 0){
                    pq.add(postIdx);
                }
            }
        }
        
        sb.append("\n");

        int cnt = 1;
        while(!rePQ.isEmpty()){
            int curIdx = rePQ.poll();

            reAns[curIdx] = cnt++;

            for(int i = 0 ; i < nodeList[curIdx].size() ; i++){
                int postIdx = nodeList[curIdx].get(i);
                rePanIn[postIdx]--;
                if(rePanIn[postIdx] == 0){
                    rePQ.add(postIdx);
                }
            }
        }

        for(int i = 1 ; i <= n ; i++){
            int curIdx = reAns[i];

            String s = String.valueOf(curIdx);
            if(s.length() == 3){
                sb.append(s);
            }
            else if(s.length() == 2){
                sb.append("0" + s);
            }
            else{
                sb.append("00" + s);
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}