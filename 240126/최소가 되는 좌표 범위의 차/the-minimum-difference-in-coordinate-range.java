import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_RANGE = 1000000;
    public static TreeSet<Integer>[] ySet = new TreeSet[MAX_RANGE + 1];
    public static int[] xArr = new int[MAX_RANGE];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(ySet[x] == null){
                ySet[x] = new TreeSet<Integer>();
            }

            ySet[x].add(y);
            xArr[i] = x;
        }

        Arrays.sort(xArr, 0, N);

        int j = 1;
        int minVal = MAX_RANGE + 1;
        for(int i = 0 ; i < N ; i++){
            while(j + 1 < N){
                if(j == i){
                    j++;
                }
                
                if( Math.abs(ySet[xArr[i]].first() - ySet[xArr[j]].last()) >= D || Math.abs(ySet[xArr[i]].last() - ySet[xArr[j]].first()) >= D ){
                    minVal = Math.min(minVal, xArr[j] - xArr[i]);
                    break;
                }
                j++;
            }
        }

        bw.write( (minVal == MAX_RANGE + 1 ? -1 : minVal) + "");

        br.close();
        bw.close();
    }
}