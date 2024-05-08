import java.util.*;
import java.io.*;

class tuple implements Comparable<tuple>{
    int loc;
    boolean infected;

    public tuple(int loc, boolean infected){
        this.loc = loc;
        this.infected = infected;
    }

    @Override
    public int compareTo(tuple t){
        return this.loc - t.loc;
    }
}

public class Main {
    public static final int MAX_PEOPLE = 1000;
    public static int MAX_LOC = 1000000;
    public static tuple[] arr = new tuple[MAX_PEOPLE];
    public static boolean[] selected = new boolean[MAX_PEOPLE];
    public static int N = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int loc = Integer.parseInt(st.nextToken());
            int infect = Integer.parseInt(st.nextToken());
            arr[i] = new tuple(loc, infect == 1 ? true : false);
        }

        Arrays.sort(arr, 0 , N);

        // int limited = MAX_LOC;
        // for(int i = 1 ; i < N ; i++){
        //     if( (arr[i - 1].infected && !arr[i].infected) || (!arr[i - 1].infected && arr[i].infected) ){
        //         limited = Math.min(limited, arr[i].loc - arr[i - 1].loc - 1);
        //     }
        // }
        
        int ans = 0;
        int curNum = 0;
        int cnt = 0;
        for(int i = 0 ; i < N ; i++){
            if(arr[i].infected){
                cnt++;
            }
            else{
                if(cnt == 1){
                    curNum++;
                }
                else{
                    curNum += cnt / 2;
                }
                cnt = 0;
            }
        }

        if(cnt == 1){
            curNum++;
        }
        else{
            curNum += cnt / 2;
        }

        System.out.print(curNum);
        
    }
}