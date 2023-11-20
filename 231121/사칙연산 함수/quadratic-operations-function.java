import java.util.*;

public class Main {
    public static int fuc_op(int a, char op, int b){
        switch(op){
            case '+' :
                return a + b;
            case '-' :
                return a - b;
            case '/' :
                return a / b;
            case '*' :
                return a * b;
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        char operator = sc.next().charAt(0);
        int b = sc.nextInt();
        int output = fuc_op(a,operator,b);
        if(output == Integer.MIN_VALUE){
            System.out.print("False");
        }
        else{
            System.out.printf("%d %c %d = %d", a, operator, b, output);
        }
        
    }
}