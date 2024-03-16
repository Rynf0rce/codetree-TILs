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
            for(int j = 0 ; j < str.length() - word.length() + 1 ; j++){
                boolean flag = true;
                for(int k = 0 ; k < word.length() ; k++){
                    if(str.charAt(j + k) != word.charAt(k)){
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    System.out.println(str);
                    break;
                }
            }
        }
    }
}