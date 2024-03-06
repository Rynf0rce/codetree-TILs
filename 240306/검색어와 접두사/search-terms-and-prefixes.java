import java.util.*;
import java.io.*;

class trieNode{
    int cnt;
    trieNode[] children = new trieNode[26];
    public trieNode(){
        this.cnt = 1;
        for(int i = 0 ; i < children.length ; i++){
            children[i] = null;
        }
    }
}

public class Main {
    public static final int MAX_OF_ALPHABET = 26;
    public static trieNode root = new trieNode();
    public static StringBuilder sb = new StringBuilder();

    public static void findAns(String str){
        trieNode t = root;
        for(int i = 0 ; i < str.length() ; i++){
            int idx = str.charAt(i) - 'a';
            if(t.children[idx] == null){
                for(int j = i ; j < str.length() ; j++){
                    sb.append(0 + " ");
                }
                break;
            }
            else{
                sb.append(t.children[idx].cnt + " ");
            }
            
            t = t.children[idx];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            String str = String.valueOf(st.nextToken());
            trieNode t = root;
            for(int j = 0 ; j < str.length() ; j++){
                int idx = str.charAt(j) - 'a';
                if(t.children[idx] == null){
                    t.children[idx] = new trieNode();
                }
                else{
                    t.children[idx].cnt++;
                }

                t = t.children[idx];
            }
        }

        findAns(String.valueOf(br.readLine()));
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}