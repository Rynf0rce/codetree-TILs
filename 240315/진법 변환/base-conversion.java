import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        int sum = 0;
        for(int i = str.length() - 1 ; i >= 0 ; i--){
            char c = str.charAt(i);
            if(c >= '0' && c <= '9'){
                sum += (c - '0') * (int)Math.pow(n, str.length() - 1 - i);
            }
            else{
                sum += (c - 'A' + 10) * (int)Math.pow(n, str.length() - 1 - i);
            }
        }
        System.out.print(sum);
    }
}