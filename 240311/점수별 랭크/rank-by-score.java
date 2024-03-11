import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n >= 90){
            System.out.print("S");
        }
        else if(n >= 80){
            System.out.print("A");
        }
        else if(n >= 70){
            System.out.print("B");
        }
        else if(n >= 60){
            System.out.print("C");
        }
        else{
            System.out.print("F");
        }
    }
}