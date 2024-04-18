import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static Stack<Boolean> s = new Stack<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = String.valueOf(br.readLine());
        int ans = 0;
        for(int i = 0 ; i < str.length() ; i++){
            if(str.charAt(i) =='('){
                s.push(true);
            }
            else{
                if(s.isEmpty()){
                    ans++;
                    s.push(true);
                }
                else{
                    s.pop();
                }
            }
        }
        
        System.out.println(ans + s.size() / 2);
    }
}