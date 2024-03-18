import java.util.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static void makeArray(int num){
        if(num <= 0){
            return;
        }

        makeArray(num - 2);
        sb.append(num + " ");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        makeArray(n);
        System.out.print(sb.toString());
    }
}