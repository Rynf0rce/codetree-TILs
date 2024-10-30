import java.util.*;

class bomb{
    String str;
    char c;
    int num;

    public bomb(String str, char c, int num){
        this.str = str;
        this.c = c;
        this.num = num;
    }

    public void print(){
        System.out.println("code : " + str);
        System.out.println("color : " + c);
        System.out.println("second : " + num);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);
        int num = sc.nextInt();
        bomb b = new bomb(str, c, num);
        b.print();
    }
}