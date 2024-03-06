import java.util.*;
import java.io.*;

class trieNode{
    trieNode[] children = new trieNode[26];
    boolean isEnd;
    int depth;
    public trieNode(int depth){
        for(int i = 0 ; i < children.length ; i++){
            children[i] = null;
        }
        isEnd = false;
        this.depth = depth;
    }
}

public class Main {
    public static final int MAX_LENGTH = 5000;
    public static String[] strArr = new String[MAX_LENGTH];
    public static HashSet<String> strSet = new HashSet<>();
    public static trieNode root = new trieNode(0);

    public static int findAns(String str){
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String reverseStr = sb.reverse().toString();
        // System.out.println(str + " " + reverseStr);
        if(strSet.contains(sb.reverse().toString()) && !reverseStr.equals(str)){
            return str.length() * 2;
        }

        trieNode t = root;
        int maxDepth = 0;
        for(int i = str.length() - 1 ; i >= 0 ; i--){
            int idx = str.charAt(i) - 'a';
            if(t.children[idx] == null){
                return 0;
            }

            t = t.children[idx];
            if(t.isEnd && t.depth != str.length()){
                maxDepth = t.depth;
            }
        }
        return maxDepth + str.length();
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            strArr[i] = String.valueOf(st.nextToken());
            strSet.add(strArr[i]);
            trieNode t = root;
            for(int j = 0 ; j < strArr[i].length() ; j++){
                int idx = strArr[i].charAt(j) - 'a';
                if(t.children[idx] == null){
                    t.children[idx] = new trieNode(t.depth + 1);
                }
                t = t.children[idx];
            }
            t.isEnd = true;
        }

        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            ans = Math.max(ans, findAns(strArr[i]));
        }

        System.out.print(ans);
    }
}