import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = sc.nextInt();
        for(int i = str.length()-1 ; i >= 0 ; i--){
            if(n > 0){
                System.out.print(str.charAt(i));
            }
            else{
                break;
            }
            n--;
        }
    }
}