import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int charNum = 'A';
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n; j++){
                if(j >= i){
                    System.out.print((char)charNum + " ");
                    if(charNum == 'Z'){
                    charNum = 'A';
                    }
                    else{
                        charNum++;
                    }
                }
                else{
                    System.out.print("  ");
                }
                
            }
            System.out.println();
        }
    }
}