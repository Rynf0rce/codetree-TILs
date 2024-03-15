import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            char c = sc.next().charAt(0);
            if(c >= 'A'){
                System.out.println(c);
            }
            else{
                System.out.println((int)c);
            }
        }
    }
}