import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "";
        while(true){
            input = sc.next();
            if(input.equals("END"))
            {
                break;
            }
            else{
                for(int i = input.length() - 1 ; i >= 0 ; i--){
                    System.out.print(input.charAt(i));
                }
            }
            System.out.println();
        }
    }
}