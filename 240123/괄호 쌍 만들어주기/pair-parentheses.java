import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] stringArr = br.readLine().toCharArray();
        int[] rightArr = new int[stringArr.length];
        for(int i = stringArr.length - 2 ; i >= 0 ; i--){
            rightArr[i] = rightArr[i + 1];
            if(stringArr[i] == ')' && stringArr[i] == stringArr[i + 1]){
                rightArr[i]++;
            }
        }

        long output = 0;
        for(int i = 1 ; i < stringArr.length ; i++){
            if(stringArr[i] == '(' && stringArr[i] == stringArr[i - 1]){
                output += rightArr[i];
            }
        }

        bw.write(output + " ");
        
        br.close();
        bw.close();
    }
}