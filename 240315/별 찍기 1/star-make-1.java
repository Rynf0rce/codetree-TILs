import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int type = sc.nextInt();

        switch(type){
            case 1 :
                for(int i = 1 ; i <= n ; i++){
                    for(int j = 1 ; j <= i ; j++){
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
            case 2 :
                for(int i = n - 1 ; i >= 0 ; i--){
                    for(int j = 0 ; j <= i ; j++){
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
            case 3 :
                int center = n;
                for(int i = 0 ; i < n ; i++){
                    for(int j = 1 ; j <= 1 + 2*(n - 1) ; j++){
                        if(center - i <= j && j <= center + i){
                            System.out.print("*");
                        }
                        else{
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
                break;
        }
    }
}