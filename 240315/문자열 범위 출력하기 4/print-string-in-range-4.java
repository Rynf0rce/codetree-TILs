import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = String.valueOf(sc.next());
        if(n >= str.length()){
            System.out.print(str);
        }
        else{
            System.out.print(str.substring(0, n));
        }
    }
}