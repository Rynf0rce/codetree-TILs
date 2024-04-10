import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 5;
    public static final int MIN_INT = (int) 1e9 * -1;
    public static int[][] table = new int[MAX_LENGTH + 1][MAX_LENGTH + 1];
    public static int[][] prefix = new int[MAX_LENGTH + 1][MAX_LENGTH + 1];
    public static int n = -1;
    public static int m = -1;

    public static boolean inRange(int row, int col, int startrow, int startcol, int endrow, int endcol){
        return row >= startrow && col >= startcol && row <= endrow && col <= endcol;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 1 ; i <= n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= m ; j++){
                table[i][j] = Integer.parseInt(st.nextToken());
                prefix[i][j] = table[i][j] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
            }
        }

        int ans = MIN_INT;
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                for(int k = i ; k <= n ; k++){
                    for(int h = j ; h <= m ; h++){

                        int rect1 = prefix[k][h] - prefix[k][j - 1] - prefix[i - 1][h] + prefix[i - 1][j - 1];

                        for(int a = 1 ; a <= n ; a++){
                            for(int b = 1 ; b <= m ; b++){
                                for(int c = a ; c <= n ; c++){
                                    for(int d = b ; d <= m ; d++){

                                        int rect2 = 0;
                                        boolean flag = false;
                                        for(int o = a ; o <= c ; o++){
                                            for(int p = b ; p <= d ; p++){
                                                if(inRange(o, p, i, j, k, h)){
                                                    flag = true;
                                                    break;
                                                }

                                                rect2 += table[o][p];
                                            }

                                            if(flag){
                                                break;
                                            }
                                        }

                                        if(!flag){
                                            ans = Math.max(ans, rect1 + rect2);
                                        }
                                    }
                                }
                            }
                        }

                    }
                }
            }
        }

        System.out.print(ans);


    }
}