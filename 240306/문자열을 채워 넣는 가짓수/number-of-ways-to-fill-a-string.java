import java.util.*;
import java.io.*;

class trieNode{
    TreeMap<String, trieNode> children;
    boolean isEnd;
    public trieNode(){
        this.children = new TreeMap<>();
        this.isEnd = false;
    }
}

public class Main {
    public static trieNode root = new trieNode();
    public static ArrayList<String> patternList = new ArrayList<>();
    public static int ans = 0;

    public static void findAns(String str, trieNode t){
        for(int i = 0 ; i < patternList.size() ; i++){
            String pattern = patternList.get(i);
            if( str.length() >= pattern.length() && str.substring(0, pattern.length()).equals(pattern)){
                if(!t.children.containsKey(pattern)){
                    t.children.put(pattern, new trieNode());
                }

                findAns(str.substring(pattern.length()), t.children.get(pattern));
            }
        }

        if(str.length() == 0 && !t.isEnd){
            ans++;
            t.isEnd = true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String T = String.valueOf(st.nextToken());

        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < m ; i++){
            String str = String.valueOf(st.nextToken());
            patternList.add(str);
        }

        findAns(T, root);

        System.out.print(ans);
    }
}