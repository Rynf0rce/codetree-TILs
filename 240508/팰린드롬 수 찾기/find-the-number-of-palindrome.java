import java.util.*;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int ans = 0;
        for(int i = X ; i <= Y ; i++){
            char[] arr = String.valueOf(i).toCharArray();
            int a = 0;
            int b = arr.length - 1;
            boolean flag = true;
            while(a < b){
                if(arr[a] != arr[b]){
                    flag = false;
                    break;
                }
                a++;
                b--;
            }

            if(flag){
                ans++;
            }
        }
        System.out.print(ans);
    }
}