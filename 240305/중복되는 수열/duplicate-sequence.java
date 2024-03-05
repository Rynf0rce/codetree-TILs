import java.util.*;
import java.io.*;

class trieNode{
    trieNode[] children = new trieNode[10];
    boolean isEnd;
    
    public trieNode(){
        isEnd = false;
        for(int i = 0 ; i < children.length ; i++){
            children[i] = null;
        }
    }
}

public class Main {
    public static trieNode root = new trieNode();
    public static boolean ans = false;

    public static void insertWord(String str){
        trieNode t = root;
        for(int i = 0 ; i < str.length() ; i++){
            int idx = str.charAt(i) - '0';
            if(t.children[idx] == null){
                t.children[idx] = new trieNode();
            }

            if(t.children[idx].isEnd){
                ans = true;
            }

            t = t.children[idx];
        }
        t.isEnd = true;
    }

    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            String str = String.valueOf(br.readLine());
            insertWord(str);
        }

        System.out.println(ans ? 0 : 1);
    }
}