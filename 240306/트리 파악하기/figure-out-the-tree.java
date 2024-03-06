import java.util.*;
import java.io.*;

class trieNode{
    TreeMap<String, trieNode> nodeMap;
    int depth;
    
    public trieNode(int depth){
        this.nodeMap = new TreeMap<>();
        this.depth = depth;
    }
}

public class Main {
    public static final String LEVEL = "--";
    public static trieNode root = new trieNode(-1);
    public static StringBuilder sb = new StringBuilder();

    public static void printAns(trieNode t){
        for(String str : t.nodeMap.keySet()){
            for(int i = 0 ; i <= t.depth ; i++){
                sb.append(LEVEL);
            }
            sb.append(str + "\n");
            printAns(t.nodeMap.get(str));
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int k = Integer.parseInt(st.nextToken());
            trieNode t = root;
            for(int j = 0 ; j < k ; j++){
                String str = String.valueOf(st.nextToken());
                if(!t.nodeMap.containsKey(str)){
                    t.nodeMap.put(str, new trieNode(t.depth + 1));
                }

                t = t.nodeMap.get(str);
            }
        }

        printAns(root);
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}