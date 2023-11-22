import java.util.*;

class boom{
        String clearCode;
        char color;
        int second;

        public boom(String clearCode, char color, int second){
            this.clearCode = clearCode;
            this.color = color;
            this.second = second;
        }
}

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String code = sc.next();
        char color = sc.next().charAt(0);
        int sec = sc.nextInt();
        boom boom1 = new boom(code, color, sec);
        System.out.println("code : " + boom1.clearCode);
        System.out.println("color : " + boom1.color);
        System.out.println("second : " + boom1.second);
    }
}