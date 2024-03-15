import java.util.*;
import java.io.*;

public class Main {
    public static char[][] table = new char[5][15];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0 ; i < 5 ; i++){
            String str = String.valueOf(br.readLine());
            for(int j = 0 ; j < str.length(); j++){
                table[i][j] = str.charAt(j);
            }
        }

        for(int j = 0 ; j < 15 ; j++){
            for(int i = 0 ; i < 5 ; i++){
                if(table[i][j] == '\0'){
                    continue;
                }
                System.out.print(table[i][j]);
            }
        }


    }
    
}