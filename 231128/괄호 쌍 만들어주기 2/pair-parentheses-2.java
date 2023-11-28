import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] arr = str.toCharArray();
        int cnt = 0;
        for(int i = 0 ; i < arr.length - 3 ; i++){
            if(arr[i] == '(' && arr[i+1] == '('){
                for(int j = i + 2 ; j < arr.length - 1 ; j++){
                    if(arr[j] == ')' && arr[j+1] == ')'){
                        cnt++;
                    }
                }
            }
            
        }
        System.out.println(cnt);
    }
}