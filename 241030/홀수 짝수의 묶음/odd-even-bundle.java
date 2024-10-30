import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int odd = 0;
        int even = 0;
        for(int i = 0 ; i < N ; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num % 2 == 0){
                even++;
            }
            else{
                odd++;
            }
        }

        boolean flag = true;
        int ans = 0;
        while(true){
            // System.out.println(flag + " " + odd + " " + even + " " + ans) ;
            if(flag){
                if(even > 0){
                    even--;
                    ans++;
                }
                else if(odd >= 2){
                    odd -= 2;
                    ans++;
                }
                else{
                    if(odd > 0){
                        ans--;
                    }
                    break;
                }
                flag = false;
            }
            else{
                if(odd > 0){
                    odd--;
                    ans++;
                }
                else{
                    break;
                }
                flag = true;
            }  
        }

        // System.out.println(flag + " " + odd + " " + even + " " + ans);

        System.out.print(ans);


    }
}