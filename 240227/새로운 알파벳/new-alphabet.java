import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_ALPHABET = 26;
    public static final int MAX_WORD = 100;
    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_ALPHABET];
    public static int[] panIn = new int[MAX_ALPHABET];
    public static Queue<Integer> q = new LinkedList<>();
    public static String[] arr = new String[MAX_WORD + 1];
    public static HashSet<Character> alphaSet = new HashSet<>();
    public static HashSet<Integer> inSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0 ; i < MAX_ALPHABET ; i++){
            nodeList[i] = new ArrayList<>();
        }

        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            arr[i] = br.readLine().toString();
            for(int j = 0 ; j < arr[i].length() ; j++){
                alphaSet.add(arr[i].charAt(j));
            }
        }

        for(int i = 1 ; i < n ; i++){
            char[] preArr = arr[i - 1].toCharArray();
            char[] curArr = arr[i].toCharArray();

            for(int j = 0 ; j < Math.min(preArr.length, curArr.length) ; j++){
                if(preArr[j] != curArr[j]){
                    nodeList[preArr[j] - 'a'].add(curArr[j] - 'a');
                    inSet.add(preArr[j] - 'a');
                    panIn[curArr[j] - 'a']++;
                    break;
                }
            }
        }

        if(alphaSet.size() == 1){
            System.out.print(arr[0].charAt(0));
            System.exit(0);
        }

        for(int idx : inSet){
            if(panIn[idx] == 0){
                q.add(idx);
            }
        }

        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            if(q.size() > 1){
                flag = true;
            }
            int curIdx = q.poll();
            sb.append((char)('a'+ curIdx));
            alphaSet.remove((char)('a' + curIdx));
            for(int i = 0 ; i < nodeList[curIdx].size() ; i++){
                int postIdx = nodeList[curIdx].get(i);
                panIn[postIdx]--;
                if(panIn[postIdx] == 0){
                    q.add(postIdx);
                }
            }
        }

        for(int i = 0 ; i < MAX_ALPHABET ; i++){
            if(panIn[i] > 0){
                System.out.print(-1);
                System.exit(0);
            }
        }

        System.out.print( !alphaSet.isEmpty() || flag ? "inf" : sb.toString());
    }
}