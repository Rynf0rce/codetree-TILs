import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_CASE = 50;
    public static final int MAX_LENGTH = 500;
    public static char[][] table = new char[MAX_CASE * 2][MAX_LENGTH];
    public static HashSet<String> hs = new HashSet<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < N * 2 ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < M ; j++){
                table[i][j] = str.charAt(j);
            }
        }
        
        int ans = 0;
        for(int i = 0 ; i < M ; i++){
            for(int j = i + 1 ; j < M ; j++){
                for(int k = j + 1 ; k < M ; k++){
                    boolean flag = true;
                    for(int h = 0 ; h < N ; h++){
                        hs.add(new String(table[h][i] + table[h][j] + table[h][k] + ""));
                    }

                    for(int h = N ; h < 2 * N ; h++){
                        if(hs.contains(new String(table[h][i] + table[h][j] + table[h][k] + ""))){
                            flag = false;
                            break;
                        }
                    }

                    if(flag){
                        ans++;
                    }
                    hs.clear();
                }
            }
        }
        System.out.print(ans);
    }
}