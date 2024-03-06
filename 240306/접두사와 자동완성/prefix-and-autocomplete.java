import java.util.*;
import java.io.*;

class trieNode{
    int cnt;
    trieNode[] children = new trieNode[26];
    public trieNode(){
        this.cnt = 0;
        for(int i = 0 ; i < this.children.length ; i++){
            this.children[i] = null;
        }
    }
}

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static String[] strArr = new String[MAX_LENGTH];
    public static trieNode root = new trieNode();

    public static int findAns(String str){
        int ans = 1;
        trieNode t = root;
        for(int i = 0 ; i < str.length() ; i++){
            int idx = str.charAt(i) - 'a';
            
            t = t.children[idx];
            if(t.cnt > 1 && i != str.length() - 1){
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            strArr[i] = String.valueOf(st.nextToken());
            trieNode t = root;
            for(int j = 0 ; j < strArr[i].length() ; j++){
                int idx = strArr[i].charAt(j) - 'a';
                if(t.children[idx] == null){
                    t.children[idx] = new trieNode();
                    t.cnt++;
                }

                t = t.children[idx];
            }
        }

        for(int i = 0 ; i < n ; i++){
            System.out.print(findAns(strArr[i]) + " ");
        }
    }
}