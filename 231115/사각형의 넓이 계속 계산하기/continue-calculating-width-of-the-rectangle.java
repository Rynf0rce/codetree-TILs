import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int width = 0, height = 0;
        char decidedChar = ' ';
        while(true){
            width = sc.nextInt();
            height = sc.nextInt();
            decidedChar = sc.next().charAt(0);
            
            System.out.println(width * height);
            if(decidedChar == 'C'){
                break;
            }
        }
    }
}