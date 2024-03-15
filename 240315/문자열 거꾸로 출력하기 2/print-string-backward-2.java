import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 30;
    public static char[][] table = new char[MAX_LENGTH][MAX_LENGTH];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            String str = String.valueOf(br.readLine());
            for(int j = 0 ; j < str.length() ; j++){
                table[i][j] = str.charAt(j);
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = MAX_LENGTH - 1 ; j >= 0 ; j--){
                if(table[i][j] == '\0'){
                    continue;
                }
                System.out.print(table[i][j]);
            }
            System.out.println();
        }
    }
}