import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 1;
        int dValue = n;
        while(true){
            dValue /= i;
            if(dValue <= 1){
                break;
            }
            i++;
        }
        System.out.print(i);
    }
}