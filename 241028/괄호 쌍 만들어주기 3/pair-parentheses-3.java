import java.util.*;
import java.io.*;

public class Main {
    public static Stack<Boolean> s = new Stack<>();
    public static int count = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String inputString = br.readLine();
        for(int i = 0 ; i < inputString.length() ; i++){
            char c = inputString.charAt(i);
            if(c == '('){
                s.push(true);
            }
            else{
                s.push(false);
            }
        }

        int ans = 0;
        while(!s.isEmpty()){
            if(s.pop()){
                ans += count;
            }
            else{
                count++;
            }
        }
        bw.write(ans + "");
        bw.close();
    }
}