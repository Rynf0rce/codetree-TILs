import java.util.*;
import java.io.*;

class black implements Comparable<black>{
    int A;
    int B;

    public black(int A, int B){
        this.A = A;
        this.B = B;
    }

    @Override
    public int compareTo(black b){
        if(this.B == b.B){
            return this.A - b.A;
        }
        else{
            return this.B - b.B;
        }
    }
}

public class Main {
    public static final int MAX_STONE = 100000;
    public static int[] redArr = new int[MAX_STONE];
    public static black[] blackArr = new black[MAX_STONE];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < C ; i++){
            redArr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            blackArr[i] = new black(A, B);
        }

        Arrays.sort(redArr, 0, C);
        Arrays.sort(blackArr, 0, N);

        int j = -1;
        int cnt = 0;
        for(int i = 0 ; i < C ; i++){
            while(j + 1 < N){
                if(blackArr[j + 1].A <= redArr[i] && redArr[i] <= blackArr[j + 1].B){
                    j++;
                    cnt++;
                    break;
                }
                else if(blackArr[j + 1].B < redArr[i]){
                    j++;
                }
                else{
                    break;
                }
            }
        }

        bw.write(cnt + "");

        bw.close();
        br.close();


    }
}