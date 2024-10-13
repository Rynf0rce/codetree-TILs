import java.util.*;
import java.io.*;

class trieNode{
    int cnt;
    int depth;
    trieNode[] children = new trieNode[26];
    
    public trieNode(int depth){
        this.cnt = 1;
        this.depth = depth;
        for(int i = 0 ; i < children.length ; i++){
            children[i] = null;
        }
    }
}

public class Main {
    public static final int MAX_OF_ALPHABET = 26;
    public static trieNode root = new trieNode(0);

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            String str = String.valueOf(st.nextToken());
            trieNode t = root;
            for(int j = 0 ; j < str.length() ; j++){
                int idx = str.charAt(j) - 'a';
                if(t.children[idx] == null){
                    t.children[idx] = new trieNode(t.depth + 1);
                }
                else{
                    t.children[idx].cnt++;
                }
                
                ans = Math.max(ans, t.children[idx].cnt * (t.depth + 1));
                t = t.children[idx];
            }
        }

        System.out.print(ans);
    }
}