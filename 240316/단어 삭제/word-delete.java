import java.util.*;
import java.io.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static String word = " ";

    public static void removeString(){
        int idx = 0;
        while(true){
            boolean flag = true;
            for(int i = 0 ; i < sb.length() - word.length() + 1 ; i++){
                if(sb.substring(i, i + word.length()).toString().equals(word)){
                    flag = false;
                    sb.delete(i, i + word.length());
                    break;
                }
            }

            if(flag || sb.length() < word.length()){
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb.append(String.valueOf(br.readLine()));
        word = String.valueOf(br.readLine());

        removeString();
        System.out.print(sb.toString());
    }
}