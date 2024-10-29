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
                    // x 좌표 또는 y 좌표가 두 개 이상 같은지 확인
                    if ((arrX[i] == arrX[j] || arrX[j] == arrX[k] || arrX[k] == arrX[i]) &&
                        (arrY[i] == arrY[j] || arrY[j] == arrY[k] || arrY[k] == arrY[i])) {
                        int area = Math.abs(arrX[i] * (arrY[j] - arrY[k]) +
                                            arrX[j] * (arrY[k] - arrY[i]) +
                                            arrX[k] * (arrY[i] - arrY[j]));
                        ans = Math.max(ans, area);
                    }
                }
            }
        }
        System.out.print(ans); // 넓이를 출력할 때 2로 나누기
    }
}