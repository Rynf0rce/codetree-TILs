import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n >= 90){
            System.out.print("passed");
        }
        else{
            System.out.printf("need %d more score", 90 - n);
        }
    }
}