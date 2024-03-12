import java.util.*;

public class Main {
    public static void printStar(int num, int type){
        boolean triger = true;
        int cnt = 1;
        switch(type){
            case 1 :
                for(int i = 0 ; i < num ; i++){
                    for(int j = 0 ; j < cnt ; j++){
                        System.out.print("*");
                    }
                    System.out.println();

                    if(i == num / 2){
                        triger = false;
                    }

                    if(triger){
                        cnt++;
                    }
                    else{
                        cnt--;
                    }
                }
                break;
            case 2 :
                for(int i = 0 ; i < num ; i++){
                    for(int j = 0 ; j <= num / 2 ; j++){
                        if(j > num / 2 - cnt){
                            System.out.print("*");
                        }
                        else{
                            System.out.print(" ");
                        }
                    }
                    System.out.println();

                    if(i == num / 2){
                        triger = false;
                    }

                    if(triger){
                        cnt++;
                    }
                    else{
                        cnt--;
                    }
                }
                break;
            case 3 :
                for(int i = 0 ; i < num ; i++){
                    for(int j = 0 ; j < num ; j++){
                        if(j >= cnt - 1 && j <= num - cnt){
                            System.out.print("*");
                        }
                        else{
                            System.out.print(" ");
                        }
                    }
                    System.out.println();

                    if(i == num / 2){
                        triger = false;
                    }

                    if(triger){
                        cnt++;
                    }
                    else{
                        cnt--;
                    }
                }
                break;
            case 4 : 
                for(int i = 0 ; i <= num / 2 ; i++){
                    for(int j = 0 ; j <= num / 2 ; j++){
                        if(j >= cnt - 1){
                            System.out.print("*");
                        }
                        else{
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                    cnt++;
                }

                for(int i = num / 2 + 1; i < num ; i++){
                    for(int j = 0 ; j < cnt ; j++){
                        if(j < num / 2){
                            System.out.print(" ");
                        }
                        else{
                            System.out.print("*");
                        }
                    }
                    cnt++;
                    System.out.println();
                }
                break;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        printStar(n, m);
    }
}