import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.next().toCharArray();
        int cnt = 0;
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == 'X'){
                cnt++;
            }
            
            if(arr[i] == '.' || i == arr.length - 1){
                for(int j = 0 ; j < cnt / 4 ; j++){
                    sb.append("aaaa");
                }
                
                cnt -= (cnt / 4) * 4;

                for(int j = 0 ; j < cnt / 2 ; j++){
                    sb.append("bb");
                }
                
                cnt -= (cnt / 2) * 2;

                if(cnt != 0){
                    System.out.print(-1);
                    System.exit(0);
                }

                if(arr[i] == '.'){
                    sb.append(".");
                }
            }
        }
        System.out.print(sb.toString());
    }
}