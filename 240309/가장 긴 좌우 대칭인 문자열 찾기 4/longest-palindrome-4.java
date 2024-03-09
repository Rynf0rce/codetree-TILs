import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static char[] arr = new char[MAX_LENGTH * 2 + 1];
    public static int length = -1;
    public static int[] A = new int[MAX_LENGTH * 2 + 1];
    
    public static void manacher(){
        // r = Math.max(j + A[j]) ; j is any point; 중심축 + 길이의 최대
        // p = j is satified by Math.max(j + A[j]); 팰린드롬을 만족하는 중심 축.
        int r = -1, p = -1;
        for(int i = 0 ; i < length ; i++){
            // 팰린드롬을 구한 최장 거리 안에 i가 없을 경우
            if(r < i){
                A[i] = 0;
            }
            else{
                // 팰린드롬을 구한 최장 거리 안에 i가 있을 경우.
                // 팰린드롬의 특성상 좌우가 같기 때문에 중심축을 기준으로 i만큼 떨어져 있는 ii의 팰린드롬의 길이를 참고.
                // ii의 팰린드롬은 r - i를 넘기거나(최장거리의 밖의 범위 안에 있거나) 작을 수가 있음(최장 거리 안의 범위 안에 있거나).
                // 그렇기 때문에 탐색 지점을 r - i에서 시작을 하던지 또는 ii의 팰린드롬 길이부터 시작하면 탐색 시간을 줄일수 있음.
                // 떨어지점을 정의 p - a / p / p + a : p + a 를 i라고 하면 p - a = 2 * p - (p + a) = 2 * p - i;
                int ii = 2 * p - i;
                A[i] = Math.min(r - i, A[ii]);
            }

            while(i - A[i] - 1 >= 0 && i + A[i] + 1 < length && arr[i - A[i] - 1] == arr[i + A[i] + 1]){
                A[i]++;
            }

            if(i + A[i] > r){
                r = i + A[i];
                p = i;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = String.valueOf(br.readLine());
        for(int i = 0 ; i < str.length() ; i++){
            arr[i * 2] = '#';
            arr[i * 2 + 1] = str.charAt(i);
        }
        

        length = (str.length()) * 2 + 1;
        arr[length - 1] = '#';
        manacher();

        int ans = 0;
        for(int i = 0 ; i < length ; i++){
            ans = Math.max(ans, A[i] * 2 + 1);
        }
        System.out.print(ans / 2);
    }
}