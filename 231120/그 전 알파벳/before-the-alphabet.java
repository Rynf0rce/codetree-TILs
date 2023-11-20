import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char input = sc.next().charAt(0);
        if(input == 'a'){
            input = 'z';
        }
        else{
            input = (char)(input - 1);
        }
        System.out.printf("%c", input);
    }
}