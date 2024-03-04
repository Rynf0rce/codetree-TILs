import java.util.*;
import java.io.*;

class tuple implements Comparable<tuple>{
    int left, right;
    public tuple(int left, int right){
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(tuple t){
        if(this.right == t.right){
            return this.left - t.left;
        }

        return this.right - t.right;
    }
}

public class Main {
    public static final int MAX_LENGTH = 10000;
    public static int[] f = new int[MAX_LENGTH + 1];
    public static String text = " ";
    public static int textLength = -1;
    public static PriorityQueue<tuple> ansQueue = new PriorityQueue<>();

    public static void KMP(String pattern){
        int patternLength = pattern.length();
        pattern = "#" + pattern;
        
        f[0] = -1;
        for(int i = 1 ; i <= patternLength ; i++){
            int j = f[i - 1];
            while(j >= 0 && pattern.charAt(j + 1) != pattern.charAt(i)){
                j = f[j];
            }
            f[i] = j + 1;
        }

        int j = 0;
        for(int i = 1 ; i <= textLength ; i++){
            while(j >= 0 && pattern.charAt(j + 1) != text.charAt(i)){
                j = f[j];
            }

            j++;

            if(j == patternLength){
                ansQueue.add(new tuple(i - j + 1, i));
                j = f[j];
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        text = String.valueOf(st.nextToken());
        textLength = text.length();
        text = '#' + text;

        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < m ; i++){
            String pattern = String.valueOf(st.nextToken());
            KMP(pattern);
        }

        tuple preTuple = ansQueue.poll();
        int ans = (preTuple.right - preTuple.left + 1);
        while(!ansQueue.isEmpty()){
            tuple curTuple = ansQueue.poll();
            if(preTuple.right >= curTuple.left){
                continue;
            }

            ans += (curTuple.right - curTuple.left + 1);
            preTuple = curTuple;
        }

        System.out.print(ans);
    }
}