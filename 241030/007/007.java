import java.util.*;

class agent{
    String code;
    char place;
    int time;
    public agent(String code, char place, int time){
        this.code = code;
        this.place = place;
        this.time = time;
    }

    public void cerificate(){
        System.out.println("secret code : " + code);
        System.out.println("meeting point : " + place);
        System.out.println("time : " + time);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);
        int num = sc.nextInt();

        agent t = new agent(str, c, num);
        t.cerificate();
    }
}