import java.util.*;
import java.io.*;

class trieNode{
    trieNode[] children = new trieNode[2];
    public trieNode(){
        for(int i = 0 ; i < 2 ; i++){
            children[i] = null;
        }
    }
}

public class Main {
    public static final int MAX_LENGTH = 150000;
    public static final int MAX_DIGIT = 31;
    public static String[] digit = new String[MAX_LENGTH];
    public static trieNode root = new trieNode();

    public static String longToStr(long l){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < MAX_DIGIT ; i++){
            sb.append(l % 2);
            l = l >> 1;
        }
        return sb.reverse().toString();
    }

    public static long findVal(String str){
        long ans = 0;
        int pow = str.length() - 1;
        trieNode t = root;
        for(int i = 0 ; i < str.length() ; i++){
            int idx = str.charAt(i) - '0';
            int op = Math.abs(idx - 1);
            if(t.children[op] == null){
                t = t.children[idx];
            }
            else{
                t = t.children[op];
                ans += Math.pow(2, pow);
            }
            pow--;
        }
        return ans;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            long num = Long.parseLong(st.nextToken());
            digit[i] = longToStr(num);
            trieNode t = root;
            for(int j = 0 ; j < digit[i].length() ; j++){
                int idx = digit[i].charAt(j) - '0';
                if(t.children[idx] == null){
                    t.children[idx] = new trieNode();
                }
                
                t = t.children[idx];
            }
        }

        long ans = 0;
        for(int i = 0 ; i < n ; i++){
            ans = Math.max(ans, findVal(digit[i]));
        }
        System.out.println(ans);
    }
}