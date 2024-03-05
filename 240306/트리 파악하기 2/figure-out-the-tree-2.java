import java.util.*;
import java.io.*;

class trieNode{
    trieNode[] children = new trieNode[26];
    int depth;

    public trieNode(int depth){
        this.depth = depth;
        for(int i = 0 ; i < 26 ; i++){
            children[i] = null;
        }
    }
}

public class Main {
    public static final int NUM_OF_ALPHABET = 26;
    public static trieNode root = new trieNode(-1);
    public static String level = "--";
    public static StringBuilder sb = new StringBuilder();

    public static void DFS(trieNode t){
        for(int i = 0 ; i < t.children.length ; i++){
            if(t.children[i] != null){
                for(int j = 1 ; j <= t.children[i].depth ; j++){
                    sb.append(level);
                }
                sb.append((char)(i + 'A') + "\n");
                DFS(t.children[i]);
            }
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
                char spell = st.nextToken().charAt(0);
                int idx = spell - 'A';
                if(t.children[idx] == null){
                    t.children[idx] = new trieNode(t.depth + 1);
                }

                t = t.children[idx];
            }
        }

        DFS(root);
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}