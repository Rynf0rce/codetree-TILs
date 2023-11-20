import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(), cnt = 0;
        String str = sc.next();
        String target = "";
        for(int i = 0 ; i < num ; i++){
            target = sc.nextLine();
            if(str.compareTo(target) == 0){
                cnt++;
            }
        }
        System.out.print(cnt);
    }
}