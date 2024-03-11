import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            double width = sc.nextDouble();
            double height = sc.nextDouble();
            char order = sc.next().charAt(0);
            if(order == 's'){
                System.out.println( (int)(width * height) );
            }
            else if(order == 't'){
                System.out.printf("%.1f\n", width * height / 2);
            }
        }
    }
}