import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            int num = sc.nextInt();
            if(num > 0){
                System.out.println("plus");
            }
            else if(num == 0){
                System.out.println("zero");
            }
            else{
                System.out.println("minus");
            }
        }
    }
}