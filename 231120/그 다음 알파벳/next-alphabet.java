import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char input = sc.next().charAt(0);
        if(input == 'z'){
            input = 'a';
        }
        else{
            input = (char)(input + 1);
        }
        System.out.printf("%c", input);
    }
}