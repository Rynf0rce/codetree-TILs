import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        String word = String.valueOf(st.nextToken());
        for(int i = 0 ; i < n ; i++){
            String str = String.valueOf(br.readLine());
            int k = 0;
            for(int j = 0 ; j < str.length() ; j++){
                if(str.charAt(j) == word.charAt(k)){
                    k++;
                }
                else{
                    k = 0;
                }

                if(k >= word.length()){
                    System.out.println(str);
                    break;
                }
            }
        }
    }
}