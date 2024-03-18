import java.util.*;

public class Main {
    public static void recurPrint(int num){ 
        if(num == 0){
            return;
        }

        System.out.print(num + " ");
        if(num % 2 == 0){
            recurPrint(num / 2);
        }
        else{
            recurPrint(num / 3);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        recurPrint(n);
    }
}