import java.util.*;

class agent{
        String sCode;
        char mPoint;
        int time;

        public agent(String sCode, char mPoint, int time){
            this.sCode = sCode;
            this.mPoint = mPoint;
            this.time = time;
        }
}

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char spell = sc.next().charAt(0);
        int n = sc.nextInt();
        agent van = new agent(str, spell, n);
        System.out.println("secret code : " + van.sCode);
        System.out.println("meeting point : " + van.mPoint);
        System.out.println("time : " + van.time);
    }
}