import java.util.*;
import java.io.*;
public class Main {
    public static final int MAX_LENGTH = 10;
    public static char[][] table = new char[MAX_LENGTH][MAX_LENGTH];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < N ; i++){
            String str = String.valueOf(br.readLine());
            for(int j = 0 ; j < M ; j++){
                table[i][j] = str.charAt(j);
            }
        }

        for(int i = 0 ; i < N ; i++){
            for(int h = 0 ; h < K ; h++){
                for(int j = 0 ; j < M ; j++){
                    for(int k = 0 ; k < K ; k++){
                        System.out.print(table[i][j]);
                    }
                }
                System.out.println();
            }
        }
    }
}