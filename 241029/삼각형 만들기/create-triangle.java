import java.util.*;
import java.io.*;

public class Main {
    public static int MAX_POINT = 100;
    public static int[] arrX = new int[MAX_POINT];
    public static int[] arrY = new int[MAX_POINT];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            arrX[i] = Integer.parseInt(st.nextToken());
            arrY[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1 ; j < n ; j++){
                for(int k = j + 1 ; k < n ; k++){
                    if(i == j || j == k || i == k){
                        continue;
                    }

                    if((arrX[i] == arrX[j] || arrX[j] == arrX[k] || arrX[k] == arrX[i]) && (arrY[i] == arrY[j] || arrY[j] == arrY[k] || arrY[k] == arrY[i])){
                        ans = Math.max(ans, (arrX[i] * arrY[j] + arrX[j] * arrY[k] + arrX[k] * arrY[i]) - (arrX[j] * arrY[i] + arrX[i] * arrY[k] + arrX[k] * arrY[j]));
                        // System.out.println(i + " " + j + " " + k + " " + ans);
                    }
                }
            }
        }
        System.out.print(ans);
    }
}