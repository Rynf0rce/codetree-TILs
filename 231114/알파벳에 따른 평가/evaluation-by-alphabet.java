import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char a = sc.next().charAt(0);
        String output = "Effort";
        if(a == 'S'){
            output = "Superior";
        }
        else if(a == 'A'){
            output = "Excellent";
        }
        else if(a == 'B'){
            output = "Good";
        }
        else if(a =='C'){
            output = "Usually";
        }
        System.out.print(output);
    }
}