import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_RANGE = 1000000;
    public static TreeSet<Integer>[] xSet = new TreeSet[MAX_RANGE + 1];
    public static int[] xArr = new int[MAX_RANGE];
    public static int D;

    public static boolean inRange(int x1, int x2){
        if(x1 > x2){
            return false;
        }
        
        if(xSet[x2].last() - xSet[x1].first() >= D){
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(xSet[x] == null){
                xSet[x] = new TreeSet<Integer>();
            }

            xSet[x].add(y);
            xArr[i] = x;
        }

        Arrays.sort(xArr, 0, N);

        int j = 0;
        int minVal = MAX_RANGE + 1;
        for(int i = 0 ; i < N ; i++){
            while(j + 1 < N){
                if(inRange(xArr[i], xArr[j + 1])){
                    minVal = Math.min(minVal, xArr[j + 1] - xArr[i]);
                    break;
                }
                j++;
            }
        }

        bw.write(minVal + "");

        br.close();
        bw.close();
    }
}